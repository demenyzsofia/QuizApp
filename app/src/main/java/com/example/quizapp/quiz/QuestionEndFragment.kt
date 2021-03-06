package com.example.quizapp.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.TAG
import com.example.quizapp.shared.QuizViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionEndFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionEndFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var tryagain_button : Button
    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_question_end, container, false)
        view?.apply {

            initializeView(this)
            registerListeners(this)
        }

        return view
    }

    private fun registerListeners(view: View) {
        val textView_result = view?.findViewById<TextView>(R.id.textView_result)
        val result= viewModel.getCurrentnumCorrectAnswers().toString()+'/'+ viewModel.getNumQuestions().toString() +" points"
        textView_result?.setText(result)
        //high score frissitjuk ha jobb eredmenyt ertunk el
        viewModel.getUpdatehighScore()

        tryagain_button.setOnClickListener {
            //nullazuk a valaszok szamak, mivel ujrakezdodik a quiz
            viewModel.getUpdatednumAnswers()
            Toast.makeText(activity, "Try again button pressed", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_questionEndFragment_to_quizStartFragment)
        }
    }

    private fun initializeView(view: View) {
        tryagain_button=view.findViewById(R.id.tryagain_button)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionEndFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionEndFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}