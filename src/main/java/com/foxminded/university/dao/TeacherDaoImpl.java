package com.foxminded.university.dao;

import com.foxminded.university.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<Teacher>> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.createQuery("FROM Teacher", Teacher.class).
            getResultList());
    }

    @Override
    public Optional<Teacher> getById(Integer idTeacher) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(Teacher.class, idTeacher));
    }

    @Override
    public void create(Teacher teacher) {
        Session session = entityManager.unwrap(Session.class);
        session.save(teacher);
    }

    @Override
    public void delete(Integer idTeacher) {
        Session session = entityManager.unwrap(Session.class);
        Teacher teacher = session.get(Teacher.class, idTeacher);
        session.delete(teacher);
    }
}
