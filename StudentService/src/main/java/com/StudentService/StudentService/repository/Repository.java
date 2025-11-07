package com.StudentService.StudentService.repository;

import com.StudentService.StudentService.Enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
}
