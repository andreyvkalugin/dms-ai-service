package ru.kalugin.ai.config

import dev.langchain4j.memory.ChatMemory
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.chat.listener.ChatModelListener
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import ru.kalugin.ai.usecase.ModelListener


@Configuration
class AssistantConfiguration {
    /**
     * История чата которая будет использоваться ассистентами [Assistant]
     */
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    fun chatMemory(): ChatMemory {
        return MessageWindowChatMemory.withMaxMessages(10)
    }

    /**
     * Этот слушатель будет применен ко всем моделям [ChatModel]
     * бины которых найдены в контексте приложения.
     */
    @Bean
    fun chatModelListener(): ChatModelListener {
        return ModelListener()
    }
}