package com.borjankorunoski.project.hrproject.service.implementation;

import com.borjankorunoski.project.hrproject.model.Interview;
import com.borjankorunoski.project.hrproject.repository.InterviewRepository;
import com.borjankorunoski.project.hrproject.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public List<Interview> getAllInterviews() {
        List<Interview> interviewList = new ArrayList<>();
        interviewRepository.findAll().forEach(interviewList::add);
        return interviewList;
    }

    @Override
    public void addInterview(Interview interview) {
        interviewRepository.save(interview);
    }

    @Override
    public Interview getInterview(long interviewId) {
        return interviewRepository.findById(interviewId).orElse(new Interview());
    }

    @Override
    public void updateInterview(long interviewId, Interview interview) {
        Interview in = new Interview();
        in = interview;
        in.setId(interviewId);
        this.addInterview(in);
    }

    @Override
    public void deleteInterview(long interviewId) {
        interviewRepository.deleteById(interviewId);
    }
}