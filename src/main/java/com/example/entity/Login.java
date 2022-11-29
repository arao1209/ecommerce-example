package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "user_credentials")
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

}
