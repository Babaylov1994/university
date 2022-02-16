package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Schedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleRowMapper implements RowMapper<Schedule> {
    @Override
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setIdSchedule(rs.getInt("id_schedule"));
        schedule.setDate(rs.getDate("date_schedule").toLocalDate());
        return schedule;
    }
}
