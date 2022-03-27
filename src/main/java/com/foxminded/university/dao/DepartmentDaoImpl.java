package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Department",
            Department.class).getResultList();
    }

    @Override
    public Optional<Department> getById(Integer idDepartment) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Department.class, idDepartment));
    }

    @Override
    public void create(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.save(department);
    }

    @Override
    public void delete(Integer idDepartment) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, idDepartment);
        session.delete(department);
    }
}
