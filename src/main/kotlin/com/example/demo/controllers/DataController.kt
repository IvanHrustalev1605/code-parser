package com.example.demo.controllers

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
    fun collectData8() : ResponseEntity<ResponseDto> {
        return ResponseEntity(getDataService.getDataUrl8(), HttpStatus.OK)
    }
}