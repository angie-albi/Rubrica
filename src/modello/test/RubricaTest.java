package modello.test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import modello.Rubrica;

class RubricaTest {
	
	private Rubrica r1, r2;
	
	@BeforeEach
	void setUp() {
		r1= new Rubrica("Amici", 5);
	}
	
	
	@AfterEach
	void tearDown() {
		r1.svuota();
	}
	
	@Test
	void testCostruttore() {
		assertTrue(r1.numEl() == 0);
		assertEquals("Amici", r1.getNome());
		assertEquals(5, r1.MAX_DIM);
		
		r2= new Rubrica("Famiglia", 10);
		assertTrue(r2.numEl() == 0);
		assertEquals("Famiglia", r2.getNome());
		assertEquals(10, r2.MAX_DIM);
	}
	
	@Test
	void testAggiungiCorrettamente() { 
		int ris = r1.aggiungi("Marco", "+39 1231231234");
		assertEquals(1, ris);
		assertEquals(1, r1.numEl());
		
		ris = r1.aggiungi("Giorgio", "2342342345");
		assertEquals(1, ris);
		assertEquals(2, r1.numEl());
		
		ris = r1.aggiungi("Giulia", "3453453456");
		assertEquals(1, ris);
		assertEquals(3, r1.numEl());
		
		ris = r1.aggiungi("Marta", "4564564567");
		assertEquals(1, ris);
		assertEquals(4, r1.numEl());
	}
	
	@Test 
	void testAggiungiOltreIlLimite() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		
		int ris = r1.aggiungi("Ted", "5675675678");
		assertEquals(-1, ris);
		assertEquals(5, r1.numEl());
	}
	
	@Test
	void testAggiungiStringaPresente() {
		Rubrica r1= new Rubrica("Amici", 5);
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		assertEquals(3, r1.numEl());

		int ris = r1.aggiungi("Giulia", "3453453456");
		assertEquals(0, ris);
		assertEquals(3, r1.numEl());
		
	}
	
	@Test
	void testRicerca() {
		assertEquals(0, r1.numEl());
		assertEquals(0, r1.ricerca("").size()); // ricerca nella rubrica vuota

		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		assertEquals(3, r1.numEl());
		
		assertEquals(0, r1.ricerca("A").size());
		assertEquals(1, r1.ricerca("Giorgio").size());
		assertEquals(1, r1.ricerca("M").size());
		assertEquals(2, r1.ricerca("Gi").size());
		assertEquals(3, r1.ricerca("").size());
	}
	
	@Test
	void testEliminaRubricaVuota() {
		assertEquals(0, r1.numEl());
		assertFalse(r1.elimina(""));
	}
	
	@Test
	void testEliminaTutti() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		assertEquals(5, r1.numEl());
		
		assertTrue(r1.elimina(""));
		assertEquals(0, r1.numEl());
	}
	
	@Test
	void testEliminaPrimo() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		assertEquals(5, r1.numEl());
		
		assertTrue(r1.elimina("Marco"));
		assertEquals(4, r1.numEl());
	}
	
	@Test
	void testEliminaNessuno() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		assertEquals(5, r1.numEl());
		
		assertFalse(r1.elimina("F"));
		assertEquals(5, r1.numEl());
	}
	
	@Test
	void testEliminaAdiacenti() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		assertEquals(5, r1.numEl());
		
		assertTrue(r1.elimina("G"));
		assertEquals(2, r1.numEl());
	}
	
	@Test
	void testEliminaUltimo() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		assertEquals(5, r1.numEl());
		
		assertTrue(r1.elimina("Ginny"));
		assertEquals(4, r1.numEl());
	}
	
	
	@Test
	void testSvuota() {
		r1.aggiungi("Marco", "+39 1231231234");
		r1.aggiungi("Giorgio", "2342342345");
		r1.aggiungi("Giulia", "3453453456");
		r1.aggiungi("Marta", "4564564567");
		r1.aggiungi("Ginny", "5675675678");
		
		r1.svuota();
		assertEquals(0, r1.numEl());
	}
	
}
