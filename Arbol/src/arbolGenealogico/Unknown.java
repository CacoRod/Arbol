package arbolGenealogico;

import java.util.TreeSet;

class Unknown extends Persona {

	
	
	public Unknown() {

	}
	
	
	public int compareTo(Persona o) {
		return 1;
	}
	public Persona getPadre() {
		return new Unknown();
	}
	public Persona GetMadre() {
		return new Unknown();
	}
	public TreeSet<Persona> getHijos() {
		return new TreeSet<Persona>();
		
	}
	public TreeSet<Persona> getHijas() {
		return new TreeSet<Persona>();
		
	}
}