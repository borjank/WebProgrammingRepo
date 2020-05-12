package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Application;
import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.model.Job;
import com.borjankorunoski.project.hrproject.service.ApplicantService;
import com.borjankorunoski.project.hrproject.service.ApplicationService;
import com.borjankorunoski.project.hrproject.service.EmployeeService;
import com.borjankorunoski.project.hrproject.service.JobService;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicantServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicationServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.EmployeeServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.JobServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public List<Application> getApplications() {
        List<Application> applicationList = applicationService.getAllApplications();
        return applicationList;
    }
    @GetMapping(value = "/applications/{id}", produces = "application/json")
    public List<Application> getApplicationsByApplicantId(@PathVariable("id")long id) {
        List<Application> applicationList = applicationService.getApplicationsByApplicantId(id);
        return applicationList;
    }
    @GetMapping(value = "/application/{id}", produces = "application/json")
    public Application getApplication(@PathVariable("id")long id){
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
    public String addApplication(@RequestBody String json) throws JsonProcessingException {
        HashMap map = new ObjectMapper().readValue(json, HashMap.class);
        String id = (String) map.get("id");
        id = id.substring(1,id.length()-1);
        String job_id = (String)map.get("job_id");
        job_id = job_id.substring(1,job_id.length()-1);
        String date = (String)map.get("issuingDate");
        Applicant applicant = applicantService.getApplicant(Long.parseLong(id));
        Job job = jobService.getJob(Long.parseLong(job_id));
        Application application = new Application();
        application.setApplicant(applicant);
        application.setJob(job);
        application.setIssuingDate(date);
        applicationService.addApplication(application);
        return("APPLICATION REGISTERED.");
    }
    @GetMapping(value = "/reviewApplication/{id}/{rating}")
    public String rateApplication(@PathVariable long id, @PathVariable int rating){
        applicationService.reviewApplication(id,rating);
        return "Application with id: "+id+" was reviewed and received a rating of "+rating;
    }
    @DeleteMapping(value = "/deleteApplication/{id}")
    public void deleteApplication(@PathVariable long id){
        applicationService.deleteApplication(id);
    }
}