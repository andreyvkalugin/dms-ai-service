package ru.kalugin.ai.assistent

import com.fasterxml.jackson.annotation.JsonProperty


data class Model (
    @JsonProperty("BorrowerSegment")
    var borrowerSegment: String,
    @JsonProperty("Description")
    var description: String,
    @JsonProperty("Group")
    var group: String,
    @JsonProperty("Priority")
    var priority: String,
    @JsonProperty("Value")
    var value: String
)