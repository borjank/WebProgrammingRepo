package com.borjankorunoski.project.hrproject.service.implementation;

import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.repository.EmployeeRepository;
import com.borjankorunoski.project.hrproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long employeeId) {
        Employee tmp = employeeRepository.findById(employeeId).orElse(new Employee());
        return tmp;
    }

    @Override
    public Employee getEmployeeByNameAndSurname(String name, String surname) {
        Employee tmp = employeeRepository.findEmployeeByNameAndSurname(name,surname);
        return tmp;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Employee tmp = employeeRepository.findEmployeeByEmail(email);
        return tmp;
    }

    @Override
    public Employee getEmployeeBySSN(String ssn) {
        Employee tmp = employeeRepository.findEmployeeBySsn(ssn);
        return tmp;
    }

    @Override
    public void updateEmployee(long employeeId, Employee employee) {
        Employee emp = new Employee();
        emp=employee;
        emp.setId(employeeId);
        this.addEmployee(emp);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
