package com.foxminded.university.service.group;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.CrudService;

import java.util.List;

public interface GroupService extends CrudService<Group, Integer> {

    List<Student> getListStudentFromGroup(int idGroup);

}
