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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_department")
    private Department department;

    @Column(name = "group_name")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "group")
    private List<Student> students;

    public Group() {
    }

    public Group(Department department, String name, List<Student> students) {
        this.department = department;
        this.name = name;
        this.students = students;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    @Override
    public String toString() {
        return "Group{" +
            "idGroup=" + idGroup +
            ", department=" + department +
            ", name='" + name + '\'' +
            '}';
    }
}
