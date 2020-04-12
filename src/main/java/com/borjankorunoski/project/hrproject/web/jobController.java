package com.borjankorunoski.project.hrproject.web;

import com.borjankorunoski.project.hrproject.model.Employee;
import com.borjankorunoski.project.hrproject.model.Job;
import com.borjankorunoski.project.hrproject.service.EmployeeService;
import com.borjankorunoski.project.hrproject.service.JobService;
import com.borjankorunoski.project.hrproject.service.implementation.EmployeeServiceImpl;
import com.borjankorunoski.project.hrproject.service.implementation.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController

@CrossOrigin(value = "http://localhost:3000")
public class jobController {
    @Autowired
    JobService jobService;
    public jobController(){
        jobService= new JobServiceImpl();
    }
    @ModelAttribute(name="job")
    public Job job(){
        return new Job();
    }

    @ModelAttribute("editedJob")
    public Job editedJob(){
        return new Job();
    }

    @GetMapping(value = "/jobs", produces = "application/json")
    public List<Job> getJobs(Model model){
        List<Job> jobList = jobService.getAllJobs();
        return jobList;
    }
    @GetMapping(value = "/job/{id}", produces = "application/json")
    public Job getJob(Model model,@PathVariable("id") long id){
        Job tmp = jobService.getJob(id);
        return tmp;
    }
    @PostMapping(value = "/addJob", consumes = "application/json")
    public void addJob(@RequestBody Job job){
        jobService.addJob(job);
    }
    @PutMapping(value = "/editJob/{id}",consumes = "application/json",produces = "application/json")
    public void editJob(@RequestBody Job job, @PathVariable("id")long id){
        jobService.updateJob(id, job);
    }

    @DeleteMapping("/deleteJob/{id}")
    public void deleteJob(@PathVariable("id") long id){
        jobService.deleteJob(id);
    }
}
