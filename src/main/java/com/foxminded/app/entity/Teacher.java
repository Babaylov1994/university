package com.foxminded.app.entity;

import java.util.Objects;

public class Teacher extends Person {

    private Integer idTeacher;

    public Teacher(String name, String lastName, Integer idTeacher) {
        super(name, lastName);
        this.idTeacher = idTeacher;
    }

    public Teacher() {
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(idTeacher, teacher.idTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher);
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "idTeacher=" + idTeacher +
            '}';
    }
}
