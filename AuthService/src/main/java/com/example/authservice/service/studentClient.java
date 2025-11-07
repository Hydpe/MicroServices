package com.example.authservice.service;

import com.example.authservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="student-service")
public interface studentClient {
       @GetMapping("/student/email/{email}")
       Student findByEmail(@PathVariable("email") String email);
       @PostMapping("/student")
       Student save(@RequestBody Student student);
       @GetMapping("/student")
       List<Student> findAll();
       @PutMapping("/student")
       List<Student> update(@RequestBody List<Student> students);
       @PutMapping("/student/{id}")
       Student  updateById(@RequestBody Student student,@PathVariable("id") Long id);
       @DeleteMapping("/student/{id}")
       Student deleteById(@PathVariable("id") Long id);
}
