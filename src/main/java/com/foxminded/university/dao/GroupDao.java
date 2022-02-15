package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;

import java.util.List;

public interface GroupDao {

    List<Group> getAllGroups();

    Group getGroupById(int id);

    boolean createNewGroup(Group group);

    boolean removeGroup(int id);

    List<Student> getListStudentFromGroup(int idGroup);

    boolean addStudentInGroup(int idGroup, int idStudent);

}
