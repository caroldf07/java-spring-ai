package br.com.testesIA.testesIA.websocket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    fun sendMessage(message: String): String {
        return message
    }
}