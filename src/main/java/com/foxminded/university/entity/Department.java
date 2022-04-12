package com.foxminded.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private int idDepartment;

    @Column(name = "department_name")
    private String name;

    public Department() {
    }

    public Department(int idDepartment, String name) {
        this.idDepartment = idDepartment;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return idDepartment == that.idDepartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment);
    }
}
