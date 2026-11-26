package com.soit.enterpriseappdev_finalproject;

import com.soit.enterpriseappdev_finalproject.entity.Student;
import com.soit.enterpriseappdev_finalproject.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    public StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    //endpoints

    //PAGE - View Student Directory
    @GetMapping("/view")
    public String view(Model theModel) {
        //Get students from DB
        List<Student> students = studentService.findAll();

        //Add students to the Model
        theModel.addAttribute("students", students);

        return "list-students";
    }

    //PAGE - Add Student Page
    @GetMapping("/add")
    public String add(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }

    //PAGE - Edit Student Page
    @GetMapping("/edit")
    public String edit(@RequestParam("studentId") int id, Model theModel) {
        Student theStudent = studentService.findById(id);
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }

    //Create/Update student record
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student theStudent) {
        studentService.save(theStudent);
        return "redirect:/student/view";
    }

    // Delete student record
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {
        studentService.deleteById(theId);
        return "redirect:/student/view";
    }

}
