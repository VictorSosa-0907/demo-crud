package com.ejemplo.crud.democrud;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
import com.ejemplo.crud.democrud.repository.PersonDAO;
import com.ejemplo.crud.democrud.service.util.ConstantsRutes;
import com.ejemplo.crud.democrud.service.util.Util;

/**
 * 
 * @author Victor.Sosa
 * 
 *         pruebas de integracion
 *
 *
 */
//TODO webEnvironment configura entorno en tiempo de ejecucion (entorno simulado)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoCrudApplicationTests {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private ConstantsRutes constRutes;
	@Autowired
	private PersonDAO personRepository;
	@Autowired
	private Util util;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	public Person setUp() {
		Person person = new Person();
		person.setNombre("IntegrationServicePerson");
		person.setPaterno("IntegrationServiceLastName");
		person.setMaterno("IntegrationServiceLastNameTwo");
		person.setEdad(50);
		person.setCorreo("integration.service.person.@mail.com");
		person.setTel("8888-9999");
		return person;
	}

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
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/savePerson"
	 */
	@Test
	public void testSavePerson() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<Person>(this.setUp(), header);
		ResponseEntity<Person> response = restTemplate.exchange(util.getUrl(constRutes.getSave()), HttpMethod.POST,
				entity, Person.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), entity);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/savePerson" Genera excepcion por
	 * existencia
	 */
	@Test
	public void testSavePersonNull() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<Person>(this.setUp(), header);
		ResponseEntity<Person> response = restTemplate.exchange(util.getUrl(constRutes.getSave()), HttpMethod.POST,
				entity, Person.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), entity);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/savePerson" Genera excepcion por objeto
	 * nulo
	 */
	@Test
	public void testSavePersonExist() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<Person>(new Person(), header);
		ResponseEntity<Person> response = restTemplate.exchange(util.getUrl(constRutes.getSave()), HttpMethod.POST,
				entity, Person.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), entity);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/updatePerson"
	 */
	@Test
	public void testUpdatePerson() {
		Person objDbp = null;
		Optional<Person> seach = personRepository.findById(3L);
		seach.get().setNombre("JonathanMOD");
		seach.get().setPaterno("JonathanMOD");
		seach.get().setMaterno("JonathanMOD");
		seach.get().setEdad(40);
		seach.get().setCorreo("correo.jona.mod@mail.com");
		seach.get().setTel("1234-5678");
		objDbp = seach.get();
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<Person>(objDbp, header);
		ResponseEntity<Person> response = restTemplate.exchange(util.getUrl(constRutes.getUpdate()), HttpMethod.POST,
				entity, Person.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), entity);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/updatePerson" Genera Excepcion por
	 * campos nulos
	 */
	@Test
	public void testUpdatePersonWithException() {
		Person objDbp = null;
		Optional<Person> seach = personRepository.findById(3L);
		seach.get().setNombre("Indefinido");
		seach.get().setPaterno(null);
		seach.get().setMaterno(null);
		seach.get().setEdad(0);
		seach.get().setCorreo("correo.jona.mod@mail.com");
		seach.get().setTel("1234-5678");
		objDbp = seach.get();
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<Person>(objDbp, header);
		ResponseEntity<Person> response = restTemplate.exchange(util.getUrl(constRutes.getUpdate()), HttpMethod.POST,
				entity, Person.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), entity);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/deletePerson/{1}"
	 */
	@Test
	public void testDeletePerson() {
		Long opc = 1L;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<>(null, header);
		ResponseEntity<String> response = restTemplate.exchange(util.getUrl(constRutes.getDelete()) + opc,
				HttpMethod.POST, entity, String.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), opc);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/**
	 * "http://localhost:8080/api/v1/person/deletePerson/{100}" En este test se
	 * espera una excepcion DataNotFoundException
	 */
	@Test
	public void testDeletePersonDataNotFoundException() {
		Long opc = 100L;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Person> entity = new HttpEntity<>(null, header);
		ResponseEntity<String> response = restTemplate.exchange(util.getUrl(constRutes.getDelete()) + opc,
				HttpMethod.POST, entity, String.class);
		log.info("STATUS-CODE AND RUTE: -> {} {} \nPARAMS: {}", response.getStatusCode(),
				util.getUrl(constRutes.getDelete()), opc);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}