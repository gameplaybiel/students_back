package com.project.students;

import com.project.students.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentsApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
		assertThat(studentRepository).isNotNull();
	}

}
