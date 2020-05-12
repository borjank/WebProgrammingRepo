package com.borjankorunoski.project.hrproject.web;



import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.model.Interview;
import com.borjankorunoski.project.hrproject.service.*;
import com.borjankorunoski.project.hrproject.service.implementation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class mainController {
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
    public mainController(){
        applicantService = new ApplicantServiceImpl();
        employeeService = new EmployeeServiceImpl();
        applicationService = new ApplicationServiceImpl();
        interviewService = new InterviewServiceImpl();
        jobService = new JobServiceImpl();
    }
    @PostMapping("/login")
    public String showLogin(@RequestBody String json) throws JsonProcessingException {
        HashMap map = new ObjectMapper().readValue(json, HashMap.class);
        String email;
            email = (String) map.get("email");
            Employee emp = employeeService.getEmployeeByEmail(email);
            if(emp == null || emp.equals(new Employee())){
                Applicant applicant = applicantService.getApplicantByEmail(email);
                if(applicant == null || applicant.equals(new Applicant())){
                    return "Email doesn't exist";
                }else{
                    if(applicant.getPassword().equals(map.get("password"))){
                        return "1,"+Long.toString(applicant.getId())+"a";
                    }else{
                        return "Wrong password";
                    }
                }
            }else{
                if(emp.getPassword().equals(map.get("password"))){
                    return "1,"+Long.toString(emp.getId())+"e";
                }else{
                    return "Wrong password";
                }
            }

        }
}