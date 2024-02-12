package com.maheshbhagat.cruddemo.dao;

import com.maheshbhagat.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
