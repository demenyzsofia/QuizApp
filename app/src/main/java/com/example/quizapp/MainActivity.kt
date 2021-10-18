package com.example.quizapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

const val TAG:String ="MainActivity"
const val USERNAME_EXTRA:String ="Username"

class MainActivity : AppCompatActivity() {

    //osztaly adatok
    private lateinit var playerName: EditText
    private lateinit var startButton: Button
    private lateinit var contactButton : Button
//    val getContent = registerForActivityResult(GetContent()) { uri: Uri? ->
//
//        // Handle the returned Uri
//    }

    override fun onStart(){
        super.onStart()
        Log.i(TAG,"onStart()")
    }

    override fun onResume(){
        super.onResume()
        Log.i(TAG,"onResume()")
    }

    override fun onPause(){
        super.onPause()
        Log.i(TAG,"onPause()")
    }

    override fun onStop(){
        super.onStop()
        Log.i(TAG,"onStop()")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(TAG,"onDestroy()")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate()")
        setContentView(R.layout.activity_main)
            //inicializalas
        initializeView()
        //esemenykezelok
        registerListeners()
    }


    private fun initializeView(){
        playerName= findViewById(R.id.playerNameInput)
        startButton = findViewById(R.id.startButton)
        contactButton= findViewById(R.id.contact_button)
    }
//    val getContent = registerForActivityResult(GetContent()) { uri: Uri? ->
//        // Handle the returned Uri
//    }
    private fun registerListeners(){
        startButton.setOnClickListener{
            //this -> antivity
            //application context
            Toast.makeText(this,"Start button pressed",Toast.LENGTH_SHORT).show()
            //Log.i(TAG,"Start button pressed")
            //kiirni hogy mi van az edit text mezojebe beirva
            Log.i(TAG,playerName.text.toString())

            //snackbar message
            val snack = Snackbar.make(startButton,"Back is pressed",Snackbar.LENGTH_LONG)
            snack.show()

            //Snackbar.make(getWindow().getDecorView().getRootView(), "Click the pin for more options", Snackbar.LENGTH_LONG).show();


            val intent = Intent(this,DisplayMessageActivity::class.java).apply{
                putExtra(USERNAME_EXTRA,playerName.text.toString())

            }
            startActivity(intent)



        }

        contactButton.setOnClickListener {
            getContent.launch("image/*")
        }
    }






}