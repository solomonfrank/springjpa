package com.example.spring_jp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.spring_jp.entity.Course;
import com.example.spring_jp.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private ICourseRepository courseRepository;

    @Test
    public void fetchCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses " + " " + courses);

    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        Course course = Course.builder()
                .code("Mth101")
                .name("Statistics")
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    public void findAllPagination() {
        Pageable firstThreeRecord = PageRequest.of(0, 3);
        Page<Course> pageQuery = courseRepository.findAll(firstThreeRecord);
        List<Course> courses = pageQuery.getContent();

        Long totalCount = pageQuery.getTotalElements();

        int totalPages = pageQuery.getTotalPages();

        System.out.println("totalElement " + totalCount + " " + totalPages + " " + courses);
    }

    public void sortItem() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("name"));
        Pageable sortByCode = PageRequest.of(0, 3, Sort.by("code").descending());
        List<Course> coursesByTitle = courseRepository.findAll(sortByTitle).getContent();

    }

    public void firstByNameContaining() {

        Pageable firstThreeRecord = PageRequest.of(0, 3);

        List<Course> courses = courseRepository.findByNameContaining("serr", firstThreeRecord).getContent();

    }
}
