package ru.kalugin.ai.usecase.agent

import java.io.Serializable

data class InitData(
    val csv: String,
    val contract: String
) : Serializable