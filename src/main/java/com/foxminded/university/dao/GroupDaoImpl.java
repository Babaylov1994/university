package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.GroupRowMapper;
import com.foxminded.university.dao.mappers.StudentRowMapper;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GroupDaoImpl implements GroupDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_GET_GROUP_BY_ID = "SELECT * FROM groups WHERE id_group = ?";
    private static final String SQL_CREATE_NEW_GROUP = "INSERT INTO groups(group_name) VALUES (?)";
    private static final String SQL_REMOVE_GROUP = "DELETE FROM groups WHERE id_group = ?";
    private static final String SQL_GET_STUDENTS_FROM_GROUP = "SELECT student.id_student, student.id_group, " +
        "student.first_name, student.last_name, groups.id_group\n" +
        "FROM student JOIN groups ON student.id_group = groups.id_group\n" +
        "WHERE groups.id_group = ?";
    private static final String SQL_ADD_STUDENT_IN_GROUP = "UPDATE student SET id_group = ? WHERE id_student = (\n" +
        " SELECT id_student FROM student WHERE id_student = ? \n" +
        ") AND 1/(select count(*) from student where id_student = ?) IS NOT NULL";

    @Autowired
    public GroupDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Group> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_GROUPS, new GroupRowMapper());
    }

    @Override
    public Optional<Group> getById(Integer idGroup) {
        return Optional.ofNullable(jdbcTemplate.queryForObject
            (SQL_GET_GROUP_BY_ID, new GroupRowMapper(), idGroup));
    }

    @Override
    public boolean create(Group group) {
        return jdbcTemplate.update(SQL_CREATE_NEW_GROUP, group.getName()) > 0;
    }

    @Override
    public boolean delete(Integer idGroup) {
        return jdbcTemplate.update(SQL_REMOVE_GROUP, idGroup) > 0;
    }

    @Override
    public List<Student> getListStudentFromGroup(int idGroup) {
        return jdbcTemplate.query(SQL_GET_STUDENTS_FROM_GROUP, new StudentRowMapper(), idGroup);
    }

    @Override
    public boolean addStudentInGroup(int idGroup, int idStudent) {
        return jdbcTemplate.update(SQL_ADD_STUDENT_IN_GROUP, idGroup, idStudent, idStudent) > 0;
    }
}
