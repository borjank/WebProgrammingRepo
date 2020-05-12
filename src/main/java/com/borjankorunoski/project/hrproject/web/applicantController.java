package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.service.ApplicantService;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicantServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")

public class applicantController {
    @Autowired
    ApplicantService applicantService;
    public applicantController(){
        applicantService = new ApplicantServiceImpl();
    }
    @ModelAttribute("applicant")
    public Applicant applicant(){
        return new Applicant();
    }
    @GetMapping(value = "/applicants", produces = "application/json")
    public List<Applicant> getApplicants(){
        List<Applicant> applicantList = new ArrayList<>();
        applicantList = applicantService.getAllApplicants();
        return applicantList;
    }
    @GetMapping(value = "/applicant/{id}",produces = "application/json")
    public Applicant getApplicant(@PathVariable("id") long applicantId){
        return applicantService.getApplicant(applicantId);
    }
    @PostMapping(value = "/addApplicant", consumes = "application/json", produces = "application/json")
    public String addApplicant(@RequestBody Applicant applicant) {
        applicantService.addApplicant(applicant);
        return(String.valueOf(applicantService.getApplicantByEmail(applicant.getEmail()).getId()));
    }
    @DeleteMapping("/deleteApplicant/{id}")
    public void deleteApplicant(@PathVariable("id") long id){
        applicantService.deleteApplicant(id);
    }
}