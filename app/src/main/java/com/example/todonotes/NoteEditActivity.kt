package com.example.todonotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class NoteEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_edit)

        val noteId = intent.getIntExtra("NOTE_ID", -1)
        Toast.makeText(this, "Editing Note ID: $noteId", Toast.LENGTH_SHORT).show()
    }
}
