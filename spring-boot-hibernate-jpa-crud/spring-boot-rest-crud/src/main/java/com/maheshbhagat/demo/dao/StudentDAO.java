package com.maheshbhagat.demo.dao;

import com.maheshbhagat.demo.entity.Student;

public interface StudentDAO {

    Student save(Student student);

    Student findStudentById(int studentId);
}
