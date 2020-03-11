package com.ejemplo.crud.democrud.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

/**
 * 
 * @author Victor.Sosa
 * Prueba de concepto de como se consume una vista
 */
@Data
@Immutable
@Entity
@Table(name = "view_person")
public class ViewPerson {
	@Id
	private Long id;
	@Column(name = "name")
	private String nombre;
	@Column(name = "last_name_one")
	private String paterno;
	@Column(name = "last_name_two")
	private String materno;
}
