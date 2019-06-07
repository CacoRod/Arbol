package springFinal.model;

import java.time.LocalDate;
import java.util.TreeSet;

public class Mujer extends Persona {

	public Mujer(String nombre, String apellido, String nacionalidad, String domicilio, LocalDate fnac) {
		super(nombre, apellido, nacionalidad, domicilio, fnac);

	}
	
	public Mujer(String nombre, String apellido, String nacionalidad, String domicilio, LocalDate fnac, LocalDate fdec) {
		super(nombre, apellido, nacionalidad, domicilio, fnac, fdec);

	}
	
	public void setMadre(Persona madre) {
		super.setMadre(madre);
		this.agregarHombre(madre.getHijos());
		this.agregarMujer(madre.getHijas());
	}
	
	public void setPadre(Persona padre) {
		super.setPadre(padre);
		this.agregarHombre(padre.getHijos());
		this.agregarMujer(padre.getHijas());
	}
	
	
	public void agregarMujer(TreeSet<Persona> lista) {
		lista.add(this);
	}
	
	public void agregarHombre(TreeSet<Persona> lista) {
	}



}
