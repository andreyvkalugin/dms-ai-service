package ru.kalugin.ai.usecase.agent

import org.bsc.langgraph4j.state.AgentState
import org.bsc.langgraph4j.state.Channel
import org.bsc.langgraph4j.state.Channels
import kotlin.jvm.optionals.getOrDefault

class AgentStateSupport(initData: Map<String, Any>) : AgentState(initData) {

    val lastMessage: Any
        get() = messages().last()

    val initState: Any
        get() = messages().first()

    private fun messages(): List<Any> = this.value<List<Any>>(MESSAGES_KEY).getOrDefault(emptyList())

    companion object {
        const val MESSAGES_KEY = "messages"
        val SCHEMA = mapOf<String, Channel<*>>(MESSAGES_KEY to Channels.appender<Any> { ArrayList() })
    }
}
