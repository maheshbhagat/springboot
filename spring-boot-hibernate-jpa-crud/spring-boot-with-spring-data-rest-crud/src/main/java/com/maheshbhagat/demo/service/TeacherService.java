package com.maheshbhagat.demo.service;

import com.maheshbhagat.demo.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAll();

    Optional<Teacher> findById(int teacherId);
    Teacher save(Teacher teacher);
}
