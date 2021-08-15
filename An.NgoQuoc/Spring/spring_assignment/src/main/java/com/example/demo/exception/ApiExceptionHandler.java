package com.example.demo.exception;


import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.ErrorMessage;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage NotFoundObject(NoSuchElementException ex, WebRequest request) {
		return new ErrorMessage(10001,"Không tìm thấy đối tượng");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage notValidException(MethodArgumentNotValidException ex, WebRequest request) {
		return new ErrorMessage(10001,ex.getFieldError().getField() + " không hợp lệ");
	}
	
	
//	@ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorMessage allException(Exception ex,WebRequest request) {
//		return new ErrorMessage(10000,ex.getLocalizedMessage());
//	}
//	
	
}
