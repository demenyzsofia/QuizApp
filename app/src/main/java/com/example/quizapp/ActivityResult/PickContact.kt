package com.example.quizapp.ActivityResult

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class PickContact : ActivityResultContract<Int, Uri?>() {
    override fun createIntent(context: Context, input: Int?) =
        Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        return if (resultCode == AppCompatActivity.RESULT_OK) intent?.data else null
    }


}