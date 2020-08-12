package com.momen.cppproject.Authentication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.momen.cppproject.MainActivity
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() , TextWatcher{
    var Email : String ? = null
    var mAuth : FirebaseAuth ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Text Watcher listener
        txtEmailLogin.addTextChangedListener(this@Login)
        txtPasswordLogin.addTextChangedListener(this@Login)
        mAuth = FirebaseAuth.getInstance()
        btnLogin.setOnClickListener {
            //Progress bar display
            ProgressBarLogin.visibility = View.VISIBLE
            //Email and password
            val EmailAdrees : String = txtEmailLogin.text.toString()
            val Password : String = txtPasswordLogin.text.toString()
            Email = EmailAdrees
            //Save to Shared prefrences
            val sharedPref : SharedPreferences = getSharedPreferences("saving" , Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPref.edit()
            editor.putString("email" , Email)
            editor.apply()
            //Login
            if (EmailAdrees.isNotEmpty() && Password.isNotEmpty()) {
                mAuth?.signInWithEmailAndPassword(EmailAdrees, Password)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        ProgressBarLogin.visibility = View.INVISIBLE
                            val intent = Intent(this , MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                    }else{
                        Toast.makeText(this@Login , it.exception?.message.toString() , Toast.LENGTH_LONG).show()
                        ProgressBarLogin.visibility = View.INVISIBLE
                    }
                }
            }else{
                ProgressBarLogin.visibility = View.INVISIBLE
                Toast.makeText(this@Login , "Email address or password is empty" , Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun afterTextChanged(s: Editable?) {
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        btnLogin.isEnabled = txtEmailLogin.text.isNotEmpty() && txtPasswordLogin.text.isNotEmpty()
    }
}
