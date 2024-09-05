package com.example.todonotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class CreateNoteActivity : AppCompatActivity() {

    private var noteIdCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        val titleEditText = findViewById<EditText>(R.id.note_title_edit)
        val contentEditText = findViewById<EditText>(R.id.note_content_edit)
        val btnSaveNote = findViewById<Button>(R.id.btn_save_note)

        btnSaveNote.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val newNote = Note(
                    id = noteIdCounter++,
                    title = title,
                    content = content
                )

                val resultIntent = Intent()
                resultIntent.putExtra("note", newNote)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
