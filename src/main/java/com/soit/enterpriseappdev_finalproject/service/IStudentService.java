package com.soit.enterpriseappdev_finalproject.service;

import com.soit.enterpriseappdev_finalproject.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);
    public void deleteById(int id);

}
