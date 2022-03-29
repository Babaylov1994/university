package com.foxminded.university.service.schedule;

import com.foxminded.university.dao.ScheduleDao;
import com.foxminded.university.entity.Schedule;
import com.foxminded.university.exception.DaoException;
import com.foxminded.university.exception.SqlException;
import com.foxminded.university.service.department.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    @Transactional
    public Optional<List<Schedule>> getAll() {
        logger.trace("Entered method getAll");
        return scheduleDao.getAll();
    }

    @Override
    @Transactional
    public Optional<Schedule> getById(Integer idSchedule) {
        logger.trace("Entered method getById");
        try {
            logger.debug("Found schedule with id = " + idSchedule);
            return scheduleDao.getById(idSchedule);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("schedule with this id does not exist");
            throw new DaoException("Schedule with this id does not exist", exception);
        }
    }

    @Override
    @Transactional
    public void create(Schedule schedule) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create schedule: " + schedule);
            scheduleDao.create(schedule);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all schedule fields");
            throw new SqlException("Fill out all schedule fields", exception);
        }
    }

    @Override
    @Transactional
    public void delete(Integer idSchedule) {
        logger.trace("Entered method delete");
        scheduleDao.delete(idSchedule);
    }
}
