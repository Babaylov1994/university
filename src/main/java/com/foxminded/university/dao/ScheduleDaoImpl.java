package com.foxminded.university.dao;


import com.foxminded.university.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<Schedule>> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.createQuery("FROM Schedule", Schedule.class).
            getResultList());
    }

    @Override
    public Optional<Schedule> getById(Integer idSchedule) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(Schedule.class, idSchedule));
    }

    @Override
    public void create(Schedule schedule) {
        Session session = entityManager.unwrap(Session.class);
        session.save(schedule);
    }

    @Override
    public void delete(Integer idSchedule) {
        Session session = entityManager.unwrap(Session.class);
        Schedule schedule = session.get(Schedule.class, idSchedule);
        session.delete(schedule);
    }
}
