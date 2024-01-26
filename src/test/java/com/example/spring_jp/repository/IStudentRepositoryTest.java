package com.example.spring_jp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_jp.entity.Guardian;
import com.example.spring_jp.entity.Student;

@SpringBootTest
public class IStudentRepositoryTest {
    @Autowired
    private IStudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("solomon@est.com")
                .firstName("Solomon")
                .lastName("Rock")
                // .guardianEmail("john@test.com")
                // .guardianName("John doe")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentGuardian() {

        Guardian guardian = Guardian.builder()
                .email("sarah@test.com")
                .mobile("0877737737373")
                .name("Sarah")
                .build();

        Student student = Student.builder()
                .emailId("solomon12@est.com")
                .firstName("Solomon")
                .lastName("Rock")
                .guardian(guardian)
                // .guardianEmail("john@test.com")
                // .guardianName("John doe")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("solomon");
        System.out.println(students);
    }
}
