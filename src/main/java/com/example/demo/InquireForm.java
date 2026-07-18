package com.example.demo;

import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class InquireForm {

    @Size(min = 1, max = 100)
    private String email;

    @Size(min = 1, max = 20)
    private String name;

    @Size(min = 1, max = 500)
    private String body;
}