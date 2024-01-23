package com.example.demo.repository

import com.example.demo.dto.ClassifierType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ClassifierTypeRepository : JpaRepository<ClassifierType, Long> {
}