package com.example.spring_jp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_jp.entity.Course;
import com.example.spring_jp.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
                .code("Mth101")
                .name("Statistics")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                // .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
}
