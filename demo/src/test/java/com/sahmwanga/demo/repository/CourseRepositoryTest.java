package com.sahmwanga.demo.repository;

import com.sahmwanga.demo.entity.Course;
import com.sahmwanga.demo.entity.Student;
import com.sahmwanga.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Yasri")
                .lastName("hamimu")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("jj")
                .lastName("mmm")
        .build();

        Student student = Student.builder()
                .firstName("student")
                .lastName("test")
                .emailId("jjj@exmapl.eocm")
                .build();

        Course course = Course.builder()
                .title("new course")
                .credit(4)
                .teacher(teacher)
                .build();

        course.addStudent(student);
        courseRepository.save(course);
    }
}
