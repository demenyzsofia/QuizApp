package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var testButton : Button
    private lateinit var readButton : Button
    private lateinit var createButton : Button

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //ha nem null
        view?.apply {
            initializeView(this)
            registerListeners(this)
        }
        return view
    }

    private fun registerListeners(view: View) {
        testButton.setOnClickListener{
            Toast.makeText(activity,"Test your skills button pressed", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_quizStartFragment)
        }

        readButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_questionListFragment)
        }

        createButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_newQuestionFragment)
        }


    }

    private fun initializeView(view: View) {
        testButton=view.findViewById(R.id.testbutton)
        readButton=view.findViewById(R.id.readbutton)
        createButton=view.findViewById(R.id.createbutton)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}