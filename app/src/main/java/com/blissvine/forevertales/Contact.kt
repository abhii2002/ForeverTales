package com.blissvine.forevertales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_contact_us.*

class Contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        setSupportActionBar(contactToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        contactToolbar.title = "Contact Us"
        actionBar?.title = "Contact Us"

        contactToolbar.setNavigationOnClickListener{
             onBackPressed()
        }

        button_send_message.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val name: String = et_name.text.toString()
        val email: String = et_email.text.toString()
        val message: String = et_message.text.toString()

        if (validateForm(name, email, message)) {
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateForm(name: String, email: String, message: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter a name")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter an email address")
                false
            }
            TextUtils.isEmpty(message) -> {
                showErrorSnackBar("Please enter your message")
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun showErrorSnackBar(message: String) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.snackbar_error_color
            )
        )
        snackBar.show()
    }
}