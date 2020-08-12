package com.momen.cppproject.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.momen.cppproject.Lessons.General_Structure
import com.momen.cppproject.Lessons.Introduction
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_welcom_screen.*

class welcomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom_screen)

        btnWelcomeLogin.setOnClickListener {

            val intent = Intent(this@welcomeScreen , Login::class.java)
            startActivity(intent)
        }
        btnWelcomeSignUp.setOnClickListener {

            val intent = Intent(this@welcomeScreen , SignUp::class.java)
            startActivity(intent)

        }

    }
}
