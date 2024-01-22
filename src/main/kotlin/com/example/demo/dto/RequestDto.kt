package com.example.demo.dto

class RequestDto (    val content: Content,
                      val filter: Filter){
    data class Content(
        val smevArea: String = "PROD"
    )
}