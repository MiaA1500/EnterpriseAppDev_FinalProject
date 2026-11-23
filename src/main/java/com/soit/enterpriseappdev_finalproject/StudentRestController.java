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

    //PAGE - View Student Directory
    @GetMapping("/view")
    public String view() {
        //Get students from DB
        List<Student> students = studentService.findAll();

        return students.toString();
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

    // Delete student record
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {
        studentService.deleteById(theId);
        return "delete";
    }

}
