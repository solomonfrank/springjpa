package com.example.spring_jp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_jp.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByNameContaining(String name, Pageable pageRequest);

}
