package com.momen.cppproject.Lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.activity_iostream.*

class Iostream : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iostream)

        btnIostream.setOnClickListener {

            if (txtIostream.text.isNotEmpty()) {

                var colons = '"'
                val text = txtIostream.text.toString()
                var after = text.replace(" ", "")
                var after2 = after.toLowerCase()
                var after3 = after2.replace(colons, '!')
                var trueText = "cout<<!mydateofbirthis1996!<<dateofbirth;"



                if (after3 == trueText) {
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, after3, Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this , "Enter the code " , Toast.LENGTH_LONG).show()
            }


        }
    }
}
