package com.momen.cppproject.Lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_math.*

class MathmaticOperations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)


        btnMath.setOnClickListener {

            val text = txtMath.text.toString()
            val text2 = text.toLowerCase()
            val text3 = text2.replace(" " , "")

            if (text3 == "intnum=sqrt(16);"){
                Toast.makeText(this , "Correct" , Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this , "Wrong" , Toast.LENGTH_LONG).show()
            }



        }

    }
}
