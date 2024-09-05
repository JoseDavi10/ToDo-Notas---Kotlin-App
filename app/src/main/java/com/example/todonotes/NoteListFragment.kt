package com.example.todonotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.ListView

class NoteListFragment : Fragment() {

    private lateinit var notes: List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            notes = it.getParcelableArrayList("notes") ?: emptyList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)
        val listView = view.findViewById<ListView>(R.id.notes_list_view)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            notes.map { it.title }
        )
        listView.adapter = adapter

        return view
    }

    companion object {
        fun newInstance(notes: List<Note>): NoteListFragment {
            val fragment = NoteListFragment()
            val args = Bundle()
            args.putParcelableArrayList("notes", ArrayList(notes))
            fragment.arguments = args
            return fragment
        }
    }
}
