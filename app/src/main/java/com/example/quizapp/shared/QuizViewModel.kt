package com.example.quizapp.shared
import android.util.Log
import com.example.quizapp.TAG
import com.example.quizapp.models.Question
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.quizapp.R


class QuizViewModel(application : Application) : AndroidViewModel(application) {
    private val numQuestions = 3
    private var numCorrectAnswers = 0
    private var questiobIndex = 0
    private var highScore: Int = 0
    private var playerName: String =""
    private val context = getApplication<Application>().applicationContext
    val questions = arrayListOf<Question>()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {

        val isReader: InputStream = context.resources.openRawResource(R.raw.question)
        val reader = BufferedReader(InputStreamReader(isReader))
        val lines = reader.readLines()

        Log.i(TAG, lines.toString())
        for (i in 0..lines.size - 1 step 5) {
            val answers =
                arrayListOf<String>(lines[i + 1], lines[i + 2], lines[i + 3], lines[i + 4])
            val question = Question(lines[i], answers)
            questions.add(question)
        }
    }

    fun getNumQuestions(): Int {
        return numQuestions
    }

    fun getCurrentnumCorrectAnswers(): Int {
        return numCorrectAnswers
    }

    fun getUpdatednumCorrectAnswers(): Int {
        return ++numCorrectAnswers
    }

    fun getUpdatednumAnswers(): Int {
        numCorrectAnswers = 0
        return numCorrectAnswers
    }

    fun getQuestionIndex(): Int {
        return questiobIndex
    }

    fun getUpdatedQuestionIndex(): Int {
        return ++questiobIndex
    }

    fun getUpdatedQuestionIndexNull(): Int {
        questiobIndex = 0
        return questiobIndex
    }

    fun gethighScore():Int{
        return highScore
    }

    fun getUpdatehighScore():Int{
        if(highScore < numCorrectAnswers){
            highScore =numCorrectAnswers
        }
        return highScore
    }

    fun getPlyerName():String{
        return playerName
    }

    fun getUpdatePlyerName(name : String):String{
        playerName=name
        return playerName
    }
}