package com.vti.spring1.dto;

import java.util.ArrayList;
import java.util.List;

import com.vti.spring1.entity.Role;
import com.vti.spring1.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<RoleDto> roles ;

    public UserDto(User entity){
        this.id = entity.getId();
        this.username= entity.getUsername();
        this.password=entity.getPassword();
        this.email= entity.getEmail();
        this.enabled=entity.isEnabled();
        if(entity.getRoles()!=null && entity.getRoles().size()>0){
            List<RoleDto> roleDtos= new ArrayList<>();
            for(Role role: entity.getRoles()){
                RoleDto roleDto= new RoleDto();
                roleDto.setName(role.getName());
                roleDto.setId(role.getId());
                roleDtos.add(roleDto);
            }
            this.roles=roleDtos;
        }
    }
}
