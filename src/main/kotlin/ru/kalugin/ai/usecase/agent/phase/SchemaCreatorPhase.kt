package ru.kalugin.ai.usecase.agent.phase

import mu.KotlinLogging
import org.bsc.langgraph4j.action.NodeAction
import org.springframework.stereotype.Service
import ru.kalugin.ai.usecase.assistant.SchemaAssistant
import ru.kalugin.ai.shared.createMessage
import ru.kalugin.ai.usecase.agent.AgentStateSupport

@Service
class SchemaCreatorPhase(
    private val schemaAssistant: SchemaAssistant
) : NodeAction<AgentStateSupport> {

    override fun apply(state: AgentStateSupport): Map<String, Any> {
        val json = state.lastMessage as String
        log.info { "create schema for: [ $json ]" }
        val schema = schemaAssistant.createSchema(json)
        log.info { "resulting schema: [ $schema ]" }
        return schema.createMessage()
    }
}

private val log = KotlinLogging.logger {}
