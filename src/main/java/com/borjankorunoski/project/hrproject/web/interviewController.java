package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.model.Interview;
import com.borjankorunoski.project.hrproject.service.*;
import com.borjankorunoski.project.hrproject.service.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(value = "http://localhost:3000")
public class interviewController {
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
    public interviewController(){
        applicantService = new ApplicantServiceImpl();
        employeeService = new EmployeeServiceImpl();
        applicationService = new ApplicationServiceImpl();
        interviewService = new InterviewServiceImpl();
        jobService = new JobServiceImpl();
    }
    @ModelAttribute("interview")
    public Interview interview(){
        return new Interview();
    }
    @GetMapping(value = "/interviews", produces = "application/json")
    public List<Interview> getInterviews(){
        List<Interview> interviewList;
        interviewList = interviewService.getAllInterviews();
        return interviewList;
    }
    @GetMapping(value = "/interview/{id}", produces = "application/json")
    public Interview getInterview(@PathVariable long id){
        return interviewService.getInterview(id);
    }
    @PostMapping(value = "/addInterview", consumes = "application/json")
    public void addInterview(@RequestBody Interview interview, @CookieValue(value = "employeeId") String empId){
        Employee emp = employeeService.getEmployee(Long.parseLong(empId));
        if(emp.getPosition().getRank()>=4){
            interview.setApplication(applicationService.getApplication(interview.getApplicationId()));
            interview.setInterviewer(emp);
            interviewService.addInterview(interview);
        }
    }
    @PutMapping(value = "/editInterview/{id}", consumes = "application/json")
    public void editInterview(@RequestBody Interview newInterview, @PathVariable long id){
        interviewService.updateInterview(id, newInterview);
    }
    @DeleteMapping(value = "/deleteInterview/{id}", consumes = "application/json")
    public void deleteInterview(@PathVariable long id){
        interviewService.deleteInterview(id);
    }
}
