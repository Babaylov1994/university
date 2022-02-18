package com.foxminded.university.service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.exceptions.DaoException;
import com.foxminded.university.service.exceptions.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            return groupDao.getById(idGroup);
        } catch (EmptyResultDataAccessException exception) {
            throw new DaoException("Group with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Group group) {
        try {
            return groupDao.create(group);
        } catch (DataIntegrityViolationException exception){
            throw new SqlException("Name of group cannot be empty", exception);
        }
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
        try {
            return groupDao.addStudentInGroup(idGroup, idStudent);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("Group with this id does not exist", exception);
        }
    }
}
