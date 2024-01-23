package com.example.demo.controllers

import com.example.demo.dto.ClassifierType
import com.example.demo.dto.ClassifierValue
import com.example.demo.dto.ResponseDto
import com.example.demo.service.GetDataService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data")
class DataController(private val getDataService: GetDataService) {

    @GetMapping
    fun collectData() : ResponseEntity<MutableList<ResponseDto>> {
        return ResponseEntity(getDataService.getData(), HttpStatus.OK)
    }
    @GetMapping("/8")
    fun collectData8() : ResponseEntity<MutableList<ClassifierValue>> {
        return ResponseEntity(getDataService.saveDicValues(), HttpStatus.OK)
    }
    @GetMapping("/id")
    fun byId() : ResponseEntity<List<ClassifierType>> {
        return ResponseEntity(getDataService.findById(), HttpStatus.OK)
    }
}