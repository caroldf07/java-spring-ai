package br.com.testesIA.testesIA

import org.springframework.ai.chat.client.ChatClient
import org.springframework.web.bind.annotation.*

data class Question(val question: String)
data class Answer(val answer: String)

@RestController
@RequestMapping
class AskController(chatClientBuilder: ChatClient.Builder) {
    private val chatClient = chatClientBuilder.build()

    @GetMapping("/ask")
    fun ask(): String {
        return chatClient
                .prompt()
                .user("Tell me about the lilies")
                .call()
                .chatResponse().result.output.content
    }

    @PostMapping("/ask")
    fun ask(@RequestBody question: Question) = Answer(
            chatClient
                    .prompt()
                    .user(question.question)
                    .call()
                    .content()
    )
}
