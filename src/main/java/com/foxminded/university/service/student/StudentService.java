package com.foxminded.university.service.student;

import com.foxminded.university.entity.Person;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.CrudService;

public interface StudentService extends CrudService<Student, Integer> {

    void update(int id, Student student);
}
