package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;

import java.util.List;
import java.util.Optional;

public interface GroupDao extends CrudDao<Group, Integer> {

    Optional<List<Student>> getListStudentFromGroup(int idGroup);
}
