package com.eccomerce.handler;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eccomerce.exception.NotFound;

@RestControllerAdvice
public class ExceptionAndValidationHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("BYeeeeeeeeeeeeeeeeeeeeeee");
		BindingResult br = ex.getBindingResult();
		List<ObjectError> errors = br.getAllErrors();
		List<String> list = new ArrayList<>();
		ResponseError responseError = new ResponseError("Validation failed", list);
		for (ObjectError error : errors) {
			list.add(error.getDefaultMessage());
		}
		System.out.println("Handler called");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
	}
	
//	@ExceptionHandler(value = {MyDataIntegrityViolationException.class})
//    public ResponseEntity<Object> handleDataIntegrityViolationException(MyDataIntegrityViolationException ex) {
//		System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIII");
//        return new ResponseEntity<>("Validation Failed -" + ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//	
	@ExceptionHandler(NotFound.class)
	ResponseEntity<Response> studentNotFoundException(NotFound ex){
		Response response = new Response();
		
		System.out.println(ex);
		
		response.setMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(response);
	}
	
//	@ExceptionHandler(ConstraintViolationImpl)
//	public ResponseEntity<Object> handleDataIntegrityViolationExceptionEntity(MyDataIntegrityViolationException ex) {
//		System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIII");
//        return new ResponseEntity<>("Validation Failed -" + ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
	
	
}
