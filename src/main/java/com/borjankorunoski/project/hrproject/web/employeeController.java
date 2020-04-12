package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.service.*;
import com.borjankorunoski.project.hrproject.service.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@CrossOrigin(value = "http://localhost:3000")
public class employeeController {
    @Autowired
    ApplicantService applicantService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    InterviewService interviewService;
    @Autowired
    JobService jobService;
    public employeeController(){
        applicantService = new ApplicantServiceImpl();
        employeeService = new EmployeeServiceImpl();
        applicationService = new ApplicationServiceImpl();
        interviewService = new InterviewServiceImpl();
        jobService = new JobServiceImpl();
    }
    @ModelAttribute
    public Employee employee(){
        return new Employee();
    }
    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.getAllEmployees();
        return employeeList;
    }
    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public Employee getEmployees(@PathVariable long id){
        return employeeService.getEmployee(id);
    }
    @PostMapping(value = "/addEmployee", consumes = "application/json")
    public void addEmployee(@RequestBody Employee employee){
        employee.setPosition(jobService.getJob(employee.getJobId()));
        employeeService.addEmployee(employee);
    }
    @PutMapping(value = "/editEmployee/{id}", consumes = "application/json")
    public void editEmployee(@RequestBody Employee newEmployee, @PathVariable long id, @CookieValue(value = "employeeId") String empId){
        Employee em = employeeService.getEmployee(Long.parseLong(empId));
        if(em.getPosition().getRank()>=4){
            employeeService.updateEmployee(id,newEmployee);
        }
    }
    @DeleteMapping(value = "/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable long id, @CookieValue(value = "employeeId") String empId){
        Employee em = employeeService.getEmployee(Long.parseLong(empId));
        if(em.getPosition().getRank()>=4){
            employeeService.deleteEmployee(id);
        }
    }
}
