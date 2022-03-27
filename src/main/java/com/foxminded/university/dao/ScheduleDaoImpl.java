package com.foxminded.university.dao;


import com.foxminded.university.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Schedule> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Schedule", Schedule.class).getResultList();
    }

    @Override
    public Optional<Schedule> getById(Integer idSchedule) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Schedule.class, idSchedule));
    }

    @Override
    public void create(Schedule schedule) {
        Session session = sessionFactory.getCurrentSession();
        session.save(schedule);
    }

    @Override
    public void delete(Integer idSchedule) {
        Session session = sessionFactory.getCurrentSession();
        Schedule schedule = session.get(Schedule.class, idSchedule);
        session.delete(schedule);
    }
}
