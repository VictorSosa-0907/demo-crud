package com.ejemplo.crud.democrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejemplo.crud.democrud.model.Person;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
	@Query(value = "SELECT * FROM person WHERE status = 1", nativeQuery = true)
	  public List<Person> findPersonByStatus();
	@Query(value = "SELECT * FROM person WHERE id_person = :id and status = 1", nativeQuery = true)
	public Person findPersonByStatusOne(@Param("id") Long id);
}