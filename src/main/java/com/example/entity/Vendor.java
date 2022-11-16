package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    public Vendor() {
    }

    public Vendor(int id, String name) {
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
