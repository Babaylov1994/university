package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {

        Group group = new Group();
        group.setIdGroup(rs.getInt("id_group"));
        group.setIdDepartment(rs.getInt("id_department"));
        group.setName(rs.getString("group_name"));
        return group;
    }
}
