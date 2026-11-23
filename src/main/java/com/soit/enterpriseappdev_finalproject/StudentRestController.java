package com.soit.enterpriseappdev_finalproject;

import com.soit.enterpriseappdev_finalproject.entity.Student;
import com.soit.enterpriseappdev_finalproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    // READ: list all students, ordered by last name
    @GetMapping("/view")
    public ResponseEntity<List<Student>> view() {
        return ResponseEntity.ok(studentService.findAll());
    }

    // CREATE / UPDATE: save a student record
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student theStudent) {
        studentService.save(theStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(theStudent);
    }

    // DELETE: remove a student record
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("studentId") int theId) {
        if (studentService.findById(theId) == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteById(theId);
        return ResponseEntity.noContent().build();
    }

}
