package com.example.todonotes

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class SyncNotesService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Synchronizing Notes...", Toast.LENGTH_SHORT).show()

        // Simulate some work in the background
        Thread.sleep(3000)

        // Broadcast completion
        val broadcastIntent = Intent("com.example.todonotes.SYNC_COMPLETED")
        sendBroadcast(broadcastIntent)

        stopSelf()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
