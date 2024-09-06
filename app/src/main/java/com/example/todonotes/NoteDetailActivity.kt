package com.example.todonotes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_detail_activity)

        val noteContentTextView = findViewById<TextView>(R.id.note_content_text_view)
        val backButton = findViewById<Button>(R.id.back_button)

        // Obtém o conteúdo da nota passada pela Intent
        val noteContent = intent.getStringExtra("note_content")

        // Exibe o conteúdo da nota
        noteContentTextView.text = noteContent

        // Botão voltar
        backButton.setOnClickListener {
            finish()
        }
    }
}

