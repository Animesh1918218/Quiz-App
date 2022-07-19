package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart:Button = findViewById(R.id.buttonstrt)
        val enteredName:EditText = findViewById(R.id.textedit)
        btnStart.setOnClickListener {
            if(enteredName.text.isEmpty()){
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
            }
            else{
                  val intent = Intent(this,quiz1activity::class.java)
                  enteredName?.text?.let {
                      intent.putExtra(Questions.USER_NAME,it.toString())
                  }
                  startActivity(intent)
                  finish()
            }
        }
    }
}