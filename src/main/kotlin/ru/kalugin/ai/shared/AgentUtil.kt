package ru.kalugin.ai.shared

import ru.kalugin.ai.usecase.agent.AgentStateSupport
import java.util.*

fun Any.createMessage() = mapOf(AgentStateSupport.MESSAGES_KEY to this)

fun Optional<AgentStateSupport>.getOrDefaultState(): AgentStateSupport = this.orElseGet {
    AgentStateSupport(
        DEFAULT_MESSAGE.createMessage()
    )
}

private const val DEFAULT_MESSAGE = "JSON Schema is empty. Check logs to analyze messages from the chat"