package com.example.todonotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()
    private var noteIdCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnViewNotes = findViewById<Button>(R.id.btn_view_notes)
        val btnCreateNote = findViewById<Button>(R.id.btn_create_note)
        val btnEditNote = findViewById<Button>(R.id.btn_edit_note)

        btnViewNotes.setOnClickListener {
            loadFragment(NoteListFragment.newInstance(notes))
        }

        btnCreateNote.setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivityForResult(intent, CREATE_NOTE_REQUEST_CODE)
        }

        btnEditNote.setOnClickListener {
            val intent = Intent(this, NoteEditActivity::class.java)
            intent.putParcelableArrayListExtra("notes", ArrayList(notes))
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_NOTE_REQUEST_CODE && resultCode == RESULT_OK) {
            val newNote = data?.getParcelableExtra<Note>("note")
            newNote?.let {
                notes.add(it)
            }
        }
    }

    companion object {
        const val CREATE_NOTE_REQUEST_CODE = 1
    }
}
