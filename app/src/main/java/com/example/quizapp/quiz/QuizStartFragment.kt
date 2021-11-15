package com.example.quizapp.quiz

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.fragment.app.activityViewModels

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
 * Use the [QuizStartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizStartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var playerName: EditText
    private lateinit var startButton: Button
    private lateinit var contactButton : Button


    lateinit var imageView: ImageView
    lateinit var imagebutton: Button
    private val pickImage = 100
    private var imageUri: Uri? = null
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
        //atalakitjuk majd ugy kuljdjuk
        val view = inflater.inflate(R.layout.fragment_quiz_start, container, false)
        //ha nem null
        view?.apply {
            initializeView(this)
            registerListeners(this)
        }

        return view
    }



    @SuppressLint("Range")
    private val getPerson= registerForActivityResult(PickContact()) {
        val cursor = requireActivity().contentResolver.query(it!!, null, null, null, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val chosenName = cursor?.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.i(TAG, "Name: $chosenName")

                val editText = view?.findViewById<EditText>(R.id.playerNameInput)
                editText?.setText(chosenName)
            }
        }
    }
    private fun registerListeners(view: View) {
        startButton.setOnClickListener{
            val msg: String = playerName.text.toString()
            if(msg.trim().length == 0) {
                Toast.makeText(activity, "The player name is empty!", Toast.LENGTH_SHORT).show()
            }else {

                Toast.makeText(activity, "Start button pressed", Toast.LENGTH_SHORT).show()
                Log.i(TAG, playerName.text.toString())

                viewModel.getUpdatePlyerName(playerName.text.toString())
                findNavController().navigate(R.id.action_quizStartFragment_to_questionFragment)
            }
        }
        contactButton.setOnClickListener {
            getPerson.launch(0)
        }
        imagebutton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
    }

    private fun initializeView(view: View) {
        playerName= view.findViewById(R.id.playerNameInput)
        startButton = view.findViewById(R.id.startButton)
        contactButton = view.findViewById(R.id.contact_button)
        imageView = view.findViewById(R.id.imageView)
        imagebutton = view.findViewById(R.id.image_button)
    }
    class PickContact : ActivityResultContract<Int, Uri?>() {
        override fun createIntent(context: Context, ringtoneType: Int) =
            Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)

        override fun parseResult(resultCode: Int, result: Intent?) : Uri? {
            if (resultCode != Activity.RESULT_OK) {
                return null
            }
            return result?.data
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizStartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizStartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
