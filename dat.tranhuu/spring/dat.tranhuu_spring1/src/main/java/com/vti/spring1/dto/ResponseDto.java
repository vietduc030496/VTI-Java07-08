package com.vti.spring1.dto;

import com.vti.spring1.types.YESNO;

import lombok.Data;

@Data
public class ResponseDto<T> {

	private String message;
	private T object;
	private YESNO status;
}
