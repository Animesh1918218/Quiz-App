package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result_activity : AppCompatActivity() {
    private var finishbtn:Button?=null
    private var startAgain:Button?=null
    private var userName:TextView?=null
    private var score:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        userName=findViewById(R.id.username)
        score=findViewById(R.id.score)
        finishbtn=findViewById(R.id.finishbtn)
        startAgain=findViewById(R.id.startagainbtn)
        userName?.text=intent.getStringExtra(Questions.USER_NAME)
        score?.text="Your Total Score : ${intent.getStringExtra(Questions.totalRightAnswers)}/${intent.getStringExtra(Questions.totalQuestions)}"

        finishbtn?.setOnClickListener {
            finish()
        }
        startAgain?.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}