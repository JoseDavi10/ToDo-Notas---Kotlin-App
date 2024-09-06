package com.example.todonotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateNoteActivity : AppCompatActivity() {

    private var noteIdCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        val titleEditText = findViewById<EditText>(R.id.note_title_edit)
        val contentEditText = findViewById<EditText>(R.id.note_content_edit)
        val btnSaveNote = findViewById<Button>(R.id.btn_save_note)


        btnSaveNote.setOnClickListener {
            titleEditText.text.toString()
            val noteContent = contentEditText.text.toString()

            if (noteContent.isNotEmpty()) {
                // salvando a nota numa lista global

                NoteStorage.notes.add(noteContent)

                // Iniciar o Service para salvar a nota em segundo plano
                val intent = Intent(this, NoteSaveService::class.java)
                intent.putExtra("note_content", noteContent)
                startService(intent)

                // Exibir mensagem de sucesso
                Toast.makeText(this, "Nota salva com sucesso", Toast.LENGTH_SHORT).show()

                // Voltar para a tela anterior
                finish()
            } else {
                Toast.makeText(this, "Por favor, escreva algo na nota", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
