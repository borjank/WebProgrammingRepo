package com.borjankorunoski.project.hrproject.repository;

import com.borjankorunoski.project.hrproject.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findEmployeeByNameAndSurname(String employeeName, String employeeSurname);
    Employee findEmployeeByEmail(String employeeEmail);
    Employee findEmployeeBySsn(String employeeSSN);
}
