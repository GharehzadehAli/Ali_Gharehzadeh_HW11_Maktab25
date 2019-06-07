package com.example.model.dao;

import com.example.core.dao.BaseDAO;
import com.example.model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO extends BaseDAO<Employee> {
    ArrayList getEmployeeMaxSalaryByCity();
    ArrayList getMaxSalaryByCity();
    Employee getEmployeeByPostalCode(String postalCode);
    Employee getEmployeeByTelNumber(String telNumber);
}
