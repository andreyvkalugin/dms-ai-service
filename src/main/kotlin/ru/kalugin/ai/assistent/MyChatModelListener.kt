package ru.kalugin.ai.assistent

import dev.langchain4j.model.chat.listener.ChatModelErrorContext
import dev.langchain4j.model.chat.listener.ChatModelListener
import dev.langchain4j.model.chat.listener.ChatModelRequestContext
import dev.langchain4j.model.chat.listener.ChatModelResponseContext
import org.slf4j.LoggerFactory


class MyChatModelListener : ChatModelListener {
    override fun onRequest(requestContext: ChatModelRequestContext) {
        log.info("onRequest(): {}", requestContext.chatRequest())
    }

    override fun onResponse(responseContext: ChatModelResponseContext) {
        log.info("onResponse(): {}", responseContext.chatResponse())
    }

    override fun onError(errorContext: ChatModelErrorContext) {
        log.info("onError(): {}", errorContext.error().message)
    }

}

val log = LoggerFactory.getLogger(MyChatModelListener::class.java)