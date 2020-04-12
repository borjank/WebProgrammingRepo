package com.borjankorunoski.project.hrproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JOBS_TABLE")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "JOB_ID") private long id;
    @Column(name = "JOB_NAME") private String name;
    @Column(name = "JOB_RANK") private int rank;
    @Column(name = "JOB_CODE") private String code;

    public Job( String name,  int rank,  String code) {
        this.name = name;
        this.rank = rank;
        this.code = code;
    }
}
