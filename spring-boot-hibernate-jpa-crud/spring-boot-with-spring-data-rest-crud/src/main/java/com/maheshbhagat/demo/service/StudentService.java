package com.maheshbhagat.demo.service;

import com.maheshbhagat.demo.dao.StudentDAO;
import com.maheshbhagat.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student findStudentById(int studentId){

        return studentDAO.findStudentById(studentId);
    }

    @Transactional
    public Student save(Student student) {
        return studentDAO.save(student);
    }
}
