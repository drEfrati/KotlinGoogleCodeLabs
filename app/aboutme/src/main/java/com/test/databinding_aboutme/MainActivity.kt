package com.test.databinding_aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit  var nicknameTextView: TextView
    private lateinit var nicknameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nicknameTextView = findViewById(R.id.nickname_text)
        nicknameEditText = findViewById(R.id.nickname_edit)
        doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener {
            addNickname(v = it)
        }
        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(v: View) {
        nicknameTextView.text = nicknameEditText.text
        v.visibility = View.GONE
        nicknameEditText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
    }

    private fun updateNickname(v: View) {
        nicknameEditText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE
        doneButton.visibility = View.VISIBLE
        nicknameEditText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEditText, 0)
    }

}
