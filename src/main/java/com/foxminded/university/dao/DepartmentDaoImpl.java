package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<List<Department>> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.createQuery("FROM Department",
            Department.class).getResultList());
    }

    @Override
    public Optional<Department> getById(Integer idDepartment) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(Department.class, idDepartment));
    }

    @Override
    public void create(Department department) {
        Session session = entityManager.unwrap(Session.class);
        session.save(department);
    }

    @Override
    public void delete(Integer idDepartment) {
        Session session = entityManager.unwrap(Session.class);
        Department department = session.get(Department.class, idDepartment);
        session.delete(department);
    }
}
