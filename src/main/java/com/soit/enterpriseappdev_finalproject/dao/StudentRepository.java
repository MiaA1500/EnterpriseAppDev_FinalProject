package com.soit.enterpriseappdev_finalproject.dao;

import com.soit.enterpriseappdev_finalproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Method to sort the results by last name
    public List<Student> findAllByOrderByLastNameAsc();

}
