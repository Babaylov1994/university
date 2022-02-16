package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.ScheduleRowMapper;
import com.foxminded.university.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ScheduleDaoImpl implements ScheduleDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_SCHEDULE = "SELECT * FROM schedule";
    private static final String SQL_GET_SCHEDULE_BY_ID = "SELECT * FROM schedule WHERE id_schedule = ?";
    private static final String SQL_CREATE_NEW_SCHEDULE = "INSERT INTO schedule(department_name) VALUES (?)";
    private static final String SQL_REMOVE_SCHEDULE = "DELETE FROM department WHERE id_department = ?";

    @Autowired
    public ScheduleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_SCHEDULE, new ScheduleRowMapper());
    }

    @Override
    public Optional<Schedule> getById(Integer idSchedule) {
        return Optional.ofNullable(jdbcTemplate.queryForObject
            (SQL_GET_SCHEDULE_BY_ID, new ScheduleRowMapper(), idSchedule));
    }

    @Override
    public boolean create(Schedule schedule) {
        return jdbcTemplate.update(SQL_CREATE_NEW_SCHEDULE, schedule.getDate()) > 0;
    }

    @Override
    public boolean delete(Integer idSchedule) {
        return jdbcTemplate.update(SQL_REMOVE_SCHEDULE, idSchedule) > 0;
    }
}
