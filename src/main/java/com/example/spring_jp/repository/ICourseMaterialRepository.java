package com.example.spring_jp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_jp.entity.CourseMaterial;

@Repository
public interface ICourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
