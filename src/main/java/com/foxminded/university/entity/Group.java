package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private int idGroup;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_department")
    private Department department;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_lecture")
    private Lecture lecture;

    @Column(name = "group_name")
    private String name;

    public Group() {
    }

    public Group(int idGroup, Department department, Lecture lecture, String name) {
        this.idGroup = idGroup;
        this.department = department;
        this.lecture = lecture;
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return idGroup == group.idGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup);
    }
}
