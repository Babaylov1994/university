package com.foxminded.university.entity;

import java.util.List;
import java.util.Objects;

public class Group {

    private int idGroup;
    private int idDepartment;
    private String name;
    private List<Student> students;

    public Group(int idGroup, int idDepartment, String name, List<Student> students) {
        this.idGroup = idGroup;
        this.idDepartment = idDepartment;
        this.name = name;
        this.students = students;
    }

    public Group() {
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
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
        return Objects.equals(idGroup, group.idGroup) && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, name);
    }

    @Override
    public String toString() {
        return "Group{" +
            "idGroup=" + idGroup +
            ", idDepartment=" + idDepartment +
            ", name='" + name + '\'' +
            ", students=" + students +
            '}';
    }
}
