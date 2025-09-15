package ru.kalugin.ai.usecase

import dev.langchain4j.model.chat.listener.ChatModelErrorContext
import dev.langchain4j.model.chat.listener.ChatModelListener
import dev.langchain4j.model.chat.listener.ChatModelRequestContext
import dev.langchain4j.model.chat.listener.ChatModelResponseContext
import mu.KotlinLogging


class ModelListener : ChatModelListener {
    override fun onRequest(requestContext: ChatModelRequestContext) {
        log.info { "chat model onRequest(): [ ${requestContext.chatRequest()} ]" }
    }

    override fun onResponse(responseContext: ChatModelResponseContext) {
        log.info { "chat model onResponse(): ${responseContext.chatResponse()}" }
    }

    override fun onError(errorContext: ChatModelErrorContext) {
        log.info { "chat model onError(): ${errorContext.error().message}" }
    }
}

private val log = KotlinLogging.logger {}
