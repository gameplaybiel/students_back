package com.project.students.service;

import com.project.students.model.Student;
import com.project.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Optional<Student> getStudentsById(Long id){
        return repository.findById(id);
    }

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
}
