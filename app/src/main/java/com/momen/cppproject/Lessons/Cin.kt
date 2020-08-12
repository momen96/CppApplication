package com.momen.cppproject.Lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_cin.*

class Cin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cin)


        btnCin.setOnClickListener {

            val text = txtCin.text.toString()
            val text2 = text.toLowerCase()
            val text3 = text2.replace(" " , "")


            if (text3 == "cin>>x>>y;"){
                Toast.makeText(this , "Correct answer" , Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this , "Wrong answer" , Toast.LENGTH_LONG).show()
            }



        }
    }
}
