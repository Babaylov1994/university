package com.foxminded.university.service;

import com.foxminded.university.dao.ScheduleDao;
import com.foxminded.university.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public List<Schedule> getAll() {
        return scheduleDao.getAll();
    }

    @Override
    public Optional<Schedule> getById(Integer idSchedule) {
        return scheduleDao.getById(idSchedule);
    }

    @Override
    public boolean create(Schedule schedule) {
        return scheduleDao.create(schedule);
    }

    @Override
    public boolean delete(Integer idSchedule) {
        return scheduleDao.delete(idSchedule);
    }
}
