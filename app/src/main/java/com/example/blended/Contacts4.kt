package com.example.blended

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_contacts4.*


class Contacts4 : AppCompatActivity() {

    //In Kotlin `var` is used to declare a mutable variable. On the other hand
    //`internal` means a variable is visible within a given module.
    internal var dbHelper = DatabaseHelper(this)
    lateinit var txtView: TextView





    /**
     * Let's create a function to show Toast message
     */
    fun showToast(text: String){
        Toast.makeText(this@Contacts4, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Let's create a function to show an alert dialog with data dialog.
     */
    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    /**
     * Let's create a method to clear our edittexts
     */
    fun clearEditTexts(){
        nameTxt.setText("")
        addressTxt.setText("")
        dobTxt.setText("")

        idTxt.setText("")

    }

    /**
     * Let's override our onCreate method.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts4)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()


        // txtView = findViewById(R.id.txtView)
    }

    /**
     * When our handleInserts button is clicked.
     */
    fun handleInserts() {
        insertBtn.setOnClickListener {
            try {
                dbHelper.insertData(nameTxt.text.toString(),addressTxt.text.toString(),
                    dobTxt.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * When our handleUpdates data button is clicked
     */
    fun handleUpdates() {
        updateBtn.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(idTxt.text.toString(),
                    nameTxt.text.toString(),
                    addressTxt.text.toString(), dobTxt.text.toString())
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data Not Updated")
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * When our handleDeletes button is clicked
     */
    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData(idTxt.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * When our View All is clicked
     */
    fun handleViewing() {



        viewBtn.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {


                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NAME :" + res.getString(1) + "\n")
                    buffer.append("ADDRESS :" + res.getString(2) + "\n")
                    buffer.append("DOB :" + res.getString(3) + "\n\n")


                }

                showDialog("CONTACTS", buffer.toString())

            }
        )
    }

}

