package com.maheshbhagat.demo.repository;

import com.maheshbhagat.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tea")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
