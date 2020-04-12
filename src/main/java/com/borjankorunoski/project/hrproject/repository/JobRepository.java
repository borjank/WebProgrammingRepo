package com.borjankorunoski.project.hrproject.repository;

import com.borjankorunoski.project.hrproject.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
    Job findJobByCode(String jobCode);
    Job findJobByName(String nameJob);
}
