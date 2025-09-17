package org.student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.student.app.model.Student;
import org.student.app.repository.StudentRepository;
import org.student.app.exception.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        logger.info("Adding student: {}", student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.warn("Deleting student with id {}", id);
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        logger.info("Fetching student with id {}", id);
        return studentRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Student with id {} not found", id);
                return new StudentNotFoundException("Student with id " + id + " not found");
            });
    }
    
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }
    
    public void updateStudent(Long id, Student student) {
        logger.info("Updating student with id {}", id);
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        } else {
            logger.error("Student with id {} not found for update", id);
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
    }
}    
