package com.sahmwanga.demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sahmwanga.demo.entity.Guardian;
import com.sahmwanga.demo.entity.Student;

import java.util.*;

@SpringBootTest // use this for standard test, since we want to see the created data;
// @DataJpaTest // this is used when you want to create data and flush the data
// after the test
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sahmwanga@gmail.com")
                .firstName("salehe")
                .lastName("mwanga")
                // .guardianName("Hamimu")
                // .guardianEmail("hamimu@gmail.com")
                // .guardianMobile("255653679553")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStutentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("hamimu@gmail.com")
                .name("Salehe")
                .mobile("255653679553")
                .build();

        Student student = Student.builder()
                .firstName("Yusra")
                .lastName("Salehe")
                .emailId("sahmwanga1@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> students = studentRepository.findAll();
        System.out.println("StudentList = " + students);

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Yusra");
        System.out.println("Student by first name: " + students);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("test", "sahmwanga@gmail.com");
    }
}