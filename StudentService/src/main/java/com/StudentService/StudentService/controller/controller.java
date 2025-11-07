package com.StudentService.StudentService.controller;

import com.StudentService.StudentService.Enitity.Student;
import com.StudentService.StudentService.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class controller {
    @Autowired
    private service Service;

    public controller(service Service) {
        this.Service = Service;
    }

    @GetMapping
    public List<Student> findAll(){
        return Service.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        return Service.findById(id);
    }
    @GetMapping("/email/{email}")
    public Student findByEmail(@PathVariable String email){
        return Service.findByEmail(email);
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        System.out.println("Received "+student);
        return Service.save(student);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        Service.deleteById(id);
    }
    @PutMapping
    public List<Student> update(@RequestBody List<Student> students){
        return  Service.update(students);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        return Service.updateById(student,id);
    }
}
