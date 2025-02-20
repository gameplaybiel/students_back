package com.project.students;

import com.project.students.model.Student;
import com.project.students.repository.StudentRepository;
import com.project.students.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents(){
        Student student = new Student(1L, "Gabriel", "gabriel@email.com");
        Student student2 = new Student(2L, "João", "joao@email.com");
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student, student2));

        List<Student> students = studentService.getAllStudents();

        assertNotNull(students);
        assertEquals(2, students.size());
        assertEquals("Gabriel", students.get(0).getName());
    }

    @Test
    void testGetStudentById(){
        Student student = new Student(1L, "Gabriel", "gabriel@email.com");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Optional<Student> foundStudent = studentService.getStudentsById(1L);

        assertTrue(foundStudent.isPresent());
        assertEquals("Gabriel", foundStudent.get().getName());
    }

    @Test
    void testSaveStudent(){
        Student student = new Student(null, "Gabriel", "gabriel@email.com");
        when(studentRepository.save(student)).thenReturn(new Student(1L, "Gabriel", "gabriel@email.com"));

        Student savedStudent =   studentService.saveStudent(student);

        assertNotNull(savedStudent);
        assertEquals(1L, savedStudent.getId());
        assertEquals("Gabriel", savedStudent.getName());
    }

    @Test
    void testDeleteStudent(){
        doNothing().when(studentRepository).deleteById(1L);
        assertDoesNotThrow(() -> studentService.deleteStudent(1L));
        verify(studentRepository, times(1)).deleteById(1L);
    }
}
