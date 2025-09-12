package ru.kalugin.ai.a2

import org.bsc.langgraph4j.state.AgentState
import org.bsc.langgraph4j.state.Channel
import org.bsc.langgraph4j.state.Channels
import kotlin.jvm.optionals.getOrDefault


//internal class State(initData: Map<String?, Any?>?) : MessagesState<ChatMessage?>(initData)

class SimpleState(initData: Map<String?, Any?>?) : AgentState(initData) {

    fun messages() = this.value<List<String>>(MESSAGES_KEY).getOrDefault(emptyList())


    companion object {
        const val MESSAGES_KEY = "messages"
        val SCHEMA = mapOf<String, Channel<*>>(MESSAGES_KEY to Channels.appender<Any> { ArrayList() })
    }
}
