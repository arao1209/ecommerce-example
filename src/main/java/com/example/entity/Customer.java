package com.example.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "customers")
@RequiredArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "First Name can not be empty and must have >0")
    @Size(min = 1, max = 15, message = "First Name length must be between 1 to 15")
    private String fName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last Name can not be empty and must have >0")
    @Size(min = 1, max = 15, message = "Last Name length must be between 1 to 15")
    private String lName;

    @Column(name = "user_name", unique = true)
    @NotEmpty(message = "User Name can not be empty and must have >0")
    @Size(min = 1, max = 15, message = "User Name length must be between 1 to 15")
    private String uName;

    @Column(name = "password")
    @NotEmpty(message = "Password can not be empty and must have >0")
    @Size(min = 8, max = 16, message = "Password length must be between 8 to 16")
    private String password;

    @Column(name = "email_id")
    @NotEmpty(message = "Email ID can not be empty and must have >0")
    private String emailId;

    @Column(name = "phone_number")
    @Size(min = 10, max = 10, message = "phone number length should be 10")
    private String phoneNum;

    @Column(name = "address")
    @NotNull(message = "Address can not be empty and must have >0")
    private String address;

}
