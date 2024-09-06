package com.example.todonotes

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class NoteSaveService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Aqui pode ser feito o salvamento em segundo plano
        val note = intent?.getStringExtra("note_content")
        Toast.makeText(this, "Salvando nota: $note", Toast.LENGTH_SHORT).show()

        // Simulando operação de salvamento em segundo plano
        stopSelf()  // Encerra o serviço após a tarefa ser realizada
        return START_NOT_STICKY
    }
}

