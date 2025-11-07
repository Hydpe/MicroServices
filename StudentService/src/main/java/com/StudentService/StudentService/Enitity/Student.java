package com.StudentService.StudentService.Enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Students")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(length=100,nullable=false)
    String name;
    @Column(length=100,nullable=false,unique=true)
    String email;
    @Column(length=100,nullable=false)
    String password;
    Student(int id, String name, String email, String Password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password= Password;
    }


}
