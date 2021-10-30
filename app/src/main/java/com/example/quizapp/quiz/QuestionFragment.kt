package com.example.quizapp.quiz

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.quizapp.R
import com.example.quizapp.TAG
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.models.*
import com.example.quizapp.shared.QuizViewModel
import androidx.activity.OnBackPressedCallback

import androidx.annotation.NonNull
import android.content.DialogInterface



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentQuestionBinding>(
            inflater, R.layout.fragment_question, container, false)
        randomizeQuestions()
        binding.nextButton.setOnClickListener {
            if (processAnswer(it)== true){
                viewModel.getUpdatednumCorrectAnswers()
            }
            if ( viewModel.getQuestionIndex() < viewModel.getNumQuestions()) {

                //Show next question
                it.findNavController().navigate(R.id.action_questionFragment_self)
            } else {
                //End of the test
                if (viewModel.getQuestionIndex() == viewModel.getNumQuestions()) {
                    //activate questionEndFragment
                    it.findNavController().navigate(R.id.action_questionFragment_to_questionEndFragment)
                    viewModel.getUpdatedQuestionIndexNull()
                }
            }
        }
        return binding.root
    }

    //Returns true in case of correct answer otherwise false
    private fun processAnswer(it: View?): Boolean {
        val result = binding.questionRadioGroup.checkedRadioButtonId
        //Do nothing when nothing is selected
        if (result == -1) {
            return false
        }
        //firstButton is selected
        var answerIndex = 0
        when (result) {
            R.id.secondAnswerButton -> answerIndex = 1
            R.id.thirdAnswerButton -> answerIndex = 2
            R.id.fourthAnswerButton -> answerIndex = 3
        }
        if (answers[answerIndex] == currentQuestion.answers[0]) {
            return true
        } else {
            Toast.makeText(this.activity, "Selected answer is wrong", Toast.LENGTH_SHORT).show()
            return false
        }
    }


    private fun showQuestion() {
        if (viewModel.getQuestionIndex() == viewModel.getNumQuestions()-1){
            binding.nextButton.text="Submit"
        }
        viewModel.getUpdatedQuestionIndex()
        val index = viewModel.getQuestionIndex()
        val questionTextStr = "$index. " + currentQuestion.text
        binding.textViewQuestion.text = questionTextStr
        binding.firstAnswerButton.text = answers[0]
        binding.secondAnswerButton.text = answers[1]
        binding.thirdAnswerButton.text = answers[2]
        binding.fourthAnswerButton.text = answers[3]

    }

    private fun setQuestion() {
        currentQuestion = viewModel.questions[viewModel.getQuestionIndex()]
        //randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        //shiffle anwsert
        answers.shuffle()
        showQuestion()
    }
    private fun randomizeQuestions() {
        viewModel.questions.shuffle()
        setQuestion()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                showAreYouSureDialog()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            callback
        )
    }

    fun  showAreYouSureDialog(){
        AlertDialog.Builder(activity).apply {
            setTitle("Exit")
            setMessage("Are you sure you want to end this quiz?")

            setPositiveButton("Yes") { _, _ ->
                findNavController().navigate(R.id.action_questionFragment_to_questionEndFragment)
            }

            setNegativeButton("No"){_, _ ->
                Toast.makeText(activity, "Good choice!",
                    Toast.LENGTH_LONG).show()
            }

            setCancelable(true)
        }.create().show()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}




