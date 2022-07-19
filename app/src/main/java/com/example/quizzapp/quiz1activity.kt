package com.example.quizzapp

import android.content.Intent
import android.graphics.Typeface
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.widget.ImageViewCompat
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import kotlin.math.log

class quiz1activity : AppCompatActivity(),View.OnClickListener {
    private var myQuestions:ArrayList<quizRequirements>?=null
    private var myRemainingButtons :ArrayList<TextView>?= ArrayList()
    private var ques1:TextView?=null
    private var mycurrentPosition:Int =1
    private var isOptionSelected =false
    private var previousPosition:Int =1
    private var ques2:TextView?=null
    private var totalCorrectAnswers:Int=0
    private var isSubmitButtonPressed =false
    private var mySelectedButton:TextView?=null
    private var ques3:TextView?=null
    private var ques4:TextView?=null
    private var mediaplayer:MediaPlayer?=null
    private var submitbtn:Button?=null
    private var imgbtn:ShapeableImageView?=null
    private var  quetionLayout:TextView?=null
    private var myUserName:String?=null
    private var progresbar:ProgressBar?=null
    private var mediaPlayerWrongAnswer:MediaPlayer?=null
    private var progressCounter:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1activity)
        myQuestions = Questions.getQuestions()
        ques1 =findViewById(R.id.ques1)
        ques2 =findViewById(R.id.ques2)
        ques3 =findViewById(R.id.ques3)
        ques4 =findViewById(R.id.ques4)
        submitbtn =findViewById(R.id.submitbtn)
        imgbtn = findViewById(R.id.questionimage)
        quetionLayout =findViewById(R.id.queslayout)
        progresbar=findViewById(R.id.progressbar)
       progressCounter=findViewById(R.id.progresscounter)
        ques1?.setOnClickListener(this)
        ques2?.setOnClickListener(this)
        ques3?.setOnClickListener(this)
        ques4?.setOnClickListener(this)
         submitbtn?.setOnClickListener(this)
         myUserName = intent.getStringExtra(Questions.USER_NAME)
        mediaplayer = MediaPlayer.create(this,R.raw.correctanswer)
        mediaPlayerWrongAnswer= MediaPlayer.create(this,R.raw.wronganswer)
        ques1?.let {
            myRemainingButtons?.add(it)
        }
        ques2?.let {
            myRemainingButtons?.add(it)
        }
        ques3?.let {
            myRemainingButtons?.add(it)
        }
        ques4?.let {
            myRemainingButtons?.add(it)
        }

        setQuestion()


    }





    fun setQuestion(){
           val mycurrentQuestion = myQuestions!![mycurrentPosition-1]
           progresbar?.progress = mycurrentPosition
           progressCounter?.text="${mycurrentPosition}/${progresbar?.max}"
           imgbtn?.setBackgroundResource(mycurrentQuestion.image)
           ques1?.text = mycurrentQuestion.opt1
        ques2?.text = mycurrentQuestion.opt2
        ques3?.text = mycurrentQuestion.opt3
        ques4?.text = mycurrentQuestion.opt4
        submitbtn?.text="SUBMIT"
        quetionLayout?.text =mycurrentQuestion.question
        mySelectedButton=null
        isOptionSelected=false

        setDefaultOptions()

    }



    fun setDefaultOptions(){
        myRemainingButtons?.let {
            for (text in it) {
                if (text == mySelectedButton)
                    continue
                text.setBackgroundResource(R.drawable.my_own_background)
                text.typeface = Typeface.DEFAULT
            }
        }
    }




  fun displayAnswer(){
     mySelectedButton?.text?.let {
         if(it.toString().equals(myQuestions!![mycurrentPosition-1].correctAnswer)){
             mySelectedButton?.setBackgroundResource(R.drawable.right_answer)
             mySelectedButton?.setTypeface(mySelectedButton?.typeface,Typeface.BOLD)
             totalCorrectAnswers++
             mediaplayer?.start()
         }
         else{
             mySelectedButton?.setBackgroundResource(R.drawable.wrong_answer)
             mySelectedButton?.setTypeface(mySelectedButton?.typeface,Typeface.BOLD)
             myRemainingButtons?.let {
                 for(text in it){
                     if(text.text.toString().equals(myQuestions!![mycurrentPosition-1].correctAnswer)){
                         text.setBackgroundResource(R.drawable.right_answer)
                         text.setTypeface(mySelectedButton?.typeface,Typeface.BOLD)
                     }
                 }
             }
             mediaPlayerWrongAnswer?.start()
         }

     }
      if(mycurrentPosition==myQuestions?.size){
              val intent =Intent(this,result_activity::class.java)
              intent.putExtra(Questions.USER_NAME,myUserName)
              intent.putExtra(Questions.totalQuestions,myQuestions?.size.toString())
              intent.putExtra(Questions.totalRightAnswers,totalCorrectAnswers.toString())
              startActivity(intent)
              finish()
      }
      else{
      submitbtn?.text="Next Question"
      mycurrentPosition++}


  }




    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ques1-> {
                if(!isSubmitButtonPressed){
                 ques1?.setBackgroundResource(R.drawable.my_changed_background)
                ques1?.setTypeface(ques1?.typeface,Typeface.BOLD)
                mySelectedButton = ques1
                    setDefaultOptions()
                }

            }
            R.id.ques2-> {
                if(!isSubmitButtonPressed){
                ques2?.setBackgroundResource(R.drawable.my_changed_background)
                ques2?.setTypeface(ques1?.typeface,Typeface.BOLD)
                mySelectedButton = ques2
                    setDefaultOptions()
                }

            }
            R.id.ques3-> {
                if(!isSubmitButtonPressed){
                ques3?.setBackgroundResource(R.drawable.my_changed_background)
                ques3?.setTypeface(ques1?.typeface,Typeface.BOLD)
                mySelectedButton = ques3
                    setDefaultOptions()
                }

            }
            R.id.ques4-> {
                if(!isSubmitButtonPressed){
                ques4?.setBackgroundResource(R.drawable.my_changed_background)
                ques4?.setTypeface(ques1?.typeface,Typeface.BOLD)
                mySelectedButton = ques4
                    setDefaultOptions()
                }

            }
            R.id.submitbtn->{
                if (isOptionSelected){
                    if(previousPosition==mycurrentPosition)
                    { displayAnswer()
                      isSubmitButtonPressed =true
                    }
                    else{

                    previousPosition++

                    setQuestion()
                        isSubmitButtonPressed=false
                         }
                }
                else{
                    Toast.makeText(this, "Plz Select Option", Toast.LENGTH_SHORT).show()
                }
                return
            }

        }

        isOptionSelected=true
    }






}