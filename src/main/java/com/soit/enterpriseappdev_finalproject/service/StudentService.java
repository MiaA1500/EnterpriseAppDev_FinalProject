package com.soit.enterpriseappdev_finalproject.service;

import com.soit.enterpriseappdev_finalproject.dao.StudentRepository;
import com.soit.enterpriseappdev_finalproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int theId) {
        return studentRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
