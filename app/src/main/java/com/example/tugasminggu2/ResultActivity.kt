package com.example.tugasminggu2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewHasil = findViewById<TextView>(R.id.textViewHasil)
        val textViewNIM = findViewById<TextView>(R.id.textViewNIM)
        val textViewNama = findViewById<TextView>(R.id.textViewNama)

        val hasil = intent?.getDoubleExtra("HASIL", 0.0) ?: 0.0
        val nim = intent?.getStringExtra("NIM") ?: "Tidak ada NIM"
        val nama = intent?.getStringExtra("NAMA") ?: "Tidak ada Nama"

        textViewHasil.text = "Hasil: $hasil"
        textViewNIM.text = "NIM: $nim"
        textViewNama.text = "Nama: $nama"
    }
}
