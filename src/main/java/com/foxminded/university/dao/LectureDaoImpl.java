package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LectureDaoImpl implements LectureDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Lecture> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Lecture", Lecture.class).getResultList();
    }

    @Override
    public Optional<Lecture> getById(Integer idLecture) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Lecture.class, idLecture));
    }

    @Override
    public void create(Lecture lecture) {
        Session session = sessionFactory.getCurrentSession();
        session.save(lecture);
    }

    @Override
    public void delete(Integer idLecture) {
        Session session = sessionFactory.getCurrentSession();
        Lecture lecture = session.get(Lecture.class, idLecture);
        session.delete(lecture);
    }
}
