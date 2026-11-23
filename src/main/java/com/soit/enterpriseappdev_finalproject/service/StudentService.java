package com.soit.enterpriseappdev_finalproject.service;

import com.soit.enterpriseappdev_finalproject.dao.StudentRepository;
import com.soit.enterpriseappdev_finalproject.entity.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository theStudentRepository) {
        this.studentRepository = theStudentRepository;
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
