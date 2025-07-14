package org.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.student.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
