package com.frisktale.lesson1.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private int age;
    private String name;
    private String email;
}