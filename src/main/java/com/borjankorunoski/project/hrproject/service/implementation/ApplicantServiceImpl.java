package com.borjankorunoski.project.hrproject.service.implementation;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.repository.ApplicantRepository;
import com.borjankorunoski.project.hrproject.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;

    public List<Applicant> getAllApplicants(){
        List<Applicant> applicantList = new ArrayList<>();
        applicantRepository.findAll()
                .forEach(applicantList::add);
        return applicantList;
    }

    public void addApplicant(Applicant applicant){
        applicantRepository.save(applicant);
    }

    public Applicant getApplicant(long applicantId){
        Applicant tmp = applicantRepository.findById(applicantId).orElse(new Applicant());
        return tmp;
    }

    @Override
    public Applicant getApplicantByNameAndSurname(String name, String surname) {
        Applicant tmp = applicantRepository.findApplicantByNameAndSurname(name, surname);
        return tmp;
    }

    @Override
    public Applicant getApplicantByEmail(String applicantEmail) {
        Applicant tmp = applicantRepository.findApplicantByEmail(applicantEmail);
        return tmp;
    }

    @Override
    public void updateApplicant(long applicantId, Applicant applicant) {
        Applicant app = new Applicant();
        app = applicant;
        app.setId(applicantId);
        this.addApplicant(app);
    }

    public void deleteApplicant(long applicantId){
        applicantRepository.deleteById(applicantId);
    }

}
