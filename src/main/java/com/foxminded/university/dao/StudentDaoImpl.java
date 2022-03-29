package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<List<Student>> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("FROM Student", Student.class).
            getResultList());
    }

    @Override
    public Optional<Student> getById(Integer idStudent) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Student.class, idStudent));
    }

    @Override
    public void create(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void delete(Integer idStudent) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, idStudent);
        session.delete(student);
    }

    @Override
    public void update(int idStudent, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student tempStudent = session.get(Student.class, idStudent);
        tempStudent.setName(student.getName());
        tempStudent.setLastName(student.getLastName());
        session.update(tempStudent);
    }
}
