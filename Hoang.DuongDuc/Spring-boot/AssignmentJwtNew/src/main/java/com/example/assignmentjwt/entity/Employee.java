package com.example.assignmentjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employee_table")
@Data
@ToString(exclude = {"password"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String info;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private RoleEntity roleEntity;
}