package org.student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.student.app.model.Student;
import org.student.app.repository.StudentRepository;
import org.student.app.util.StudentMapper;
import org.student.app.dto.StudentRequest;
import org.student.app.dto.StudentResponse;
import org.student.app.exception.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public void addStudent(StudentRequest request) {
        logger.info("Adding student: {}", request);
        Student student = studentMapper.toEntity(request);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.warn("Deleting student with id {}", id);
        studentRepository.deleteById(id);
    }

    public StudentResponse getStudentById(Long id) {
        logger.info("Fetching student with id {}", id);
        return studentRepository.findById(id)
            .map(studentMapper::toResponse)
            .orElseThrow(() -> {
                logger.error("Student with id {} not found", id);
                return new StudentNotFoundException("Student with id " + id + " not found");
            });
    }
    
    public List<StudentResponse> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll()
            .stream()
            .map(studentMapper::toResponse)
            .toList();
    }
    
    public void updateStudent(Long id, StudentRequest studentRequest) {
        logger.info("Updating student with id {}", id);
        if (studentRepository.existsById(id)) {
            Student student = studentMapper.toEntity(studentRequest);
            student.setId(id);
            studentRepository.save(student);
        } else {
            logger.error("Student with id {} not found for update", id);
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
    }
}    
