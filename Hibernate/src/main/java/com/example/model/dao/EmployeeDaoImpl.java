package com.example.model.dao;

import com.example.core.dao.BaseDaoImpl;
import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDAO {
    private final SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    protected String getEntityName() {
        return null;
    }

    @Override
    public ArrayList getEmployeeMaxSalaryByCity() {
        Session session = factory.openSession();
        List list;
        session.beginTransaction();
        list = session.createQuery(
                "select e from Employee e join Address a on e.id=a.employee.id where e.salary=(select max(e.salary) from e)  group by a.city").getResultList();

        session.getTransaction().commit();

        session.close();
        return (ArrayList) list;
    }
    @Override
    public ArrayList getMaxSalaryByCity() {
        Session session = factory.openSession();
        List list;
        session.beginTransaction();
        list = session.createQuery(
                "select e.salary from Employee e join Address a on e.id=a.employee.id where e.salary=(select max(e.salary) from e)  group by a.city").getResultList();

        session.getTransaction().commit();

        session.close();
        return (ArrayList) list;
    }

    @Override
    public Employee getEmployeeByPostalCode(String postalCode) {
        Session session = factory.openSession();
        Employee employee;
        session.beginTransaction();
        employee = session.createQuery(
                "select e from Employee e join Address a on e.id=a.employee.id where a.postalCode='" + postalCode + "'", Employee.class).getSingleResult();

        session.getTransaction().commit();

        session.close();
        return employee;
    }
    @Override
    public Employee getEmployeeByTelNumber(String telNumber) {
        Session session = factory.openSession();
        Employee employee;
        session.beginTransaction();
        employee = session.createQuery(
                "select e from Employee e join Address a on e.id=a.employee.id join PhoneNumber p on a.id=p.address.id where p.telNumber='" + telNumber + "'", Employee.class).getSingleResult();

        session.getTransaction().commit();

        session.close();
        return employee;
    }
}
