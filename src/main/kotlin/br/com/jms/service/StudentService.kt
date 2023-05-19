package br.com.jms.service

import br.com.jms.model.Student
import br.com.jms.repository.StudentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService(val repository: StudentRepository) {

    fun getAllStudents(): List<Student> = repository.findAll()

    fun getStudentById(id: Long): Student =
        repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun createStudent(students: List<Student>): List<Student> {
        val savedStudent = mutableListOf<Student>()
        for (student in students) {
            savedStudent.add(repository.save(student))
        }
        return repository.findAll()
    }

    fun removeStudent(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun updateStudent(id: Long, student: Student): Student {
        return if (repository.existsById(id)) {
            student.id = id
            repository.save(student)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}