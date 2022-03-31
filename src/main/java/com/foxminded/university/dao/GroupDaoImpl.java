package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<Group>> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.createQuery("FROM Group", Group.class).
            getResultList());
    }

    @Override
    public Optional<Group> getById(Integer idGroup) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(Group.class, idGroup));
    }

    @Override
    public void create(Group group) {
        Session session = entityManager.unwrap(Session.class);
        session.save(group);
    }

    @Override
    public void delete(Integer idGroup) {
        Session session = entityManager.unwrap(Session.class);
        Group group = session.get(Group.class, idGroup);
        session.delete(group);
    }

    @Override
    public Optional<List<Student>> getListStudentFromGroup(int idGroup) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("FROM Student student where student.group.id = :idGroup");
        query.setParameter("idGroup", idGroup);
        List<Student> listStudentsOfGroup = query.list();
        return Optional.ofNullable(listStudentsOfGroup);
    }
}
