package com.soit.enterpriseappdev_finalproject;

import com.soit.enterpriseappdev_finalproject.entity.Student;
import com.soit.enterpriseappdev_finalproject.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    //endpoints

    //PAGE - View Student Directory
    @GetMapping("/view")
    public List<Student> view() {
        //Get students from DB
        return studentService.findAll();
    }

    //PAGE - Add Student Page
    @GetMapping("/add")
    public String add(Model theModel) {
        return "add";
    }

    //PAGE - Edit Student Page
    @GetMapping("/edit")
    public String edit(@RequestParam("studentId") int id, Model theModel) {
        return "edit";
    }

    //Create/Update student record
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student theStudent) {
        studentService.save(theStudent);
        return "create";
    }

    // Delete student record
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {
        studentService.deleteById(theId);
        return "delete";
    }

}
