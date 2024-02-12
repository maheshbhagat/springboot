package com.maheshbhagat.demo.dao;

import com.maheshbhagat.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {

        return entityManager.merge(student);
    }

    @Override
    public Student findStudentById(int studentId) {

        return entityManager.find(Student.class, studentId);
    }
}
