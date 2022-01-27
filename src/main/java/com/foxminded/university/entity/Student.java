package com.foxminded.university.entity;

import java.util.Objects;

public class Student extends Person {

    private int idStudent;
    private int idGroup;

    public Student(String name, String lastName, Integer idStudent, Integer idGroup) {
        super(name, lastName);
        this.idStudent = idStudent;
        this.idGroup = idGroup;
    }

    public Student() {
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(idStudent, student.idStudent) && Objects.equals(idGroup, student.idGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idGroup);
    }

    @Override
    public String toString() {
        return "Student{" +
            "idStudent=" + idStudent +
            ", idGroup=" + idGroup +
            '}';
    }
}
