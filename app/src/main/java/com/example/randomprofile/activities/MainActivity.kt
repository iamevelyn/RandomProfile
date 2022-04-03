package com.example.randomprofile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.randomprofile.R

class MainActivity : AppCompatActivity() {

    lateinit var btNext: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        SetControls()
        SetEvents()
    }

    fun SetControls()
    {
        btNext = findViewById<View>(R.id.btNext) as Button

    }


    fun SetEvents()
    {
        btNext!!.setOnClickListener{

            try {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                e.localizedMessage

            }
        }



    }







}