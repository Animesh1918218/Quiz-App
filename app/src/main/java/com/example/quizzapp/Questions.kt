package com.example.quizzapp

object Questions {

    const val totalRightAnswers:String="0"
     const val USER_NAME:String="asda"
    const val totalQuestions:String="adasd"
    fun getQuestions():ArrayList<quizRequirements>{
          val myQuestions =ArrayList<quizRequirements>()
        val ques1 =quizRequirements(
            1,"Which Person is this ?",R.drawable.emaa_watson,"Emma Watson","Narendra Modi","Iggy Iglazea","Selena gomez","Emma Watson"
        )
        myQuestions.add(ques1)
        val ques2 =quizRequirements(
            2,"Which Person is this ?",R.drawable.shahrukhkhan,"Emma Watson","Narendra Modi","Shah Rukh Khan","Selena gomez","Shah Rukh Khan"
        )
        myQuestions.add(ques2)
        val ques3 =quizRequirements(
            3,"Which Person is this ?",R.drawable.weekend,"Weekend","Narendra Modi","Iggy Iglazea","Selena gomez","Weekend"
        )
        myQuestions.add(ques3)
        val ques4 =quizRequirements(
            4,"Which Person is this ?",R.drawable.narendramodi,"Emma Watson","Narendra Modi","Iggy Iglazea","Selena gomez","Narendra Modi"
        )
        myQuestions.add(ques4)
        val ques5 =quizRequirements(
            4,"Which Person is this ?",R.drawable.dilipkumar,"Dilip Kumar","Narendra Modi","Ranbeer Kapoor","Selena gomez","Dilip Kumar"
        )
        myQuestions.add(ques5)
        val ques6 =quizRequirements(
            4,"Which Person is this ?",R.drawable.anushkasharma,"Emma Watson","Narendra Modi","Anushka Sharma","Selena gomez","Anushka Sharma"
        )
        myQuestions.add(ques6)
        val ques7 =quizRequirements(
            4,"Which Person is this ?",R.drawable.jhonnydepp,"Emma Watson","Narendra Modi","Iggy Iglazea","Jhonny Depp","Jhonny Depp"
        )
        myQuestions.add(ques7)
        val ques8 =quizRequirements(
            4,"Which Person is this ?",R.drawable.rishikapoor,"Emma Watson","Narendra Modi","Rishi Kapoor","Selena gomez","Rishi Kapoor"
        )
        myQuestions.add(ques8)
        return myQuestions

    }
}