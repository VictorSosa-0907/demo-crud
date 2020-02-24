package com.ejemplo.crud.democrud.service;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	private PersonDAO personRepository;

	@Test
	public void testFindAllPerson() {
		boolean status;
		List<Person> persona = personRepository.findPersonByStatus();
		if (persona.isEmpty()) {
			status = false;
		} else {
			status = true;
		}
		assertTrue(status);
	}

	@Test
	public void testSavePerson() {
		boolean status;
		Person person = new Person();
		person.setNombre("personaService");
		person.setPaterno("paternoService");
		person.setMaterno("maternoService");
		person.setEdad(19);
		person.setCorreo("correo.persona.service@mail.com");
		person.setTel("1234-5678");
		personRepository.save(person);

		Person p = personRepository.findPersonByNombre(person.getNombre());
		status = (p == null) ? false : true;
		assertTrue(status);
	}
}
