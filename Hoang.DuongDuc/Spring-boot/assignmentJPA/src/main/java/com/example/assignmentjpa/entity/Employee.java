package com.example.assignmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Employee")

public class Employee {

    @Id
    @Column(name = "EmployeeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName")
    private String fname;

    @Column(name = "LastName")
    private String lname;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

}
