package com.borjankorunoski.project.hrproject.service.implementation;

import com.borjankorunoski.project.hrproject.model.Job;
import com.borjankorunoski.project.hrproject.repository.JobRepository;
import com.borjankorunoski.project.hrproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);
        return jobs;
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobByCode(String jobCode) {
        return jobRepository.findJobByCode(jobCode);
    }

    @Override
    public Job getJobByName(String name) {
        return jobRepository.findJobByName(name);
    }

    @Override
    public Job getJob(long jobId) {
        return jobRepository.findById(jobId).orElse(new Job());
    }


    @Override
    public void updateJob(long id, Job job) {
        Job j = new Job();
        j = job;
        j.setId(id);
        this.addJob(j);
    }

    @Override
    public void deleteJob(long jobId) {
        jobRepository.deleteById(jobId);
    }
}
