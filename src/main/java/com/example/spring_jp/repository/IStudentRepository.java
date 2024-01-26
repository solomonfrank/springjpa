package com.example.spring_jp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring_jp.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    // custom queries
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastName(String lastName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public Student findByLastNameAndFirstName(String lastName, String firstName);

    // using sql query. ?1 rep the first param.
    // JPQL the are based on the class not the table attributes
    @Query("Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailAddress);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    // native query
    @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailAddress);

    // native query param
    @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailAddress);

    @Query(value = "update tbl_student s set first_name=?1 where s.email_address = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    int updateStudentByEmailI(String firstName, String emailId);

}
