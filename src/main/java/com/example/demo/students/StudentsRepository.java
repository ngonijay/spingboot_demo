package com.example.demo.students;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository  extends JpaRepository<Student,Long> {


    Optional<Student> findStudentByEmail(String email);
}
