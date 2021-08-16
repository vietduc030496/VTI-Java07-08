package com.vti.spring1.entity;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken extends BaseEntity<String> {
    private String token;
}
