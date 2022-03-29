package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
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
            ", name='" + name + '\'' +
            ", lastName='" + lastName +
            '}';
    }
}
