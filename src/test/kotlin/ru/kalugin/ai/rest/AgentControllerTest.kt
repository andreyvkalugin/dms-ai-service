package ru.kalugin.ai.rest

import com.ninjasquad.springmockk.MockkBean
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import ru.kalugin.ai.usecase.assistant.ConverterAssistant
import ru.kalugin.ai.usecase.assistant.SchemaAssistant

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgentControllerTest {

    @MockkBean
    val converterAssistant: ConverterAssistant

    @MockkBean
    val schemaAssistant: SchemaAssistant

    @Test
    fun myTest() {
        val request =
            "BorrowerSegment;BS1;Тестовый сегмент 1;;1;BorrowerSegment-BS1;BorrowerSegment;BS2;Тестовый сегмент 2;;2;BorrowerSegment-BS2;BorrowerSegment;BS3;Малый;Малый;3;BorrowerSegment-BS3;BorrowerSegment;BS4;Микро;;4;;BorrowerSegment;Retail;Розница;;5;BorrowerSegment-Retail;BorrowerSegment;BMO;БМО;;;BorrowerSegment-BMO;9BorrowerSegment;Engineering;Клиенты Машиностроения;;;BorrowerSegment-Engineering;7BorrowerSegment;Largest;Крупнейшие;;;BorrowerSegment-Largest;5BorrowerSegment;Large;Крупные;;;BorrowerSegment-Large;4BorrowerSegment;Small;Малые;;;BorrowerSegment-Small;2BorrowerSegment;Micro;Микро;Микро;;;1BorrowerSegment;Defence;ОПК;;;BorrowerSegment-Defence;BorrowerSegment;AnnualRevenue;Отсутствует информация об объеме годовой выручки;;;BorrowerSegment-AnnualRevenue;10BorrowerSegment;Reggossektor;Рег. госсектор;;;BorrowerSegment-Reggossektor;8BorrowerSegment;Average 2;Средние;;;BorrowerSegment-Average 2;3BorrowerSegment;Fininst;Фин. институты;;;BorrowerSegment-Fininst;6"

        val contract = """
                            {
                             "BorrowerSegment": "<код сегмента>",
                             "Description": "<описание сегмента>",
                             "Group": "<группа>", // Может отсутствовать или быть пустой строкой
                             "Priority": "<приоритет>", // Может отсутствовать или быть пустой строкой
                             "Value": "<значение>"
                            }
        """.trimIndent()


    }
}