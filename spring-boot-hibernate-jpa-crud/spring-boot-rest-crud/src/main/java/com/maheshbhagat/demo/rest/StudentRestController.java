package com.maheshbhagat.demo.rest;

import com.maheshbhagat.demo.entity.Student;
import com.maheshbhagat.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{studentId}")
    public Student createStudent(@PathVariable int studentId){

        Student student = studentService.findStudentById(studentId);
        return student;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println("StudentRestController.createStudent");
        studentService.save(student);
        return student;
    }
}
