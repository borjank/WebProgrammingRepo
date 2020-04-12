package com.borjankorunoski.project.hrproject.service.implementation;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Application;
import com.borjankorunoski.project.hrproject.repository.ApplicationRepository;
import com.borjankorunoski.project.hrproject.service.ApplicantService;
import com.borjankorunoski.project.hrproject.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public List<Application> getApplicationsByApplicantId(Applicant applicant) {
        List<Application> list = new ArrayList<>();
        applicationRepository.findByApplicantId(applicant.getId()).forEach(list::add);
        return list;
    }

    @Override
    public List<Application> getApplicationsByReviewed(boolean reviewed) {
        List<Application> applications = new ArrayList<>();
        applications.addAll(applicationRepository.findAllByReviewed(reviewed));
        return applications;
    }

    @Override
    public void reviewApplication(long applicationId, int rating) {
        Application tmp = applicationRepository.findById(applicationId).orElse(new Application());
        tmp.setRating(rating);
        tmp.setReviewed(true);
        this.updateApplication(applicationId,tmp);
    }

    public List<Application> getAllApplications() {
        List<Application> list = new ArrayList<>();
        applicationRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void addApplication(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public Application getApplication(long applicationId) {
        return applicationRepository.findById(applicationId).orElse(new Application());
    }

    @Override
    public void updateApplication(long applicationId, Application application) {
        Application appl = new Application();
        appl=application;
        appl.setId(applicationId);
        this.addApplication(appl);
    }


    @Override
    public void deleteApplication(long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
