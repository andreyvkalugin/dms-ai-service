package ru.kalugin.ai.rest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kalugin.ai.usecase.agent.DataConversionAgent
import ru.kalugin.ai.usecase.agent.InitData

@RestController
@RequestMapping("/agents")
class AgentController(
    val agent: DataConversionAgent
) {

    @PostMapping("/schema")
    fun obtainSchema(@RequestBody requestBody: RequestDto): String = agent
        .obtainSchema(
            InitData(
                csv = requestBody.csv,
                contract = requestBody.contract
            )
        )
        .let { it.lastMessage as String }
}
