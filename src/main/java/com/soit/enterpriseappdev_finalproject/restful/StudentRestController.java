package com.soit.enterpriseappdev_finalproject.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    public StudentRestController() {

    }

    //endpoints

    //View Student Directory
    @GetMapping("/view")
    public String view() {
        return "view";
    }

    //Create student record
    @PostMapping("/create")
    public String create() {
        return "create";
    }

    //Update student record
    @PostMapping("/update")
    public String update() {
        return "update";
    }

    // Delete student record
    @PostMapping("/delete")
    public String delete() {
        return "delete";
    }

}
