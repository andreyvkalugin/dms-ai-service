package ru.kalugin.ai.usecase.agent

import org.bsc.langgraph4j.StateGraph
import org.bsc.langgraph4j.action.AsyncNodeAction
import org.springframework.stereotype.Service
import ru.kalugin.ai.shared.createMessage
import ru.kalugin.ai.shared.getOrDefaultState
import ru.kalugin.ai.usecase.agent.phase.JsonConverterPhase
import ru.kalugin.ai.usecase.agent.phase.SchemaCreatorPhase

@Service
class DataConversionAgent(
    private val converterPhase: JsonConverterPhase,
    private val schemaCreatorPhase: SchemaCreatorPhase,
) {

    fun obtainSchema(request: InitData): AgentStateSupport {
        val initData = request.createMessage()
        val graph = StateGraph(AgentStateSupport.SCHEMA) { AgentStateSupport(it) }
            .addNode(CONVERTER, AsyncNodeAction.node_async(converterPhase))
            .addNode(SCHEMA_CREATOR, AsyncNodeAction.node_async(schemaCreatorPhase))
            .addEdge(StateGraph.START, CONVERTER)
            .addEdge(CONVERTER, SCHEMA_CREATOR)
            .addEdge(SCHEMA_CREATOR, StateGraph.END)
            .compile()

        return graph.invoke(initData).getOrDefaultState()
    }
}

private const val CONVERTER = "converter"
private const val SCHEMA_CREATOR = "schema_creator"