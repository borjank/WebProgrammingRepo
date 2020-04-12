package com.borjankorunoski.project.hrproject.repository;

import com.borjankorunoski.project.hrproject.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    Applicant findApplicantByNameAndSurname(String applicantName, String applicantSurname);
    Applicant findApplicantByEmail(String applicantEmail);
}
