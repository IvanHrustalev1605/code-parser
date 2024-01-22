package com.example.demo.dto

class ResponseDto(val content: List<Content>) {
    override fun toString(): String {
        return "ResponseDto(content=$content)"
    }
}
