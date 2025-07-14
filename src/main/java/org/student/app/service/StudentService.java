package org.student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.student.app.model.Student;
import org.student.app.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public void updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        }
    }
}    
