package com.maheshbhagat.demo.repository;

import com.maheshbhagat.demo.entity.Student;
import com.maheshbhagat.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
