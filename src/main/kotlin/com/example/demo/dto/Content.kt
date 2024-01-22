package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
@JsonIgnoreProperties(ignoreUnknown = true)
class Content( @JsonProperty(value = "fullName") val fullName: String,
              @JsonProperty(value = "routingCode", required = false) val routingCode: String) {
    override fun toString(): String {
        return "Content(fullName='$fullName', routingCode='$routingCode')"
    }
}