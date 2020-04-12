package com.borjankorunoski.project.hrproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INTERVIEWS_TABLE")
public class Interview {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "INTERVIEW_ID") private long id;
    @OneToOne @JoinColumn(name = "FK_INTERVIEW_APPLICATION") private Application application;
    @ManyToOne @JoinColumn(name = "INTERVIEW_INTERVIEWER") private Employee interviewer;
    @Column(name = "INTERVIEW_DATE_AND_TIME") private String dateAndTime;
    @Column(name = "INTERVIEW_LOCATION") private String location;
    @Column(name = "INTERVIEW_APPLICANT_ID") private long applicationId;
    public Interview(String dateAndTime, String location, long id) {
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.applicationId =id;
    }
}
