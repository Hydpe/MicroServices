package com.example.authservice.service;

import com.example.authservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
       @Autowired
       private studentClient studentClient;
       public service(studentClient studentClient){
           this.studentClient = studentClient;
       }
       public Student login(String email){
           return studentClient.findByEmail(email);
       }

       public Student Save(Student student){
           return studentClient.save(student);
       }
       public List<Student> getAll(){
           return studentClient.findAll();
       }
       public List<Student> Save(List<Student> students){
           return studentClient.update(students);
       }
       public Student update(Student student,Long id){
           return studentClient.updateById(student,id);
       }
       public Student delete(Long id){
           return studentClient.deleteById(id);
       }
}
