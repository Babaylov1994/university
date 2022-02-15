package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.GroupRowMapper;
import com.foxminded.university.dao.mappers.StudentRowMapper;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoImpl implements GroupDao{

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_GROUPS = "SELECT * FROM group_student";
    private static final String SQL_GET_GROUP_BY_ID = "SELECT * FROM group_student WHERE id_group = ?";
    private static final String SQL_CREATE_NEW_GROUP = "INSERT INTO group_student(group_name) VALUES (?)";
    private static final String SQL_REMOVE_GROUP = "DELETE FROM group_student WHERE id_group = ?";
    private static final String SQL_GET_STUDENTS_FROM_GROUP = "SELECT student.id_student, student.id_group, student.first_name, student.last_name, group_student.id_group\n" +
        "FROM student JOIN group_student ON student.id_group = group_student.id_group\n" +
        "WHERE group_student.id_group = ?";
    private static final String SQL_ADD_STUDENT_IN_GROUP = "UPDATE student SET id_group = ?\n" +
        "WHERE id_student = ?";

    @Autowired
    public GroupDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Group> getAllGroups() {
        return jdbcTemplate.query(SQL_GET_ALL_GROUPS, new GroupRowMapper());
    }

    @Override
    public Group getGroupById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_GROUP_BY_ID, new GroupRowMapper(), id);
    }

    @Override
    public boolean createNewGroup(Group group) {
        return jdbcTemplate.update(SQL_CREATE_NEW_GROUP, group.getName()) > 0;
    }

    @Override
    public boolean removeGroup(int id) {
        return jdbcTemplate.update(SQL_REMOVE_GROUP, id) > 0;
    }

    @Override
    public List<Student> getListStudentFromGroup(int idGroup) {
        return jdbcTemplate.query(SQL_GET_STUDENTS_FROM_GROUP, new StudentRowMapper(), idGroup);
    }

    @Override
    public boolean addStudentInGroup(int idGroup, int idStudent) {
        return jdbcTemplate.update(SQL_ADD_STUDENT_IN_GROUP, idGroup, idStudent) > 0;
    }
}
