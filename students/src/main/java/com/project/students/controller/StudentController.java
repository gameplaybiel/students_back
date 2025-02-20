package com.project.students.controller;

import com.project.students.model.Student;
import com.project.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000") // React
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getByStudentsById(@PathVariable Long id){
        return service.getStudentsById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

}
