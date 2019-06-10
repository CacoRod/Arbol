package springFinal.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -5162863043037792271L;
	private String nombre;
	private String apellido;
	private String dni;
  	private String fechaNac;
	private boolean murio;
	private String fechaFall;
	private String nacionalidad;
	private String sexo;
	private String padre;
	private boolean notieneP;
	private String madre;
	private boolean notieneM;


	public PersonDTO() {
	}

	public PersonDTO(String nombre, String apellido) {
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public boolean isMurio() {
		return murio;
	}


	public void setMurio(boolean murio) {
		this.murio = murio;
	}


	public String getFechaFall() {
		return fechaFall;
	}


	public void setFechaFall(String fechaFall) {
		this.fechaFall = fechaFall;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public boolean isNotieneP() {
		return notieneP;
	}


	public void setNotieneP(boolean notieneP) {
		this.notieneP = notieneP;
	}


	public String getMadre() {
		return madre;
	}


	public void setMadre(String madre) {
		this.madre = madre;
	}


	public boolean isNotieneM() {
		return notieneM;
	}


	public void setNotieneM(boolean notieneM) {
		this.notieneM = notieneM;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getPadre() {
		return padre;
	}


	public void setPadre(String padre) {
		this.padre = padre;
	}



}