package com.example.room_kotlin_example.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.viewModels
import com.example.room_kotlin_example.R
import com.example.room_kotlin_example.databinding.ActivityMainBinding
import com.example.room_kotlin_example.databinding.ActivityNewWordBinding
import com.example.room_kotlin_example.repository.WordsApplication
import com.example.room_kotlin_example.viewmodel.WordViewModel
import com.example.room_kotlin_example.viewmodel.WordViewModelFactory

class NewWordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNewWordBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val editWordView = binding.editWord
        val button = binding.buttonSave

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.room_kotlin_example"
    }


    }
