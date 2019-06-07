package com.example.model;

import com.example.model.dao.EmployeeDAO;
import com.example.model.dao.EmployeeDaoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        EmployeeDAO employeeDAO = new EmployeeDaoImpl(factory);
        Employee employee = new Employee("N", "11", 432);
        Employee employee1 = new Employee("N1", "22", 433);
        Employee employee2 = new Employee("N2", "33", 450);
        Employee employee3 = new Employee("N3", "44", 420);
        Employee employee4 = new Employee("N4", "55", 462);

        Address address = new Address("c2", "PA", "PC", employee);
        Address address1 = new Address("c", "PA1", "PC1", employee);
        Address address2 = new Address("c1", "PA2", "PC2", employee1);
        Address address3 = new Address("c", "PA3", "PC3", employee1);
        Address address4 = new Address("c", "PA4", "PC4", employee2);
        Address address5 = new Address("c2", "PA5", "PC5", employee2);
        Address address6 = new Address("c", "PA6", "PC6", employee3);
        Address address7 = new Address("c1", "PA7", "PC7", employee3);
        Address address8 = new Address("c2", "PA8", "PC8", employee4);
        Address address9 = new Address("c1", "PA9", "PC9", employee4);

        PhoneNumber phoneNumber = new PhoneNumber("t", "m", address);
        PhoneNumber phoneNumber1 = new PhoneNumber("t1", "m1", address);
        PhoneNumber phoneNumber2 = new PhoneNumber("t2", "m2", address1);
        PhoneNumber phoneNumber3 = new PhoneNumber("t3", "m3", address1);
        PhoneNumber phoneNumber4 = new PhoneNumber("t4", "m4", address2);
        PhoneNumber phoneNumber5 = new PhoneNumber("t5", "m5", address2);
        PhoneNumber phoneNumber6 = new PhoneNumber("t6", "m6", address3);
        PhoneNumber phoneNumber7 = new PhoneNumber("t7", "m7", address3);
        PhoneNumber phoneNumber8 = new PhoneNumber("t8", "m8", address4);
        PhoneNumber phoneNumber9 = new PhoneNumber("t9", "m9", address4);
        PhoneNumber phoneNumber10 = new PhoneNumber("t10", "m10", address5);
        PhoneNumber phoneNumber11 = new PhoneNumber("t11", "m11", address6);
        PhoneNumber phoneNumber12 = new PhoneNumber("t12", "m12", address7);
        PhoneNumber phoneNumber13 = new PhoneNumber("t13", "m13", address8);
        PhoneNumber phoneNumber14 = new PhoneNumber("t14", "m14", address9);

        address.addPhoneNumber(phoneNumber);
        address.addPhoneNumber(phoneNumber1);

        address1.addPhoneNumber(phoneNumber2);
        address1.addPhoneNumber(phoneNumber3);

        address2.addPhoneNumber(phoneNumber4);
        address2.addPhoneNumber(phoneNumber5);

        address3.addPhoneNumber(phoneNumber6);
        address3.addPhoneNumber(phoneNumber7);

        address4.addPhoneNumber(phoneNumber8);
        address4.addPhoneNumber(phoneNumber9);

        address5.addPhoneNumber(phoneNumber10);

        address6.addPhoneNumber(phoneNumber11);

        address7.addPhoneNumber(phoneNumber12);

        address8.addPhoneNumber(phoneNumber13);

        address9.addPhoneNumber(phoneNumber14);

        employee.addAddress(address);
        employee.addAddress(address1);
        employeeDAO.create(employee);

        employee1.addAddress(address2);
        employee1.addAddress(address3);
        employeeDAO.create(employee1);


        employee2.addAddress(address4);
        employee2.addAddress(address5);
        employeeDAO.create(employee2);

        employee3.addAddress(address6);
        employee3.addAddress(address7);
        employeeDAO.create(employee3);

        employee4.addAddress(address8);
        employee4.addAddress(address9);
        employeeDAO.create(employee4);

//        System.out.println(employeeDAO.getEmployeeMaxSalaryByCity());
        System.out.println(employeeDAO.getMaxSalaryByCity());
//        System.out.println(employeeDAO.getEmployeeByPostalCode("PC3"));
//        System.out.println(employeeDAO.getEmployeeByTelNumber("t14"));

    }
}
