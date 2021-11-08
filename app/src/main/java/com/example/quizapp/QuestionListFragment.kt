package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.models.Item
import com.example.quizapp.shared.QuizViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionListFragment : Fragment(), DataAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: QuizViewModel by activityViewModels()
    private lateinit var recycler_view: RecyclerView
    private lateinit var list: ArrayList<Item>
    private lateinit var adapter: DataAdapter


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
        val view = inflater.inflate(R.layout.fragment_question_list, container, false)

        view?.apply {
            initializeView(this)
        }

        return view
    }
    private fun initializeView(view: View) {
        list = generateDummyList(viewModel.questions.size)
        viewModel.setItemList(list)
        adapter = DataAdapter(list, this)

        recycler_view = view.findViewById(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)
    }

    override fun onDetailsClick(position: Int) {
        viewModel.currentPosition = position
        findNavController().navigate(R.id.action_questionListFragment_to_detailFragment)
    }

    override fun onDeleteClick(position: Int) {
        list.removeAt(position)
        Log.i(TAG,position.toString())
        if (position >=0 && position <viewModel.questions.size) {

            viewModel.questions.removeAt(position)
            adapter.notifyItemRemoved(position)
            recycler_view.adapter?.notifyItemRemoved(position)
        }
    }


    private fun generateDummyList(size: Int): ArrayList<Item> {
        val list = ArrayList<Item>()

        for (i in 0 until size) {
            val item = Item(viewModel.getOneQuestion(i), viewModel.getOneAnswer(i))
            list += item
        }
        return list
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}