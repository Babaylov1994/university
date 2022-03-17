package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;

import java.util.List;

public interface GroupDao extends CrudDao<Group, Integer> {

    List<Student> getListStudentFromGroup(int idGroup);

    boolean addStudentInGroup(int idGroup, int idStudent);
}
