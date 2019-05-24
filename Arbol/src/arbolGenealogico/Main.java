package arbolGenealogico;

public class Main {



	public static void main(String[] args) {
		Familia familiaTest = new Familia();
		Persona personaTest = new Hombre("Juan", "Mukenio");
		Persona personaTest2 = new Hombre("Magic","Mukenio");
		Persona personaTest3 = new Hombre("Pepe","Mukenio");
		Persona personaTest4 = new Mujer("Ernesta", "Mukenio");
		Persona personaTest5 = new Mujer("Ernestita", "Mukenio");
		Persona personaTest6 = new Mujer("Ernestota", "Mukenio");
		Persona personaTest7 = new Hombre("Ernesto", "Mukenio");
		Persona personaTest8 = new Hombre("Tito", "Mukenio");
		Persona personaTest9 = new Hombre("Ernestito", "Mukenio");
		
		personaTest2.setPadre(personaTest);
		personaTest7.setPadre(personaTest);
		personaTest8.setPadre(personaTest);
		personaTest4.setPadre(personaTest);
		personaTest9.setPadre(personaTest2);
		Persona.listarNombres(personaTest2.getPadres());
		System.out.println("\n");
		Persona.listarNombres(personaTest2.getHermanos());
		System.out.println("\n");
		Persona.listarNombres(personaTest2.getPrimos());

	}

}
