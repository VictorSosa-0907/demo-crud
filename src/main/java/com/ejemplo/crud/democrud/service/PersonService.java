package com.ejemplo.crud.democrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.crud.democrud.controller.exceptions.DataNotFoundException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonExistException;
import com.ejemplo.crud.democrud.model.Person;
import com.ejemplo.crud.democrud.model.pojo.ViewPerson;
import com.ejemplo.crud.democrud.repository.PersonDAO;

/**
 * 
 * @author Victor.Sosa
 *
 */
@Service
public class PersonService {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PersonDAO personRepository;

	/* Buscar Personas */
	public List<Person> getAllPerson() {
		List<Person> person = personRepository.findPersonByStatus();
		/*
		 * si la consulta esta vacia manda una excepcion de vacio ve a
		 * GlobalHandlerException
		 */
		if (person.isEmpty()) {
			throw new DataNotFoundException();
		} else {
			return person;
		}
	}
	/* Buscar Personas */
	public List<Object> getViewPerson() {
		List<Object> person = personRepository.findViewPerson();
		/*
		 * si la consulta esta vacia manda una excepcion de vacio ve a
		 * GlobalHandlerException
		 */
		if (person.isEmpty()) {
			throw new DataNotFoundException();
		} else {
			return person;
		}
	}

	/* Guardar Persona */
	@Transactional
	public Person savePerson(Person person) {
		if ((person == null) || (person.getNombre() == null) || (person.getPaterno() == null)
				|| (person.getMaterno() == null) || (person.getEdad() == 0)) {
			throw new PersonException();
		} else {
			Person p = personRepository.findPersonByNombre(person.getNombre());
			if (p == null) {
				Person save = new Person();
				save.setNombre(person.getNombre());
				save.setPaterno(person.getPaterno());
				save.setMaterno(person.getMaterno());
				save.setEdad(person.getEdad());
				save.setCorreo(person.getCorreo());
				save.setTel(person.getTel());

				personRepository.save(save);
				log.info("{}", save);
				return save;
			} else {
				throw new PersonExistException();
			}
		}
	}

	/* Actualizar Persona */
	@Transactional
	public Person updatePerson(Person person) {
		Person objDbp = null;
		if ((person == null) || (person.getNombre() == null) || (person.getPaterno() == null)
				|| (person.getMaterno() == null) || (person.getEdad() == 0)) {
			throw new PersonException();
		} else {
			Optional<Person> dbp2 = personRepository.findById(person.getId());
			if (dbp2.isPresent()) {
				dbp2.get().setNombre(person.getNombre());
				dbp2.get().setPaterno(person.getPaterno());
				dbp2.get().setMaterno(person.getMaterno());
				dbp2.get().setEdad(person.getEdad());
				dbp2.get().setCorreo(person.getCorreo());
				dbp2.get().setTel(person.getTel());

				objDbp = dbp2.get();
				personRepository.save(objDbp);
			}
			return objDbp;
		}
	}

	/* Borrar Persona */
	@Transactional
	public Person deletePerson(Long id) {
		Person person = personRepository.findPersonByStatusOn(id);
		if (person == null) {
			throw new DataNotFoundException();
		} else {
			person.setStatus(false);
			personRepository.save(person);
			log.info("{}", person);
			return person;
		}
	}
}