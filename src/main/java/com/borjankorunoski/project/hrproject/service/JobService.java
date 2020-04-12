package com.borjankorunoski.project.hrproject.service;

import com.borjankorunoski.project.hrproject.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    void addJob(Job job);
    Job getJobByCode(String jobCode);
    Job getJobByName(String jobName);
    Job getJob(long jobId);
    void updateJob(long jobId, Job job);
    void deleteJob(long jobId);

}
