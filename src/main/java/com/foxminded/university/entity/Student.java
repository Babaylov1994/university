package com.foxminded.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int idStudent;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_group")
    private Group group;

    public Student(String name, String lastName, int idStudent, Group group) {
        super(name, lastName);
        this.idStudent = idStudent;
        this.group = group;
    }

    public Student() {
    }

    public Student(String name, String lastName, int idStudent) {
        super(name, lastName);
        this.idStudent = idStudent;
    }

    public Student(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idStudent == student.idStudent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent);
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", idStudent=" + idStudent +
            ", group=" + group +
            '}';
    }
}
