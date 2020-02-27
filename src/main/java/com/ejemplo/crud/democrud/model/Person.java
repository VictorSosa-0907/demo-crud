package com.ejemplo.crud.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 
 * @author Victor.Sosa
 *
 */
@Entity
@Table(name = "person")
@Data
public class Person {
	@Id
	@Column(name = "id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String nombre;
	@Column(name = "last_name_one")
	private String paterno;
	@Column(name = "last_name_two")
	private String materno;
	@Column(name = "age")
	private int edad;
	@Column(name = "mail")
	private String correo;
	@Column(name = "phone")
	private String tel;
	@Column(name = "status", nullable = false)
	private boolean status = true;
}