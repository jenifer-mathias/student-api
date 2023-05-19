package br.com.jms.model

import javax.persistence.*

@Entity
data class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    @Column(name = "student_first_name")
    val firstName: String,

    @Column(name = "student_last_name")
    val lastName: String,

    @Column(name = "student_age")
    val age: Int?,

    @Column(name = "student_cellphone_number")
    val cellphone: Int?,

    @Column(name = "student_serie")
    val serie: Int
)