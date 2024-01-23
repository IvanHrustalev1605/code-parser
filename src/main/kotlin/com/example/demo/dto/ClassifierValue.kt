package com.example.demo.dto

import jakarta.persistence.*

@Entity
@Table(name = "classifier_value", schema = "public")
open class ClassifierValue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classifier_value_id_gen")
    @SequenceGenerator(name = "classifier_value_id_gen", sequenceName = "classifier_value_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "code", length = Integer.MAX_VALUE)
    open var code: String? = null

    @Column(name = "name", length = Integer.MAX_VALUE)
    open var name: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classifier_type_id", nullable = false)
    open var classifierType: ClassifierType? = null

    @Column(name = "parent_code", length = Integer.MAX_VALUE)
    open var parentCode: String? = null

    @Column(name = "position")
    open var position: Int? = null

    @Column(name = "comment", length = Integer.MAX_VALUE)
    open var comment: String? = null
    override fun toString(): String {
        return "ClassifierValue(id=$id, code=$code, name=$name, classifierType=$classifierType, parentCode=$parentCode, position=$position, comment=$comment)"
    }


}