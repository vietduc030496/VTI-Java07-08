package com.vti.spring1.dto;

import java.util.ArrayList;
import java.util.List;

import com.vti.spring1.entity.Role;
import com.vti.spring1.entity.User;

import lombok.Data;

@Data
public class RoleDto {
    private long id;
    private String name;
    private List<UserDto> users ;

    public RoleDto(Role entity){
        this.id=entity.getId();
        this.name= entity.getName();
        if(entity.getUsers()!=null && entity.getUsers().size()>0){
            List<UserDto> userDtos= new ArrayList<>();
            for(User user: entity.getUsers()){
                UserDto userDto= new UserDto(user);
                userDtos.add(userDto);
            }
            this.users=userDtos;
        }
    }

    public RoleDto(){}
}
