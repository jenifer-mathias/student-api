package br.com.jms.controller

import br.com.jms.model.Student
import br.com.jms.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/student")
@RestController
class PlayerController(val service: StudentService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createStudent(@RequestBody student: List<Student>) = service.createStudent(student)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteStudent(@PathVariable id: Long) = service.removeStudent(id)

    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long, @RequestBody student: Student
    ) = service.updateStudent(id, student)

    @GetMapping
    fun getStudents() = service.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long) = service.getStudentById(id)
}