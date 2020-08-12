package com.momen.cppproject.Authentication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.momen.cppproject.MainActivity
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import model.Users
import java.lang.Exception

class SignUp : AppCompatActivity() , TextWatcher {

    var myShared : SharedPreferences ? = null
    var Email : String ? = null

    private val mAuth : FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private val fireStoreInstance : FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //Text Watcher
        txtUserNameSignUp.addTextChangedListener(this@SignUp)
        txtEmailSignUp.addTextChangedListener(this@SignUp)
        txtPasswordSignUp.addTextChangedListener(this@SignUp)
        btnSignUp.setOnClickListener {
            progressBarSignUp.visibility = View.VISIBLE
            //values of email and password edit texts
            var email = txtEmailSignUp.text.toString()
            var password = txtPasswordSignUp.text.toString()
            val name : String = txtUserNameSignUp.text.toString()
            //Save to Shared prefrences
            Email = email
            val sharedPref : SharedPreferences = getSharedPreferences("saving" , Context.MODE_PRIVATE)
            val Editor : SharedPreferences.Editor = sharedPref.edit()
            Editor.putString("email" , Email)
            Editor.apply()
            ////////
            myShared = getSharedPreferences("userNameFile" , 0 )
            var editor : SharedPreferences.Editor = myShared!!.edit()
            editor.putString("userName" , name)
            editor.commit()
            //Check the edit texts to make sure they are not empty
            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()){
                //create user with fireBase
                mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener {
                    //Check if the connection established or not
                    if (it.isSuccessful){
                        //Cleaning edit texts
                        txtEmailSignUp.text = null
                        txtPasswordSignUp.text = null
                        progressBarSignUp.visibility = View.INVISIBLE
                        val handler = Handler()
                        handler.postDelayed({
                            val currentUserDocRef = fireStoreInstance.collection("users")
                                .document(mAuth.currentUser!!.uid)
                            //New user
                            val newUser = Users(name, " " , "")
                            currentUserDocRef.set(newUser)
                            finish()
                        },6000)
                        //Moving to the main activity
                        val handler2 = Handler()
                        handler2.postDelayed({
                            val intent = Intent(this , MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                        },1000)
                    }else{
                        Toast.makeText(this@SignUp , it.exception?.message , Toast.LENGTH_LONG).show()
                        progressBarSignUp.visibility = View.INVISIBLE
                    }
                }
            }else{
                Toast.makeText(this@SignUp , "Fill all the fields " , Toast.LENGTH_LONG).show()
                progressBarSignUp.visibility = View.INVISIBLE
            }
        }
    }
    //Text Watcher functions
    override fun afterTextChanged(s: Editable?) {
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        btnSignUp.isEnabled = txtUserNameSignUp.text.isNotEmpty() && txtEmailSignUp.text.isNotEmpty() &&
                txtPasswordSignUp.text.isNotEmpty()
    }
}

