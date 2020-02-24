package com.ejemplo.crud.democrud;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.crud.democrud.model.Person;
import com.ejemplo.crud.democrud.service.util.ConstantsRutes;
import com.ejemplo.crud.democrud.service.util.Util;

/**
 * 
 * @author Victor.Sosa
 * 
 *         pruebas de integracion
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoCrudApplicationTests {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	TestRestTemplate restTemplate;
	@Autowired
	ConstantsRutes constRutes;
	@Autowired
	Util util;
	

	/**
	 * "http://localhost:8080/api/v1/person/getAllPerson"
	 */
	@Test
	public void testGetAllPerson() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, header);
		ResponseEntity<String> response = restTemplate.exchange(util.getUrl(constRutes.getAll()), HttpMethod.GET,
				entity, String.class);
		log.info("STATUS-CODE AND RUTE: -> {} {}", response.getStatusCode(), util.getUrl(constRutes.getAll()));
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}

	/**
	 * "http://localhost:8080/api/v1/person/deletePerson/17" Genera una excepcion
	 * porque no se encuentra a la persona con ese id
	 */
	@Test
	public void testDeleteUser() {
		Long opc = 17L;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<>(null, header);
		ResponseEntity<String> response = restTemplate.exchange(util.getUrl(constRutes.getDelete()) + opc,
				HttpMethod.POST, entity, String.class);
		log.info("STATUS-CODE AND RUTE: -> {} {}", response.getStatusCode(), util.getUrl(constRutes.getDelete()));
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}

	/**
	 * "http://localhost:8080/api/v1/person/deletePerson/1"
	 * 
	 */
	@Test
	public void testDeleteUserOne() {
		Long opc = 1L;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<>(null, header);
		ResponseEntity<String> response = restTemplate.exchange(util.getUrl(constRutes.getDelete()) + opc,
				HttpMethod.POST, entity, String.class);
		log.info("STATUS-CODE AND RUTE: -> {} {}", response.getStatusCode(), util.getUrl(constRutes.getDelete()));
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}

}
