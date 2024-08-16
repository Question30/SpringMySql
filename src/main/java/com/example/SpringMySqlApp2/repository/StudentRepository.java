package com.example.SpringMySqlApp2.repository;

import com.example.SpringMySqlApp2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByAccountNo(Long accountNO);
    List<Student> findByNameContaining(String name);
}
