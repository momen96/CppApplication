package com.momen.cppproject.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.errorprone.annotations.Var
import com.google.firebase.auth.FirebaseAuth
import com.momen.cppproject.Authentication.welcomeScreen
import com.momen.cppproject.Lessons.*
import com.momen.cppproject.MainActivity
import com.momen.cppproject.R
import com.momen.cppproject.ui.home.HomeFragment

class SplashScreen : AppCompatActivity() {

    var mAuth : FirebaseAuth ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //fireBase configurations
        mAuth = FirebaseAuth.getInstance()
        //splash screen configurations
        val handler = Handler()
            handler.postDelayed({
            //check if the user loged in or not
            if (mAuth?.currentUser == null){
                val intent = Intent(this@SplashScreen , welcomeScreen::class.java)
                startActivity(intent)
            }else{
                var intent = Intent(this@SplashScreen , MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 3000)
        // End here !!
    }
}


