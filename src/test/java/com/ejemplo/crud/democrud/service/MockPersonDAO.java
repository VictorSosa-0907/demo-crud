package com.ejemplo.crud.democrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ejemplo.crud.democrud.controller.exceptions.DataNotFoundException;
import com.ejemplo.crud.democrud.controller.exceptions.PersonExistException;
import com.ejemplo.crud.democrud.model.Person;
import com.ejemplo.crud.democrud.repository.PersonDAO;

public class MockPersonDAO implements PersonDAO {
	List<Person> listaPerson;
	boolean failConection;

	public MockPersonDAO(boolean failConection) {
		listaPerson = new ArrayList<Person>();
		this.failConection = failConection;
	}

	private void tryConection() throws DataNotFoundException {
		if (failConection) {
			throw new DataNotFoundException();
		}
	}

	@Override
	public <S extends Person> S save(S entity) throws DataNotFoundException {
		// TODO Auto-generated method stub
		this.tryConection();
		if (this.findPersonByStatusOn(entity.getId()) == null) {
			listaPerson.add(entity);
		} else {
			throw new PersonExistException();
		}

		return null;
	}

	@Override
	public Person findPersonByStatusOn(Long id) throws DataNotFoundException {
		// TODO Auto-generated method stub
		this.tryConection();
		for (Person person : listaPerson) {
			if (person.getId() == id) {
				return person;
			}
		}
		return null;
	}

	@Override
	public List<Person> findPersonByStatus() throws DataNotFoundException {
		// TODO Auto-generated method stub
		this.tryConection();
		return listaPerson;
	}

	@Override
	public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Person> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Person findPersonByNombre(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
