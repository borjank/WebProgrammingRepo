package com.borjankorunoski.project.hrproject.model;

import com.borjankorunoski.project.hrproject.service.ApplicantService;
import com.borjankorunoski.project.hrproject.service.implementation.ApplicantServiceImpl;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APPLICATIONS_TABLE")
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "APPLICATION_ID") private long id;
    @JsonBackReference @ManyToOne @JoinColumn(name = "FK_APPLICANT") private Applicant applicant;
    @Column(name = "APPLICATION_DATE_OF_ISSUING") private String issuingDate;
    @OneToOne @JoinColumn(name = "FK_APPLICATION_JOB") private Job job;
    @Column(name = "APPLICATION_RATING") private int rating;
    @Column(name = "APPLICATION_REVIEWED") private boolean reviewed;
    @Column(name = "APPLICATION_JOB_ID") private long jobId;
    public Application(String issuingDate, long jobId) {
        ApplicantService as = new ApplicantServiceImpl();
        this.issuingDate = issuingDate;
        this.reviewed=false;
        this.rating = 0;
        this.jobId=jobId;
    }
    public String toString(){
        return "Application ID["+this.getId()+"] issued on "+this.getIssuingDate()+" by "+this.getApplicant().getName()+" for the position "+this.getJob().getName();
    }
}
