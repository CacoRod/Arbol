package arbolGenealogico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClass {

	@BeforeEach
	void setUp() throws Exception {
		personaTest = new Hombre("Juan", "Mukenio");
		personaTest2 = new Hombre("Magic","Mukenio");
		personaTest3 = new Hombre("Pepe","Mukenio");
		personaTest.setPadre(personaTest2);
		personaTest2.setPadre(personaTest3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNombre() {
		assertEquals("Juan", personaTest.getNombre());
		personaTest.setNombre("Lala");
		assertEquals("Lala", personaTest.getNombre());
		personaTest.setNombre(null);
		assertNull(personaTest.getNombre());
		personaTest.setNombre("");
	}
	void testGetPadres() {
		assertNotNull(personaTest3.getPadres());
		assertNotNull(personaTest3.getPadre().getApellido());
	}
	void testGetAbuelo() {
		assertEquals(personaTest.getAbuelos(), personaTest2.getPadre());
		assertNull(personaTest.getPadres());

	}
	
	Persona personaTest;
	Persona personaTest2;
	Persona personaTest3;

}
