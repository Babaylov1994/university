package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;

public interface StudentDao extends CrudDao<Student, Integer> {

    void update(int id, Student student);
}
