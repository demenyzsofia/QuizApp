package com.example.quizapp.shared

import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Question

class QuizViewModel : ViewModel() {
    private val numQuestions = 3
    //private var numCorrectAnswers = 0

    fun getNumQuestions():Int{
        return numQuestions
    }

//    fun getCurrentnumCorrectAnswers():Int{
//        return numCorrectAnswers
//    }
//
//    fun getUpdatednumCorrectAnswers():Int{
//        return ++numCorrectAnswers
//    }
//
//    fun getUpdatednumAnswers():Int{
//        numCorrectAnswers=0
//        return numCorrectAnswers
//    }


}
