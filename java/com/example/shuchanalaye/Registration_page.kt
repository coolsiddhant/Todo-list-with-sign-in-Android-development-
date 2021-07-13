package com.example.shuchanalaye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Registration_page : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etPhone: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "0123456789"
    val validEmail = "walish"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        title = "Log in"


        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogin = findViewById(R.id.btnLogin)



        btnLogin.setOnClickListener{

            val mobilenumber = etPhone.text.toString()
            val emailtyped = etEmail.text.toString()

            if ((mobilenumber == validMobileNumber) && emailtyped == validEmail ){
                val intent = Intent(this@Registration_page, Homepage::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this@Registration_page,
                        "Kya Habibi galat type kar deti",
                        Toast.LENGTH_LONG).show()
            }
            }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}



