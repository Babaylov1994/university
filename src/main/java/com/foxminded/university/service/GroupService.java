package com.foxminded.university.service;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;

import java.util.List;

public interface GroupService extends CrudService<Group, Integer> {

    List<Student> getListStudentFromGroup(int idGroup);

    boolean addStudentInGroup(int idGroup, int idStudent);
}
