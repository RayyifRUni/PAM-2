package com.example.tugasminggu2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)

        buttonHitung.setOnClickListener {
            val num1 = editTextNumber1.text.toString().toDoubleOrNull()
            val num2 = editTextNumber2.text.toString().toDoubleOrNull()
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih operasi matematika!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val operator = when (selectedRadioButtonId) {
                R.id.radioTambah -> "+"
                R.id.radioKurang -> "-"
                R.id.radioKali -> "*"
                R.id.radioBagi -> "/"
                else -> ""
            }

            val hasil = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> 0.0
            }

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("HASIL", hasil)
                putExtra("NIM", "235150700111032")
                putExtra("NAMA", "LAODE M. RAYYIF RASYA T.")
            }
            startActivity(intent)
        }
    }
}
