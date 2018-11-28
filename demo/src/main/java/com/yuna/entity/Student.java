package com.yuna.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100,name="name")
    private String name;

    //@Column(name="department_id")//学生宿舍外键
    //private Integer departmentId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="teacherId")
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
        super();
    }

}
