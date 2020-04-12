package com.borjankorunoski.project.hrproject.service;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications();
    void addApplication(Application application);
    Application getApplication(long applicationId);
    void updateApplication(long applicationId, Application application);
    void deleteApplication(long applicationId);
    List<Application> getApplicationsByApplicantId(Applicant applicant);
    List<Application> getApplicationsByReviewed(boolean reviewed);
    void reviewApplication(long applicationId, int applicationRating);
}

