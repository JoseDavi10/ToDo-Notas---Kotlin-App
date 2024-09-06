package com.example.todonotes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected) {
            Toast.makeText(context, "Conectado à internet. Sincronizando notas...", Toast.LENGTH_SHORT).show()
            // Aqui poderia chamar um Service para sincronizar as notas
        } else {
            Toast.makeText(context, "Sem conexão com a internet.", Toast.LENGTH_SHORT).show()
        }
    }
}

