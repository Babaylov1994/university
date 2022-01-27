package com.foxminded.university.entity;

import java.util.List;
import java.util.Objects;

public class Department {

    private int idDepartment;
    private String name;
    private List<Group> groups;

    public Department(Integer idDepartment, String name, List<Group> groups) {
        this.idDepartment = idDepartment;
        this.name = name;
        this.groups = groups;
    }

    public Department() {
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(idDepartment, that.idDepartment) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, name);
    }

    @Override
    public String toString() {
        return "Department{" +
            "idDepartment=" + idDepartment +
            ", name='" + name + '\'' +
            ", groups=" + groups +
            '}';
    }
}
