package com.example.demo.service

import com.example.demo.dto.Filter
import com.example.demo.dto.RequestDto
import com.example.demo.dto.ResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.stream.Collector

@Service
class GetDataService(private var objectMapper: ObjectMapper,
                     private val restTemplate: RestTemplate) {
    final val url1: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/a8f2b78e-de3b-431d-9477-e2d58d204c44/responders?size=100000000"
    final val url2: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/1886e1cc-2aec-42ef-85df-e89841abca15/responders?size=100000000"
    final val url3: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/40634f51-1fdf-4885-84e0-0ac2a39ecd4e/responders?size=100000000"
    final val url4: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/1886e1cc-2aec-42ef-85df-e89841abca15/responders?size=100000000"
    final val url5: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/054dc50a-a3f0-49bd-af0e-9396cd7dd212/responders?size=100000000"
    final val url6: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/3048ae9c-8b6d-4f22-ab54-fbe0e1f0d2e0/responders?size=100000000"
    final val url7: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/ea9a6302-cc90-473a-a0c0-0aecfacb3a43/responders?size=100000000"
    final val url8: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/426433bb-47a7-4a27-a972-d717be9d369f/responders?size=100000000"
    final val urlList: List<String> = listOf(url1, url2, url3, url4, url5, url6, url7)

    fun getData() : MutableList<ResponseDto> {
        val result: MutableList<ResponseDto> = mutableListOf()
        urlList.stream()
            .forEach { url ->
                val response = restTemplate.postForEntity(
                    url,
                    RequestDto(RequestDto.Content(), Filter()),
                    ResponseDto::class.java
                ).body
                result.add(response!!)
            }
        result.forEach { r -> println(r) }
        return result
    }
    fun getDataUrl8() : ResponseDto {
        val response = restTemplate.postForEntity(url8, RequestDto(RequestDto.Content(), Filter()), ResponseDto::class.java
        ).body!!
        return response
    }
}