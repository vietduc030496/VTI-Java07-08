package com.vti.spring1.dto;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseDto<U> {
    
    private long id;
    protected U createdBy;
    protected Date createdDate;
    protected U lastModifiedBy;
    protected Date lastModifiedDate;
}
