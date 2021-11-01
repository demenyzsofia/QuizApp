package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.quizapp.models.Question
import com.example.quizapp.shared.QuizViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewQuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewQuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var addQuestionButton : Button
    private lateinit var questionText: EditText
    private lateinit var correctAns: EditText
    private lateinit var ans2: EditText
    private lateinit var ans3: EditText
    private lateinit var ans4: EditText

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
        val view = inflater.inflate(R.layout.fragment_new_question, container, false)
        //ha nem null
        view?.apply {
            initializeView(this)
            registerListeners(this)
        }
        return view
    }

    private fun registerListeners(view: View) {
        addQuestionButton.setOnClickListener{
            val answers = arrayListOf<String>(correctAns.text.toString(), ans2.text.toString(), ans3.text.toString(), ans4.text.toString())
            val question = Question(questionText.text.toString(), answers)
            //hoazzadjuk a kerdest
            viewModel.questions.add(question)
            //toroljuk a tartalmakat
            questionText.text.clear()
            correctAns.text.clear()
            ans2.text.clear()
            ans3.text.clear()
            ans4.text.clear()
        }
    }

    private fun initializeView(view: View) {
        addQuestionButton = view.findViewById(R.id.buttonAddQuestion)
        questionText=view.findViewById(R.id.editTextQuestion)
        correctAns=view.findViewById(R.id.editTextAns1)
        ans2=view.findViewById(R.id.editTextAns2)
        ans3=view.findViewById(R.id.editTextAns3)
        ans4=view.findViewById(R.id.editTextAns4)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewQuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewQuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}