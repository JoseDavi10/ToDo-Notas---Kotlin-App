package com.example.todonotes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class NoteDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_detail, container, false)

        // Example Button to start SyncNotesService
        val btnSync = view.findViewById<Button>(R.id.btn_sync_note)
        btnSync.setOnClickListener {
            val intent = Intent(activity, SyncNotesService::class.java)
            activity?.startService(intent)
        }

        return view
    }
}
