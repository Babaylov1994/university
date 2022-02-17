package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Override
    public Optional<Group> getById(Integer idGroup) {
        return groupDao.getById(idGroup);
    }

    @Override
    public boolean create(Group group) {
        return groupDao.create(group);
    }

    @Override
    public boolean delete(Integer idGroup) {
        return groupDao.delete(idGroup);
    }

    @Override
    public List<Student> getListStudentFromGroup(int idGroup) {
        return groupDao.getListStudentFromGroup(idGroup);
    }

    @Override
    public boolean addStudentInGroup(int idGroup, int idStudent) {
        return groupDao.addStudentInGroup(idGroup, idStudent);
    }
}
