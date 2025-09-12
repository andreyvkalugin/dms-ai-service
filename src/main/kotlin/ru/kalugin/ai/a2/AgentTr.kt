package ru.kalugin.ai.a2

import org.bsc.langgraph4j.action.NodeAction
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import ru.kalugin.ai.a2.SimpleState.Companion.MESSAGES_KEY
import ru.kalugin.ai.assistent.Assistant
import ru.kalugin.ai.assistent.SchemaAssistent
import java.util.Map

@Component
class AgentTr(
        val assistant: Assistant,
        val schemaAssistent: SchemaAssistent
) {

    val request = "BorrowerSegment;BS1;Тестовый сегмент 1;;1;BorrowerSegment-BS1;BorrowerSegment;BS2;Тестовый сегмент 2;;2;BorrowerSegment-BS2;BorrowerSegment;BS3;Малый;Малый;3;BorrowerSegment-BS3;BorrowerSegment;BS4;Микро;;4;;BorrowerSegment;Retail;Розница;;5;BorrowerSegment-Retail;BorrowerSegment;BMO;БМО;;;BorrowerSegment-BMO;9BorrowerSegment;Engineering;Клиенты Машиностроения;;;BorrowerSegment-Engineering;7BorrowerSegment;Largest;Крупнейшие;;;BorrowerSegment-Largest;5BorrowerSegment;Large;Крупные;;;BorrowerSegment-Large;4BorrowerSegment;Small;Малые;;;BorrowerSegment-Small;2BorrowerSegment;Micro;Микро;Микро;;;1BorrowerSegment;Defence;ОПК;;;BorrowerSegment-Defence;BorrowerSegment;AnnualRevenue;Отсутствует информация об объеме годовой выручки;;;BorrowerSegment-AnnualRevenue;10BorrowerSegment;Reggossektor;Рег. госсектор;;;BorrowerSegment-Reggossektor;8BorrowerSegment;Average 2;Средние;;;BorrowerSegment-Average 2;3BorrowerSegment;Fininst;Фин. институты;;;BorrowerSegment-Fininst;6"

    var jsonMarshallingCsvConverter = NodeAction<SimpleState> { state ->
        log.trace("calculationNode: {}", state.messages())
        val result = assistant.chat(request)
        mapOf(MESSAGES_KEY to result)
    }

    var jsonSchemaCreator = NodeAction<SimpleState> { state ->
        log.trace("summaryNode: {}", state.messages())
        val lastMessage = state.messages().last()
        val result = schemaAssistent.chat(lastMessage)
        mapOf(MESSAGES_KEY to result)
    }

}

val log = LoggerFactory.getLogger(AgentTr::class.java)