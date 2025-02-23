package com.example.heylmv1

import android.os.Bundle
import android.service.voice.VoiceInteractionService
import android.service.voice.VoiceInteractionSession

class DigitalAssistantService : VoiceInteractionService() {

    override fun onNewSession(args: Bundle?): VoiceInteractionSession {
        // Return an instance of your custom session
        return DigitalAssistantSession(this)
    }
}
