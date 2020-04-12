package com.borjankorunoski.project.hrproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEES_TABLE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "EMPLOYEE_ID") private long id;
    @Column(name = "EMPLOYEE_NAME") private String name;
    @Column(name = "EMPLOYEE_SURNAME") private String surname;
    @Column(name = "EMPLOYEE_ADDRESS") private String address;
    @Column(name = "EMPLOYEE_DATE_OF_BIRTH") private String dateOfBirth;
    @Column(name = "EMPLOYEE_SALARY") private float salary;
    @Column(name = "EMPLOYEE_BAN") private String bankAccountNumber;
    @Column(name = "EMPLOYEE_EMAIL") private String email;
    @OneToOne @JoinColumn(name = "FK_EMPLOYEE_POSITION") private Job position;
    @Column(name = "EMPLOYEE_SSN") private String ssn;
    @Column(name = "EMPLOYEE_PASSWORD") private String password;
    @Column(name = "EMPLOYEE_CONTRACT_DATE") private String dateOfContract;
    @Column(name = "EMPLOYEE_JOB_ID") private long jobId;

    public Employee( String name,  String surname,  String address, String dateOfBirth,  float salary,  String bankAccountNumber,  String email,   String ssn, String password, String dateOfContract, long jobId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.email = email;
        this.ssn = ssn;
        this.password=password;
        this.dateOfContract = dateOfContract;
        this.jobId = jobId;
    }
}
