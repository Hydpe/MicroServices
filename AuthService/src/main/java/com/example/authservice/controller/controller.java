package com.example.authservice.controller;

import com.example.authservice.jwtUtiliy.JwtUtil;
import com.example.authservice.model.Student;
import com.example.authservice.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class controller {
    @Autowired
    private service Service;
    public controller(service Service){
        this.Service = Service;
    }
    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping
    public String get()
    {
        return "SUccess";
    }
    @GetMapping("/{email}/{password}")
    public ResponseEntity<String> Login(@PathVariable("email") String email,@PathVariable("password") String password ){

           Student student = Service.login(email);
           if(student != null && student.getPassword().equals(password)){
               String Token=jwtUtil.generateToken(email);
               return ResponseEntity.ok(Token);
           }
           return  ResponseEntity.ok("Email or password is incorrect");
    }
    @PostMapping
    public Student register(@RequestBody Student student){
          return  Service.Save(student);
    }
    @PutMapping("/Update")
    public List<Student> register(@RequestBody List<Student> students){
         return Service.Save(students);
    }
    @PutMapping("/Update/{id}")
    public void update(@RequestBody Student student, @PathVariable("id") Long id){
         Service.update(student,id);
    }
    @GetMapping("/List")
    public ResponseEntity<List<Student>> getAll(@RequestHeader("Authorization") String authHeader){
        String  token = authHeader.replace("Bearer ", "");
        boolean validToken = jwtUtil.validateToken(token);
        if(validToken){
            List<Student> list = Service.getAll();
            return ResponseEntity.ok(list);
        }
        else
            return ResponseEntity.badRequest().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Service.delete(id);
        return ResponseEntity.ok("Deleted");
    }

}
