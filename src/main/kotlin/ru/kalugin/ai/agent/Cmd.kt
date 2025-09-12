package ru.kalugin.ai.agent

import org.bsc.langgraph4j.StateGraph
import org.bsc.langgraph4j.action.AsyncNodeAction.node_async
import org.bsc.langgraph4j.action.NodeAction
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.kalugin.ai.a2.SimpleState
import ru.kalugin.ai.a2.log
import ru.kalugin.ai.assistent.Assistant
import ru.kalugin.ai.assistent.SchemaAssistent
import org.bsc.langgraph4j.StateGraph.END
import org.bsc.langgraph4j.StateGraph.START
import org.bsc.langgraph4j.action.AsyncEdgeAction.edge_async
import org.bsc.langgraph4j.action.AsyncNodeAction.node_async


@Component
class Cmd(
        val assistant: Assistant,
        val schemaAssistent: SchemaAssistent
): CommandLineRunner {

    override fun run(vararg args: String?) {

        //val request = "BorrowerSegment;BS1;Тестовый сегмент 1;;1;BorrowerSegment-BS1;BorrowerSegment;BS2;Тестовый сегмент 2;;2;BorrowerSegment-BS2;BorrowerSegment;BS3;Малый;Малый;3;BorrowerSegment-BS3;BorrowerSegment;BS4;Микро;;4;;BorrowerSegment;Retail;Розница;;5;BorrowerSegment-Retail;BorrowerSegment;BMO;БМО;;;BorrowerSegment-BMO;9BorrowerSegment;Engineering;Клиенты Машиностроения;;;BorrowerSegment-Engineering;7BorrowerSegment;Largest;Крупнейшие;;;BorrowerSegment-Largest;5BorrowerSegment;Large;Крупные;;;BorrowerSegment-Large;4BorrowerSegment;Small;Малые;;;BorrowerSegment-Small;2BorrowerSegment;Micro;Микро;Микро;;;1BorrowerSegment;Defence;ОПК;;;BorrowerSegment-Defence;BorrowerSegment;AnnualRevenue;Отсутствует информация об объеме годовой выручки;;;BorrowerSegment-AnnualRevenue;10BorrowerSegment;Reggossektor;Рег. госсектор;;;BorrowerSegment-Reggossektor;8BorrowerSegment;Average 2;Средние;;;BorrowerSegment-Average 2;3BorrowerSegment;Fininst;Фин. институты;;;BorrowerSegment-Fininst;6"

        // Initialize nodes
        val request = "BorrowerSegment;BS1;Тестовый сегмент 1;;1;BorrowerSegment-BS1;BorrowerSegment;BS2;Тестовый сегмент 2;;2;BorrowerSegment-BS2;BorrowerSegment;BS3;Малый;Малый;3;BorrowerSegment-BS3;BorrowerSegment;BS4;Микро;;4;;BorrowerSegment;Retail;Розница;;5;BorrowerSegment-Retail;BorrowerSegment;BMO;БМО;;;BorrowerSegment-BMO;9BorrowerSegment;Engineering;Клиенты Машиностроения;;;BorrowerSegment-Engineering;7BorrowerSegment;Largest;Крупнейшие;;;BorrowerSegment-Largest;5BorrowerSegment;Large;Крупные;;;BorrowerSegment-Large;4BorrowerSegment;Small;Малые;;;BorrowerSegment-Small;2BorrowerSegment;Micro;Микро;Микро;;;1BorrowerSegment;Defence;ОПК;;;BorrowerSegment-Defence;BorrowerSegment;AnnualRevenue;Отсутствует информация об объеме годовой выручки;;;BorrowerSegment-AnnualRevenue;10BorrowerSegment;Reggossektor;Рег. госсектор;;;BorrowerSegment-Reggossektor;8BorrowerSegment;Average 2;Средние;;;BorrowerSegment-Average 2;3BorrowerSegment;Fininst;Фин. институты;;;BorrowerSegment-Fininst;6"

        val jsonMarshallingCsvConverter = NodeAction<SimpleState> { state ->
            log.trace("calculationNode: {}", state.messages())
            val lastMessage = state.messages().last()
            val result = assistant.chat(lastMessage)
            mapOf(SimpleState.MESSAGES_KEY to result)
        }

        val jsonSchemaCreator = NodeAction<SimpleState> { state ->
            log.trace("summaryNode: {}", state.messages())
            val lastMessage = state.messages().last()
            val result = schemaAssistent.chat(lastMessage)
            mapOf(SimpleState.MESSAGES_KEY to result)
        }

        // Define the graph structure

        // Define the graph structure
        val stateGraph: StateGraph<SimpleState> = StateGraph(SimpleState.SCHEMA) { SimpleState(it) }
                .addNode("greeter", node_async(jsonMarshallingCsvConverter))
                .addNode("responder", node_async(jsonSchemaCreator)) // Define edges
                .addEdge(START, "greeter") // Start with the greeter node
                .addEdge("greeter", "responder")
                .addEdge("responder", END) // End after the responder node

        // Compile the graph
        val compiledGraph = stateGraph.compile()

//        for (item in compiledGraph.stream(java.util.Map.of<String, Any>(SimpleState.MESSAGES_KEY, "Let's, begin!"))) {
//            println(item)
//        }

        val result = compiledGraph.invoke(mapOf(SimpleState.MESSAGES_KEY to request))
        println(result)
//result.get().messages().last()
    }
}