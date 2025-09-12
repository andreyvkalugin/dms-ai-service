package ru.kalugin.ai.agent

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.kalugin.ai.assistent.Assistant
import ru.kalugin.ai.assistent.SchemaAssistent

//@Component
class AiAgent(
        val assistant: Assistant,
        val schemaAssistent: SchemaAssistent
): CommandLineRunner {

    override fun run(vararg args: String?) {

        val request = "BorrowerSegment;BS1;Тестовый сегмент 1;;1;BorrowerSegment-BS1;BorrowerSegment;BS2;Тестовый сегмент 2;;2;BorrowerSegment-BS2;BorrowerSegment;BS3;Малый;Малый;3;BorrowerSegment-BS3;BorrowerSegment;BS4;Микро;;4;;BorrowerSegment;Retail;Розница;;5;BorrowerSegment-Retail;BorrowerSegment;BMO;БМО;;;BorrowerSegment-BMO;9BorrowerSegment;Engineering;Клиенты Машиностроения;;;BorrowerSegment-Engineering;7BorrowerSegment;Largest;Крупнейшие;;;BorrowerSegment-Largest;5BorrowerSegment;Large;Крупные;;;BorrowerSegment-Large;4BorrowerSegment;Small;Малые;;;BorrowerSegment-Small;2BorrowerSegment;Micro;Микро;Микро;;;1BorrowerSegment;Defence;ОПК;;;BorrowerSegment-Defence;BorrowerSegment;AnnualRevenue;Отсутствует информация об объеме годовой выручки;;;BorrowerSegment-AnnualRevenue;10BorrowerSegment;Reggossektor;Рег. госсектор;;;BorrowerSegment-Reggossektor;8BorrowerSegment;Average 2;Средние;;;BorrowerSegment-Average 2;3BorrowerSegment;Fininst;Фин. институты;;;BorrowerSegment-Fininst;6"

        println("-----------api-----------")

       val result = assistant.chat(request)

        println("-----------result-----------")

        println(result)

        println("-----------sch-----------")

        //val result2 = assistant.chat2()
        val result2 = schemaAssistent.chat(result)

        println("-----------sch res-----------")

        println(result2)

//        val client: GigaChatClient = GigaChatClient.builder()
//                .verifySslCerts(false)
//                .authClient(AuthClient.builder()
//                        .withOAuth(OAuthBuilder.builder()
//                                .scope(Scope.GIGACHAT_API_PERS)
//                                .authKey("Njk5OGM4NjktZTYxYi00ZWZlLWE5NDgtZjk5NGQxZDg2MDIzOjJmMzI2M2ExLTBiYTQtNDUwZC1hOWM5LWRmZDE2ZTYxYzRhZg==")
//                                .build())
//                        .build())
//                .build()
//
//        println("-----------api-----------")
//
//        println(client.completions(CompletionRequest.builder()
//                .model(ModelName.GIGA_CHAT_MAX)
//                .message(ChatMessage.builder()
//                        .content("Какие факторы влияют на стоимость страховки на дом?")
//                        .role(USER)
//                        .build())
//                .build()))
    }
}