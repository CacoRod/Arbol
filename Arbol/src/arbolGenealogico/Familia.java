package arbolGenealogico;

import java.util.TreeSet;
import javax.swing.*;


public class Familia {
	TreeSet<Persona> familiares;
	
	
	
	public Familia() {
		familiares = new TreeSet<Persona>();
	}
	
	
	
	public TreeSet<Persona> getFamiliares() {
		return familiares;
	}

	public void agregar(Persona a) {
		familiares.add(a);
	}
}