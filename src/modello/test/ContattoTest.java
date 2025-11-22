package modello.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Contatto;

class ContattoTest {

	private Contatto c1, c2;
	
	@BeforeEach
	void setUp() {
		c1 = new Contatto("Marco", "+39 1231231234");
	}
	
	@AfterEach
	void tearDown() {
		c1 = null;
	}
	
	@Test
	void testCostruttore() {
		assertEquals("Marco", c1.getNome());
		assertEquals("+39 1231231234", c1.getNumeroTel());
		
		c2 = new Contatto("Giulia", "3453453456");
		assertEquals("Giulia", c2.getNome());
		assertEquals("3453453456", c2.getNumeroTel());
	}
	
	@Test
	void testSetNome() {
		c1.setNome("Mirco");
		assertEquals("Mirco", c1.getNome());
		assertEquals("Mirco: +39 1231231234", c1.toString());
	}
	
	@Test
	void testSetNumero() {
		c1.setNumero("1231231234");
		assertEquals("1231231234", c1.getNumeroTel());
		assertEquals("Marco: 1231231234", c1.toString());
	}
	
	@Test
	void testToString() {
		assertEquals("Marco: +39 1231231234", c1.toString());
		
		c2 = new Contatto("Giulia", "3453453456");
		assertEquals("Giulia: 3453453456", c2.toString());
	}
	
}
