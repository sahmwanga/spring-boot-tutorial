package com.sahmwanga.demo.repository;

import com.sahmwanga.demo.entity.Course;
import com.sahmwanga.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseMath = Course.builder()
                .title("Mathematics")
                .credit(5)
                .build();
        Course coursePhy = Course.builder()
                .title("Physics")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Juma")
                .lastName("Hassani")
//                .courses(List.of(courseMath, coursePhy))
                .build();

        teacherRepository.save(teacher);
    }
}