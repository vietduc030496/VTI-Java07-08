package com.example.assignmentjwt.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class RegistrationRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String roleName;

}
