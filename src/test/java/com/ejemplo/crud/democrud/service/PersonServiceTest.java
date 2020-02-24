package com.ejemplo.crud.democrud.service;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.crud.democrud.controller.exceptions.DataNotFoundException;
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
}
