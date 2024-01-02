package com.sahmwanga.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sahmwanga.demo.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    // JPQL
    @Query("select s from Student s where s.emailId =?1 ")
    Student getStudentByEmailAddress(String emailId);

    // Native
    @Query(value = "SELECT * FROM tbl_student s where s.email_address =?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    // Native named params
    @Query(value = "SELECT * FROM tbl_student s where s.email_address =:emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE  tbl_student set first_name =?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
