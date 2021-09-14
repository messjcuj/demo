package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select s from Student s")
    List<Student>getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into Student(name, score) values(?1,?2)", nativeQuery = true)
    void addStudent(String name, Double score);

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.name = ?2, s.score =?3 where s.id = ?1",nativeQuery = true)
    void updateStudent(Integer id, String name, Double score);

    @Transactional
    @Modifying
    @Query(value ="delete from Student s where s.id = ?1",nativeQuery = true)
    void deleteStudent(Integer id);





}
