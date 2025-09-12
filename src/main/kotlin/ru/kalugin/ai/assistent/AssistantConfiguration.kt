package ru.kalugin.ai.assistent

import dev.langchain4j.memory.ChatMemory
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.chat.StreamingChatModel
import dev.langchain4j.model.chat.listener.ChatModelListener
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope


@Configuration
class AssistantConfiguration {
    /**
     * This chat memory will be used by [Assistant] and [StreamingAssistant]
     */
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    fun chatMemory(): ChatMemory {
        return MessageWindowChatMemory.withMaxMessages(10)
    }

    /**
     * This listener will be injected into every [ChatModel] and [StreamingChatModel]
     * bean   found in the application context.
     * It will listen for [ChatModel] in the [ChatModelController] as well as
     * [Assistant] and [StreamingAssistant].
     */
    @Bean
    fun chatModelListener(): ChatModelListener {
        return MyChatModelListener()
    }
}