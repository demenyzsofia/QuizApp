package com.example.quizapp.shared

import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Question

class QuizViewModel : ViewModel() {
    val questions = arrayListOf<Question>()

    init{
        //val lines= File("questions.txt").readLines()

//        for(i in 0..lines.size-1 step 5){
//            val answers = arrayListOf<String>(lines[i+1],lines[i+2],lines[i+3],lines[i+4])
//            val question= Question(lines[i],answers)
//            questions.add(question)
//        }
    }

    fun doQuiz(numberOfQuestions : Int){
        var i=0
        var goodAnswers = 0
        randomizeQuestions()
        while(i<numberOfQuestions){
            println(questions[i].text)
            for(j in questions[i].answer.shuffled() ){
                println(j)
            }
            println("Melyik a helyes valasz?\n")
            val ans =readLine()
            if(questions[i].answer[0]== ans.toString()){
                goodAnswers++;
                println("Helyes valasz!")
            }
            else{
                println("Helytelen a valasz!")
            }
            i++;
        }
        println("Helyes valaszok: $goodAnswers , osszes valasz: $numberOfQuestions")
        println("$goodAnswers / $numberOfQuestions")
    }

    fun randomizeQuestions(){
        questions.shuffle()
    }
}