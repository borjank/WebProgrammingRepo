package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Application;
import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.service.ApplicantService;
import com.borjankorunoski.project.hrproject.service.ApplicationService;
import com.borjankorunoski.project.hrproject.service.EmployeeService;
import com.borjankorunoski.project.hrproject.service.JobService;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicantServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicationServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.EmployeeServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(value = "http://localhost:3000")
public class applicationController {
    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicantService applicantService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    JobService jobService;
    public applicationController(){
        applicationService = new ApplicationServiceImpl();
        applicantService = new ApplicantServiceImpl();
        employeeService = new EmployeeServiceImpl();
        jobService = new JobServiceImpl();
    }
    @GetMapping(value = "/applications", produces = "application/json")
    public List<Application> getApplications(){
        List<Application> applicationList = applicationService.getAllApplications();
        return applicationList;
    }//TODO: Add cookies for applicantId and jobId
    @GetMapping(value = "/application/{id}", produces = "application/json")
    public Application getApplications(@PathVariable("id")long id){
        return applicationService.getApplication(id);
    }
    @GetMapping(value = "/applications/unopened", produces = "application/json")
    public List<Application> getUnopenedApplications(){
        List<Application> applicationList = applicationService.getApplicationsByReviewed(false);
        return applicationList;
    }
    @GetMapping(value = "/applications/opened", produces = "application/json")
    public List<Application> getOpenedApplications(){
        List<Application> applicationList = applicationService.getApplicationsByReviewed(true);
        return applicationList;
    }
    @PostMapping(value = "/addApplication", consumes = "application/json")
    public void addApplication(@RequestBody Application application, @CookieValue(value = "applicantId") String applicantId){
        Applicant applicant = applicantService.getApplicant(Long.parseLong(applicantId));
        application.setApplicant(applicant);
        application.setJob(jobService.getJob(application.getJobId()));
        applicationService.addApplication(application);
    }
    @PutMapping(value = "/reviewApplication/{id}/{rating}", consumes = "application/json")
    public void rateApplication(@PathVariable long id, @PathVariable int rating,@CookieValue(value = "employeeId") String employeeId){
        Employee employee = employeeService.getEmployee(Long.parseLong(employeeId));
        if(employee.getPosition().getRank()>=4){
            applicationService.reviewApplication(id,rating);
        }
    }
    @DeleteMapping(value = "/deleteApplication/{id}")
    public void deleteApplication(@PathVariable long id){
        applicationService.deleteApplication(id);
    }
}