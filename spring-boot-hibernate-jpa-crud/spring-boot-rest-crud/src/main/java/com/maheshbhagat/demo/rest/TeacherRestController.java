package com.maheshbhagat.demo.rest;

import com.maheshbhagat.demo.entity.Student;
import com.maheshbhagat.demo.entity.Teacher;
import com.maheshbhagat.demo.service.StudentService;
import com.maheshbhagat.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeacherRestController {

    private TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher/{teacherId}")
    public Teacher create(@PathVariable int teacherId){

        Optional<Teacher> teacher = teacherService.findById(teacherId);
        return teacher.get();
    }

    @PostMapping("/teacher/create")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        System.out.println("TeacherRestController.createTeacher");

        return teacherService.save(teacher);
    }
}
