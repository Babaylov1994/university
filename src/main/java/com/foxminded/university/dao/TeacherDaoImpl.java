package com.foxminded.university.dao;

import com.foxminded.university.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher", Teacher.class).getResultList();
    }

    @Override
    public Optional<Teacher> getById(Integer idTeacher) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Teacher.class, idTeacher));
    }

    @Override
    public void create(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void delete(Integer idTeacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, idTeacher);
        session.delete(teacher);
    }
}
