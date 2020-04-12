package com.borjankorunoski.project.hrproject.service;

import com.borjankorunoski.project.hrproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployee(long employeeId);
    Employee getEmployeeByNameAndSurname(String name, String surname);
    Employee getEmployeeByEmail(String email);
    Employee getEmployeeBySSN(String ssn);
    void updateEmployee(long employeeId, Employee employee);
    void deleteEmployee(long employeeId);
}
