package com.borjankorunoski.project.hrproject.service;

import com.borjankorunoski.project.hrproject.model.Interview;

import java.util.List;

public interface InterviewService {
    List<Interview> getAllInterviews();
    void addInterview(Interview interview);
    Interview getInterview(long interviewId);
    void updateInterview(long interviewId, Interview interview);
    void deleteInterview(long interviewId);

}
