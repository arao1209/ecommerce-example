package com.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "admin")
@RequiredArgsConstructor
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

}
