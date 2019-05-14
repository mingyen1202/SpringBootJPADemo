package com.example.springBootJPADemo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerForm {

    @NotNull
    @Size(min = 1, max = 64)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 64)
    private String lastName;

    @NotNull
    private String age;
}