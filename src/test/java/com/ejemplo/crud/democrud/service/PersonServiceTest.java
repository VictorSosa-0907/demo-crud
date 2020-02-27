package com.ejemplo.crud.democrud.service;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.crud.democrud.controller.exceptions.DataNotFoundException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonExistException;
import com.ejemplo.crud.democrud.model.Person;
import com.ejemplo.crud.democrud.repository.PersonDAO;

/**
 * 
 * @author Victor.Sosa
 * 
 *         pruebas unitarias
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	@Autowired
	private PersonDAO personRepository;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	boolean status;

	public Person setUp() {
		Person person = new Person();
		person.setNombre("personaService");
		person.setPaterno("paternoService");
		person.setMaterno("maternoService");
		person.setEdad(19);
		person.setCorreo("correo.persona.service@mail.com");
		person.setTel("1234-5678");
		return person;
	}

	@Test
	public void testGetAllPerson() {
		boolean status;
		List<Person> personas = personService.getAllPerson();
		if (personas.isEmpty()) {
			status = false;
		} else {
			status = true;
		}
		assertTrue(status);
	}

	@Test
	public void testSavePerson() {
		personService.savePerson(this.setUp());
		Person p = personRepository.findPersonByNombre(this.setUp().getNombre());
		this.status = (p == null) ? false : true;
		assertTrue(status);
	}

	@Test(expected = PersonException.class)
	public void testSavePersonNull() {
		personService.savePerson(null);
		exceptionRule.expect(PersonException.class);
	}

	@Test(expected = PersonExistException.class)
	public void testSavePersonExist() {
		personService.savePerson(this.setUp());
		exceptionRule.expect(PersonExistException.class);
	}

	@Test
	public void testUpdatePerson() {

		Person seach = personRepository.findPersonByNombre("RaulunitariaMOD");
		seach.setNombre("RaulunitariaMOD");
		seach.setPaterno("RaulunitariaMOD");
		seach.setMaterno("RaulunitariaMOD");
		seach.setEdad(19);
		seach.setCorreo("correo.raul.mod@mail.com");
		seach.setTel("1234-5678");
		personService.updatePerson(seach);
	}

	@Test(expected = PersonException.class)
	public void testUpdatePersonWithException() {
		Person seach = personRepository.findPersonByNombre("RaulunitariaMOD");
		seach.setNombre(null);
		seach.setPaterno(null);
		seach.setMaterno(null);
		seach.setEdad(0);
		seach.setCorreo("correo.raul.mod@mail.com");
		seach.setTel("1234-5678");
		personService.updatePerson(seach);
	}

	@Test
	public void testDeletePerson() {
		personService.deletePerson(1L);
		this.status = (personRepository.findById(1L).isPresent()) ? true : false;
		assertTrue(status);
	}

	@Test(expected = DataNotFoundException.class)
	public void testDeletePersonDataNotFound() {
		personService.deletePerson(100L);
		exceptionRule.expect(DataNotFoundException.class);
	}
}