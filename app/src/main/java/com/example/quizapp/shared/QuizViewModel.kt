package com.example.quizapp.shared

import androidx.lifecycle.ViewModel
import com.example.quizapp.models.Question

class QuizViewModel : ViewModel() {
//    //One correct answer - the first one!
//    val questions: MutableList<Question> = mutableListOf(
//        Question(
//            text = "What is Android Jetpack?",
//            answers = listOf("All of these", "Tools", "Documentation", "Libraries")
//        ),
//        Question(
//            text = "What is the base class for layouts?",
//            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
//        ),
//        Question(
//            text = "What layout do you use for complex screens?",
//            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
//        ),
//        Question(
//            text = "What do you use to push structured data into a layout?",
//            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")
//        ),
//        Question(
//            text = "What method do you use to inflate layouts in fragments?",
//            answers = listOf(
//                "onCreateView()",
//                "onActivityCreated()",
//                "onCreateLayout()",
//                "onInflateLayout()"
//            )
//        ),
//        Question(
//            text = "What's the build system for Android?",
//            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
//        ),
//        Question(
//            text = "Which class do you use to create a vector drawable?",
//            answers = listOf(
//                "VectorDrawable",
//                "AndroidVectorDrawable",
//                "DrawableVector",
//                "AndroidVector"
//            )
//        ),
//        Question(
//            text = "Which one of these is an Android navigation component?",
//            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
//        ),
//        Question(
//            text = "Which XML element lets you register an activity with the launcher activity?",
//            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
//        ),
//        Question(
//            text = "What do you use to mark a layout for data binding?",
//            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
//        ),
//        Question(
//            text = "Which of the following is NOT an activity lifecycle state?",
//            answers = listOf("Waiting", "Started", "Created", "Destroyed")
//        ),
//        Question(
//            text = "Which lifecycle method is called to make an activity visible?",
//            answers = listOf("osStart", "onPause", "onVisible", "onDestroy")
//        ),
//        Question(
//            text = "Which lifecycle method is called to give an activity focus?",
//            answers = listOf("onResume", "onFocus", "onVisible", "onStart")
//        )
//
//    )
//
//    fun doQuiz(numberOfQuestions : Int){
//        var i=0
//        var goodAnswers = 0
//
//        randomizeQuestions()
//        while(i<numberOfQuestions){
//            println(questions[i].text)
//            for(j in questions[i].answers.shuffled() ){
//                println(j)
//            }
//            println("Melyik a helyes valasz?\n")
//            val ans =readLine()
//            if(questions[i].answers[0]== ans.toString()){
//                goodAnswers++;
//                println("Helyes valasz!")
//            }
//            else{
//                println("Helytelen a valasz!")
//            }
//            i++;
//        }
//        println("Helyes valaszok: $goodAnswers , osszes valasz: $numberOfQuestions")
//        println("$goodAnswers / $numberOfQuestions")
//    }
//
//    fun randomizeQuestions(){
//        questions.shuffle()
//    }
}