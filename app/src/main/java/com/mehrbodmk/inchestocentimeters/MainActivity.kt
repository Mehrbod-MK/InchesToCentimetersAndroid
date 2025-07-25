package com.mehrbodmk.inchestocentimeters

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextInches: EditText
    private lateinit var buttonConvert: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextInches = findViewById(R.id.editTextNumberDecimal)
        buttonConvert = findViewById(R.id.buttonConvert)
        textViewResult = findViewById(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val inputNumberText = editTextInches.text.toString().toDoubleOrNull()
            if (inputNumberText?.isNaN() == false) {
                textViewResult.text = getString(R.string.text_ResultCM, (inputNumberText * 2.54).toString())
            }
            else
            {
                Toast.makeText(this, R.string.toast_NotAValidDecimal, Toast.LENGTH_SHORT).show()
            }
        }
    }
}