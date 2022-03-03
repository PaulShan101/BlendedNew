package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.blended.Diary.DiaryActivity
import com.example.blended.Lists.CalorieMainList
import kotlinx.android.synthetic.main.activity_bmi1.*

import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object {
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW" // Metric Unit View
        private const val US_UNITS_VIEW = "US_UNIT_VIEW" // US Unit View
    }

    private var currentVisibleView: String =
            METRIC_UNITS_VIEW // A variable to hold a value to make visible a selected view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi1)



        makeVisibleMetricUnitsView()

        // Radio Group change listener is set to the radio group which is added in XML.
        rgUnits.setOnCheckedChangeListener { radioGroup: RadioGroup, checkedId: Int ->

            // Here is the checkId is METRIC UNITS view then make the view visible else US UNITS view.
            if (checkedId == R.id.rbMetricUnits) {
                makeVisibleMetricUnitsView()
            } else {
                makeVisibleUsUnitsView()
            }
        }

        // Button will calculate the input values in Metric Units
        btnCalculateUnits.setOnClickListener {

            if (currentVisibleView.equals(METRIC_UNITS_VIEW)) {
                // The values are validated.
                if (validateMetricUnits()) {

                    // The height value in converted to float value and divided by 100 to convert it to meter.
                    val heightValue: Float = etMetricUnitHeight.text.toString().toFloat() / 100

                    // The weight value in converted to float value
                    val weightValue: Float = etMetricUnitWeight.text.toString().toFloat()

                    // BMI value is calculated in METRIC UNITS using the height and weight value.
                    val bmi = weightValue / (heightValue * heightValue)

                    displayBMIResult(bmi)
                } else {
                    Toast.makeText(
                            this@BMIActivity,
                            "Please enter valid values.",
                            Toast.LENGTH_SHORT
                    )
                            .show()
                }
            } else {

                // The values are validated.
                if (validateUsUnits()) {

                    val usUnitHeightValueFeet: String =
                            etUsUnitHeightFeet.text.toString() // Height Feet value entered in EditText component.
                    val usUnitHeightValueInch: String =
                            etUsUnitHeightInch.text.toString() // Height Inch value entered in EditText component.
                    val usUnitWeightValue: Float = etUsUnitWeight.text.toString()
                            .toFloat() // Weight value entered in EditText component.

                    // Here the Height Feet and Inch values are merged and multiplied by 12 for converting it to inches.
                    val heightValue =
                            usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12

                    // This is the Formula for US UNITS result.
                    // Reference Link : https://www.cdc.gov/healthyweight/assessing/bmi/childrens_bmi/childrens_bmi_formula.html
                    val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))

                    displayBMIResult(bmi) // Displaying the result into UI
                } else {
                    Toast.makeText(
                            this@BMIActivity,
                            "Please enter valid values.",
                            Toast.LENGTH_SHORT
                    )
                            .show()
                }
            }
        }
    }

    /**
     * Function is used to make visible the METRIC UNITS VIEW and hide the US UNITS VIEW.
     */
    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNITS_VIEW // Current View is updated here.
        llMetricUnitsView.visibility = View.VISIBLE // METRIC UNITS VIEW is Visible
        llUsUnitsView.visibility = View.GONE // US UNITS VIEW is hidden

        etMetricUnitHeight.text!!.clear() // height value is cleared if it is added.
        etMetricUnitWeight.text!!.clear() // weight value is cleared if it is added.

        tvYourBMI.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIValue.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIType.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIDescription.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
    }

    /**
     * Function is used to make visible the US UNITS VIEW and hide the METRIC UNITS VIEW.
     */
    private fun makeVisibleUsUnitsView() {
        currentVisibleView = US_UNITS_VIEW // Current View is updated here.
        llMetricUnitsView.visibility = View.GONE // METRIC UNITS VIEW is hidden
        llUsUnitsView.visibility = View.VISIBLE // US UNITS VIEW is Visible

        etUsUnitWeight.text!!.clear() // weight value is cleared if it is added.
        etUsUnitHeightFeet.text!!.clear() // height feet value is cleared if it is added.
        etUsUnitHeightInch.text!!.clear() // height inch is cleared if it is added.

        tvYourBMI.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIValue.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIType.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
        tvBMIDescription.visibility = View.INVISIBLE // Result is cleared and the labels are hidden
    }

    /**
     * Function is used to validate the input values for METRIC UNITS.
     */
    private fun validateMetricUnits(): Boolean {
        var isValid = true

        if (etMetricUnitWeight.text.toString().isEmpty()) {
            isValid = false
        } else if (etMetricUnitHeight.text.toString().isEmpty()) {
            isValid = false
        }

        return isValid
    }

    /**
     * Function is used to validate the input values for US UNITS.
     */
    private fun validateUsUnits(): Boolean {
        var isValid = true

        if (etUsUnitWeight.text.toString().isEmpty()) {
            isValid = false
        } else if (etUsUnitHeightFeet.text.toString().isEmpty()) {
            isValid = false
        } else if (etUsUnitHeightInch.text.toString().isEmpty()) {
            isValid = false
        }

        return isValid
    }

    /**
     * Function is used to display the result of METRIC UNITS.
     */
    private fun displayBMIResult(bmi: Float) {

        val bmiLabel: String
        val bmiDescription: String

        if (java.lang.Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Add alot more Calories to your Diet"
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(
                        bmi,
                        16f
                ) <= 0
        ) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Add some calories to your Diet "
        } else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(
                        bmi,
                        18.5f
                ) <= 0
        ) {
            bmiLabel = "Underweight"
            bmiDescription = "You need more calories"
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(
                        bmi,
                        25f
                ) <= 0
        ) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! you are a healthy weignt. Maintain your Diet"
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(
                        bmi,
                        30f
                ) <= 0
        ) {
            bmiLabel = "Overweight"
            bmiDescription = "Reduce calories from your diet"
        } else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(
                        bmi,
                        35f
                ) <= 0
        ) {
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Reduce soem calories from your Diet"
        } else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(
                        bmi,
                        40f
                ) <= 0
        ) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "Reduce alot of calories from your Diet"
        } else {
            bmiLabel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "Reduce alot of calories from your Diet"
        }

        tvYourBMI.visibility = View.VISIBLE
        tvBMIValue.visibility = View.VISIBLE
        tvBMIType.visibility = View.VISIBLE
        tvBMIDescription.visibility = View.VISIBLE

        // This is used to round of the result value to 2 decimal values after "."
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text = bmiValue // Value is set to TextView
        tvBMIType.text = bmiLabel // Label is set to TextView
        tvBMIDescription.text = bmiDescription // Description is set to TextView
    }


    //menu for the page
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this@BMIActivity, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@BMIActivity, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@BMIActivity, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@BMIActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@BMIActivity, History::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@BMIActivity, ContactUs::class.java)
                startActivity(intent)

            }
            R.id.bmi1 -> {
                val intent = Intent(this@BMIActivity, BMIActivity::class.java)
                startActivity(intent)

            }
            R.id.diary1 -> {
                val intent = Intent(this@BMIActivity, DiaryActivity::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }
}




