package com.momen.cppproject.ui.sign_out

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.momen.cppproject.Authentication.welcomeScreen

class ShareFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Signing out from the account

        FirebaseAuth.getInstance().signOut()
        var intent = Intent(this.context , welcomeScreen::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)

    }



}