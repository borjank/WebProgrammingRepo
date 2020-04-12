package com.borjankorunoski.project.hrproject.repository;

import com.borjankorunoski.project.hrproject.model.Applicant;
import com.borjankorunoski.project.hrproject.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findByApplicantId(long applicantId);
    List<Application> findAllByReviewed(boolean applicationReviewed);
}
