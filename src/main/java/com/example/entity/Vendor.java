package com.example.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "vendors")
@RequiredArgsConstructor
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

}
