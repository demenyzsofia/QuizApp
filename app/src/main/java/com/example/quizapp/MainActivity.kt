package com.example.quizapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.media.RingtoneManager.ACTION_RINGTONE_PICKER
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.system.Os.close
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.net.toUri
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.provider.ContactsContract.CommonDataKinds
import java.lang.Exception
import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult



const val TAG:String ="MainActivity"
const val USERNAME_EXTRA:String ="Username"

class MainActivity : AppCompatActivity() {

//    //osztaly adatok
//    private lateinit var playerName: EditText
//    private lateinit var startButton: Button
//    private lateinit var contactButton : Button
//
//    override fun onStart(){
//        super.onStart()
//        Log.i(TAG,"onStart()")
//    }
//
//    override fun onResume(){
//        super.onResume()
//        Log.i(TAG,"onResume()")
//    }
//
//    override fun onPause(){
//        super.onPause()
//        Log.i(TAG,"onPause()")
//    }
//
//    override fun onStop(){
//        super.onStop()
//        Log.i(TAG,"onStop()")
//    }
//
//    override fun onDestroy(){
//        super.onDestroy()
//        Log.i(TAG,"onDestroy()")
//    }
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.i(TAG,"onCreate()")
//        setContentView(R.layout.activity_main)
//            //inicializalas
//        initializeView()
//        //esemenykezelok
//        registerListeners()
//    }
//
//    private fun initializeView(){
//        playerName= findViewById(R.id.playerNameInput)
//        startButton = findViewById(R.id.startButton)
//        contactButton= findViewById(R.id.contact_button)
//
//    }
//
//    @SuppressLint("Range")
//    private val getPerson  = registerForActivityResult(PickContact()) {
//        val cursor = contentResolver.query(it!!, null, null, null, null)
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                val chosenName =
//                    cursor?.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
//                    Log.i(TAG, "Name: $chosenName")
//
//                val editText = findViewById<EditText>(R.id.playerNameInput)
//                if (editText != null) {
//                    editText.setText(chosenName)
//                }
//            }
//        }
//    }
//
//    private fun registerListeners(){
//        startButton.setOnClickListener{
//            //snackbar message
//            val snack = Snackbar.make(it,"Back is pressed",Snackbar.LENGTH_LONG)
//            snack.show()
//            //this -> antivity
//            //application context
//            Toast.makeText(this,"Start button pressed",Toast.LENGTH_SHORT).show()
//            //Log.i(TAG,"Start button pressed")
//            //kiirni hogy mi van az edit text mezojebe beirva
//            Log.i(TAG,playerName.text.toString())
//
//
//            val intent = Intent(this,DisplayMessageActivity::class.java).apply{
//                putExtra(USERNAME_EXTRA,playerName.text.toString())
//
//            }
//            startActivity(intent)
//        }
//
//        contactButton.setOnClickListener {
//                getPerson.launch(0)
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate()")
        setContentView(R.layout.activity_main)

    }


}











