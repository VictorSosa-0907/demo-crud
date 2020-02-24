package com.ejemplo.crud.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Victor.Sosa
 *
 */
@Entity
@Table(name = "person")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", edad="
				+ edad + ", correo=" + correo + ", tel=" + tel + ", status=" + status + "]";
	}
}
