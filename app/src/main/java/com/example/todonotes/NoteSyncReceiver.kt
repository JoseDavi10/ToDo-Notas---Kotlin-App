package com.example.todonotes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NoteSyncReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "com.example.todonotes.SYNC_COMPLETED") {
            Toast.makeText(context, "Notes synchronized successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
