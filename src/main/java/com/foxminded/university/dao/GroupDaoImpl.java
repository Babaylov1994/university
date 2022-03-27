package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Group> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Group", Group.class).getResultList();
    }

    @Override
    public Optional<Group> getById(Integer idGroup) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Group.class, idGroup));
    }

    @Override
    public void create(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void delete(Integer idGroup) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.get(Group.class, idGroup);
        session.delete(group);
    }

    @Override
    public List<Student> getListStudentFromGroup(int idGroup) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Student student where student.group.id = :idGroup");
        query.setParameter("idGroup", idGroup);
        List<Student> listStudentsOfGroup = query.list();
        return listStudentsOfGroup;
    }
}
