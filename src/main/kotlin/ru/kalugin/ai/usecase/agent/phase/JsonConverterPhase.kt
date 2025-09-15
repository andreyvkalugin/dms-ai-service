package ru.kalugin.ai.usecase.agent.phase

import mu.KotlinLogging
import org.bsc.langgraph4j.action.NodeAction
import org.springframework.stereotype.Service
import ru.kalugin.ai.usecase.assistant.ConverterAssistant
import ru.kalugin.ai.shared.createMessage
import ru.kalugin.ai.usecase.agent.AgentStateSupport
import ru.kalugin.ai.usecase.agent.InitData

@Service
class JsonConverterPhase(
    private val converter: ConverterAssistant
) : NodeAction<AgentStateSupport> {

    override fun apply(state: AgentStateSupport): Map<String, Any> {
        val (csv, contract) = state.initState as InitData
        log.info { "start converting csv to json: [ $csv ]" }
        val json = converter.convertByContract(csv, contract)
        log.info { "convert result: [ $json ]" }
        return json.createMessage()
    }
}

private val log = KotlinLogging.logger {}
