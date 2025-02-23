package com.example.heylmv1

import android.content.Context
import android.content.Intent
import android.service.voice.VoiceInteractionSession
import android.view.LayoutInflater
import android.view.View
import android.widget.Button

class DigitalAssistantSession(context: Context) : VoiceInteractionSession(context) {

    override fun onCreateContentView(): View {
        // Inflate your assistant UI (assistant_session.xml)
        val view = LayoutInflater.from(context).inflate(R.layout.assistant_session, null)

        // Optionally, set up a button to launch the settings activity
        view.findViewById<Button>(R.id.btn_open_settings)?.setOnClickListener {
            // Since we're not in an activity, set the NEW_TASK flag.
            val intent = Intent(context, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
        return view
    }
}
