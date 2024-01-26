package com.example.spring_jp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_jp.entity.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

}