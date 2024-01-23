package com.example.demo.repository

import com.example.demo.dto.ClassifierValue
import org.springframework.data.jpa.repository.JpaRepository

interface ClassifierValueRepository : JpaRepository<ClassifierValue, Long> {
}