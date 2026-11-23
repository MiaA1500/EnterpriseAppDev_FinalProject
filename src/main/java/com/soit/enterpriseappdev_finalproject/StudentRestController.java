package com.soit.enterpriseappdev_finalproject;

import com.soit.enterpriseappdev_finalproject.entity.Student;
import com.soit.enterpriseappdev_finalproject.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    private final IStudentService studentService;

    public StudentRestController(IStudentService theStudentService) {
        this.studentService = theStudentService;
    }

    //endpoints

    //View Student Directory - returns the students as JSON
    @GetMapping("/view")
    public List<Student> view() {
        return studentService.findAll();
    }

    //PAGE - Add Student Page
    @GetMapping("/add")
    public String add() {
        return "add";
    }

    //PAGE - Edit Student Page
    @GetMapping("/edit")
    public String edit(@RequestParam("studentId") int id) {
        return "edit";
    }

    //Create/Update student record
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student theStudent) {
        studentService.save(theStudent);
        return "create";
    }

    // Delete student record (DELETE, not GET, because it modifies data)
    @DeleteMapping("/delete/{studentId}")
    public String delete(@PathVariable int studentId) {
        studentService.deleteById(studentId);
        return "delete";
    }

}
