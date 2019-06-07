package ar.edu.ub.progiii.mvc.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -5162863043037792271L;
	private String name;
	private String surname;
	private String id;
	private String dni;

	public PersonDTO() {
	}

	public PersonDTO(String name, String surname) {
		setName(name);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


}