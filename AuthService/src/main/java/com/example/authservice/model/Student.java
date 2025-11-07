package com.example.authservice.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    long id;
    String name;
    String email;
    String password;
}
