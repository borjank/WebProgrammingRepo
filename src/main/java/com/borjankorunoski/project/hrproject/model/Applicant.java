package com.borjankorunoski.project.hrproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "APPLICANT")
@Table(name = "APPLICANTS_TABLE")
public class Applicant {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "APPLICANT_ID") private long id;
    @Column(name = "APPLICANT_NAME") private String name;
    @Column(name = "APPLICANT_SURNAME") private String surname;
    @Column(name = "APPLICANT_EMAIL") private String email;
    @Column(name = "APPLICANT_PASSWORD") private String password;
    @JsonManagedReference @OneToMany(mappedBy = "applicant") private List<Application> applications;

    public Applicant(String name,  String surname,  String email,String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password=password;
    }
}