package org.student.app.util;

import org.springframework.stereotype.Component;

import org.student.app.model.Student;
import org.student.app.dto.StudentRequest;
import org.student.app.dto.StudentResponse;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setId(request.id());
        student.setName(request.name());
        student.setEmail(request.email());
        student.setPhone(request.phone());
        return student;
    }

    public StudentResponse toResponse(Student student) {
        return new StudentResponse(
            student.getId(),
            student.getName(),
            student.getEmail(),
            student.getPhone()
        );
    }

}
