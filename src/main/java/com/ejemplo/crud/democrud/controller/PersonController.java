package com.ejemplo.crud.democrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.crud.democrud.model.Person;
import com.ejemplo.crud.democrud.model.Response;
import com.ejemplo.crud.democrud.model.pojo.PersonView;
import com.ejemplo.crud.democrud.service.PersonService;
import com.ejemplo.crud.democrud.service.util.ConstansCode;
import com.ejemplo.crud.democrud.service.util.ConstansMsg;

import io.swagger.annotations.Api;
/**
 * 
 * @author Victor.Sosa
 *
 */
@Api
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping(value = "/api/v1/person")
public class PersonController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PersonService personService;
	@Autowired
	private ConstansCode constCode;
	@Autowired
	private ConstansMsg constMsg;

	@GetMapping(value = "/getAllPerson")
	public ResponseEntity<Response> getAllPerson() {
		log.info("METHOD: {}", "GetAllPerson");
		Response<List<Person>> response = new Response<>();
		response.setCode(constCode.getSuccess());
		response.setDetailMessage(constMsg.getOk());
		response.setData(personService.findAllPerson());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/savePerson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Person>> savePerson(@RequestBody PersonView person) {
		log.info("METHOD: {}", "savePerson");
		Response<Person> response = new Response<>();
		response.setCode(constCode.getSuccess());
		response.setDetailMessage(constMsg.getSucces());
		response.setData(personService.savePerson(person));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/updatePerson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Person>> updatePerson(@RequestBody PersonView person) {
		Response<Person> response = new Response<>();
		response.setCode(constCode.getSuccess());
		response.setDetailMessage(constMsg.getUpdate());
		response.setData(personService.updatePerson(person));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/deletePerson/{id}")
	public ResponseEntity<Response> deletePerson(@PathVariable("id") Long id) {
		Response<Person> response = new Response<>();
		response.setCode(constCode.getSuccess());
		response.setDetailMessage(constMsg.getDelete());
		response.setData(personService.deletePerson(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
