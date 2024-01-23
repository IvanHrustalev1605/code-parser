package com.example.demo.service

import com.example.demo.dto.*
import com.example.demo.repository.ClassifierTypeRepository
import com.example.demo.repository.ClassifierValueRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GetDataService(private var objectMapper: ObjectMapper,
                     private val restTemplate: RestTemplate,
                     private val classifierTypeRepository: ClassifierTypeRepository,
                     private val classifierValueRepository: ClassifierValueRepository) {
    //url2 - 1315
    //url3 - 1316
    //url5 - 1317
    //url6 - 1318
    //url1 - 1319
    final val url1: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/a8f2b78e-de3b-431d-9477-e2d58d204c44/responders?size=100000000"
    final val url2: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/1886e1cc-2aec-42ef-85df-e89841abca15/responders?size=100000000"
    final val url3: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/40634f51-1fdf-4885-84e0-0ac2a39ecd4e/responders?size=100000000"
    final val url5: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/054dc50a-a3f0-49bd-af0e-9396cd7dd212/responders?size=100000000"
    final val url6: String = "https://lkuv.gosuslugi.ru/api/inquiry/public/v1/inquiries/versions/3048ae9c-8b6d-4f22-ab54-fbe0e1f0d2e0/responders?size=100000000"
    final val urlList: List<String> = listOf(url1, url2, url3, url5, url6)

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
    fun saveDicValues() : MutableList<ClassifierValue> {
        val result = mutableListOf<ClassifierValue>()
        restTemplate.postForEntity(url6, RequestDto(RequestDto.Content(), Filter()), ResponseDto::class.java
        ).body!!.content.stream()
            .forEach { r ->
                val classifierValue = ClassifierValue()
                classifierValue.code = r.routingCode
                classifierValue.name = r.fullName
                classifierValue.classifierType = classifierTypeRepository.findById(1318).get()!!
                result.add(classifierValue)
            }
        classifierValueRepository.saveAll(result)
        return result
    }
    fun findById() : List<ClassifierType> {
        return classifierTypeRepository.findAll()
    }
}