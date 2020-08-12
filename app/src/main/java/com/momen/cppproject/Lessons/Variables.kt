package com.momen.cppproject.Lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_variables.*

class Variables : AppCompatActivity() {

    var text : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_variables)




        btnVariables.setOnClickListener {

            if (txtVariables.text.isNotEmpty()) {

                text = txtVariables.text.toString()
                var after = text!!.replace(" ", "")
                var after2 = after.toLowerCase()

                if (after2 == "doublenumber=10;") {
                    Toast.makeText(this, "Good answer , correct ", Toast.LENGTH_LONG).show()
                } else if (after2 == "doublenumber;" + "\n" +
                    "number=10;"
                ) {
                    Toast.makeText(this, "Good answer , correct ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Wrong answer", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this , "Enter the code " , Toast.LENGTH_LONG).show()
            }




        }
    }
}
