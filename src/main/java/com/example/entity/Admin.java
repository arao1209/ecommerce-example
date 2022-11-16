package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    public Admin() {
    }

    public Admin(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
