package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class LectureDaoImpl implements LectureDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<Lecture>> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.createQuery("FROM Lecture", Lecture.class).
            getResultList());
    }

    @Override
    public Optional<Lecture> getById(Integer idLecture) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(Lecture.class, idLecture));
    }

    @Override
    public void create(Lecture lecture) {
        Session session = entityManager.unwrap(Session.class);
        session.save(lecture);
    }

    @Override
    public void delete(Integer idLecture) {
        Session session = entityManager.unwrap(Session.class);
        Lecture lecture = session.get(Lecture.class, idLecture);
        session.delete(lecture);
    }
}
