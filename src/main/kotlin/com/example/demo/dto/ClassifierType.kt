package com.example.demo.dto

import jakarta.persistence.*

@Entity
@Table(name = "classifier_type", schema = "public")
data class ClassifierType(@Id
                          @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classifier_type_id_gen")
                          @SequenceGenerator(name = "classifier_type_id_gen", sequenceName = "classifier_type_id_seq", allocationSize = 1)
                          @Column(name = "id", nullable = false)
                           var id: Long? = null,

    @Column(name = "name", length = Integer.MAX_VALUE)
 var name: String? = null,

@Column(name = "code", length = Integer.MAX_VALUE)
 var code: String? = null,

@Column(name = "external_sync")
open var externalSync: Boolean? = null,

@Column(name = "parent_code", length = Integer.MAX_VALUE)
open var parentCode: String? = null) {

    override fun toString(): String {
        return "ClassifierType(id=$id, name=$name, code=$code, externalSync=$externalSync, parentCode=$parentCode)"
    }


}