package org.student.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.student.app.dto.StudentRequest;
import org.student.app.dto.StudentResponse;
import org.student.app.model.Student;
import org.student.app.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/api/v1/students")
@Tag(name = "Student Management", description = "API for managing students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private static final String REDIRECT_STUDENTS = "redirect:/api/v1/students";

    private static final String MODEL_STUDENT = "student";

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Get all students", description = "Retrieve a list of all students")
    public String getAllStudents(Model model) {
        logger.info("Fetching all students");
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/add")
    @Operation(summary = "Show add student form", description = "Display the form to add a new student")
    public String addStudentForm(Model model) {
        logger.info("Showing add student form");
        model.addAttribute(MODEL_STUDENT, new Student());
        return "student-add";
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new student", description = "Create a new student")
    public String addStudent(@ModelAttribute StudentRequest studentRequest) {
        logger.info("Adding new student: {}", studentRequest.name());
        studentService.addStudent(studentRequest);
        return REDIRECT_STUDENTS;
    }

    @GetMapping("/edit/{id}")
    @Operation(summary = "Show edit student form", description = "Display the form to edit an existing student")
    public String editStudentForm(@PathVariable Long id, Model model) {
        logger.info("Showing edit student form for ID: {}", id);
        StudentResponse studentResponse = studentService.getStudentById(id);
        if (studentResponse == null) {
            return REDIRECT_STUDENTS;
        }
        model.addAttribute(MODEL_STUDENT, studentResponse);
        return "student-edit";
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an existing student", description = "Update the details of an existing student")
    public String editStudent(@PathVariable Long id, @ModelAttribute StudentRequest studentRequest) {
        logger.info("Editing student with ID: {}", id);
        studentService.updateStudent(id, studentRequest);
        return REDIRECT_STUDENTS;
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a student", description = "Remove a student by ID")
    public String deleteStudent(@PathVariable Long id) {
        logger.info("Deleting student with ID: {}", id);
        studentService.deleteStudent(id);
        return REDIRECT_STUDENTS;
    }

    @GetMapping("/{id}")
    @Operation(summary = "View student details", description = "View detailed information about a specific student")
    public String viewStudent(@PathVariable Long id, Model model) {
        logger.info("Viewing student with ID: {}", id);
        StudentResponse studentResponse = studentService.getStudentById(id);
        if (studentResponse == null) {
            return REDIRECT_STUDENTS;
        }
        model.addAttribute(MODEL_STUDENT, studentResponse);
        return "view-student";
    }

}
