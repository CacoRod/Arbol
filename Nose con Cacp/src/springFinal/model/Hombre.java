package springFinal.model;
import java.time.LocalDate;
import java.util.TreeSet;

public class Hombre extends Persona{

	public Hombre(String dni,String nombre, String apellido, String nacionalidad, String domicilio, LocalDate fnac) {
		super(dni,nombre, apellido, nacionalidad, domicilio, fnac);

	}

	public void setPadre(Persona padre) {
		super.setPadre(padre);
		this.agregarHombre(padre.getHijos());
		this.agregarMujer(padre.getHijas());
	}
	public void setMadre(Persona madre) {
		super.setMadre(madre);
		this.agregarHombre(madre.getHijos());
		this.agregarMujer(madre.getHijas());
	}
	public void agregarMujer(TreeSet<Persona> lista) {}


public void agregarHombre(TreeSet<Persona> lista) {
	lista.add(this);
}

}
