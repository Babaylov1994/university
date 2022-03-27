package com.foxminded.university.entity;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "department")
    private List<Group> groups;

    public Department() {
    }

    public Department(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public void addGroupToDepartment(Group group) {
        if(groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
        group.setDepartment(this);
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
        return idDepartment == that.idDepartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment);
    }

    @Override
    public String toString() {
        return "Department{" +
            "idDepartment=" + idDepartment +
            ", name='" + name + '\'' +
            '}';
    }
}
