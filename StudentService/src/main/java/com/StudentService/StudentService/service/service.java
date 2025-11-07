package com.StudentService.StudentService.service;

import com.StudentService.StudentService.Enitity.Student;
import com.StudentService.StudentService.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class service {
    @Autowired
    private Repository repository;

    public service(Repository repository) {
        this.repository = repository;
    }
    public Student findById(Long id) {
        return repository.findById(id).get();
    }
    public List<Student> findAllStudents() {
        return repository.findAll();
    }
    public Student save(Student student) {
        return repository.save(student);
    }

    public Student findByEmail(String email){
        return repository.findByEmail(email);
    }
    public List<Student> update(List<Student> students){
        return repository.saveAll(students);
    }
    public Student updateById(Student student,Long id){
            Student stu=findById(id);
            if(stu!=null){
                stu.setEmail(student.getEmail());
                stu.setName(student.getName());
                stu.setPassword(student.getPassword());
            }
            return repository.save(stu);
    }
    public String deleteById(Long id){
        repository.deleteById(id);
        return "Success";
    }

}
