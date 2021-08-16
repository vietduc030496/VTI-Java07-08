package com.example.assignmentjwt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee_table")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private RoleEntity roleEntity;
}