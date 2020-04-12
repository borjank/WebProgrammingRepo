package com.borjankorunoski.project.hrproject.service;

import com.borjankorunoski.project.hrproject.model.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplicantService {
    List<Applicant> getAllApplicants();
    void addApplicant(Applicant applicant);
    Applicant getApplicant(long applicantId);
    Applicant getApplicantByNameAndSurname(String name, String surname);
    Applicant getApplicantByEmail(String applicantEmail);
    void updateApplicant(long applicantId, Applicant applicant);
    void deleteApplicant(long applicantId);
}
