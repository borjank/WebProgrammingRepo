package com.borjankorunoski.project.hrproject.repository;

import com.borjankorunoski.project.hrproject.model.Interview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends CrudRepository<Interview, Long> {
}
