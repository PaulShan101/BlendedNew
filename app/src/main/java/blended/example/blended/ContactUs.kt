package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class ContactUs : AppCompatActivity() {
    private var mEditTextTo: EditText? = null
    private var mEditTextSubject: EditText? = null
    private var mEditTextMessage: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactus)
        mEditTextTo = findViewById(R.id.edit_text_to)
        mEditTextSubject = findViewById(R.id.edit_text_subject)
        mEditTextMessage = findViewById(R.id.edit_text_message)
        val buttonSend = findViewById<Button>(R.id.button_send)
        buttonSend.setOnClickListener { sendMail() }
    }

    //sending an email new master update
    private fun sendMail() {
        val recipientList = mEditTextTo!!.text.toString()
        val recipients = recipientList.split(",".toRegex()).toTypedArray()
        val subject = mEditTextSubject!!.text.toString()
        val message = mEditTextMessage!!.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, recipients)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, "Choose an email client"))
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
                val intent = Intent(this@ContactUs, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@ContactUs, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@ContactUs, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@ContactUs, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@ContactUs, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@ContactUs, ContactUs::class.java)
                startActivity(intent)

            }
            R.id.bmi1 -> {
                val intent = Intent(this@ContactUs, BMIActivity::class.java)
                startActivity(intent)

            }
            R.id.diary1 -> {
                val intent = Intent(this@ContactUs, DiaryActivity::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}
