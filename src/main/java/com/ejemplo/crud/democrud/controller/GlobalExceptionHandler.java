package com.ejemplo.crud.democrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ejemplo.crud.democrud.controller.exceptions.DataNotFoundException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonExistException;
import com.ejemplo.crud.democrud.model.Response;
import com.ejemplo.crud.democrud.service.util.ConstansCode;
import com.ejemplo.crud.democrud.service.util.ConstansMsg;

/**
 * 
 * @author Victor.Sosa
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ConstansCode constansCode;
	@Autowired
	private ConstansMsg constansMsg;

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Response> dataEmptyException(DataNotFoundException ex) {
		log.info("DETAIL EXCEPTION: -> {}", ex);
		Response<Object> response = new Response<>();
		response.setCode(constansCode.getDataNotFound());
		response.setDetailMessage(constansMsg.getEmpty());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PersonException.class)
	public ResponseEntity<Response> personException(PersonException ex) {
		log.info("DETAIL EXCEPTION: -> {}", ex);
		Response<Object> response = new Response<>();
		response.setCode(constansCode.getBadRequest());
		response.setDetailMessage(constansMsg.getError());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PersonExistException.class)
	public ResponseEntity<Response> personExistException(PersonExistException ex) {
		log.info("DETAIL EXCEPTION: -> {}", ex);
		Response<Object> response = new Response<>();
		response.setCode(constansCode.getBadRequest());
		response.setDetailMessage(constansMsg.getExist());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
