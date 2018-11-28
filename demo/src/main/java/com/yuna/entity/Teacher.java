package com.yuna.entity;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher() {
        super();
    }

}
