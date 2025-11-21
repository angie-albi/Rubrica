package modello.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.GestoreRubriche;
import modello.Rubrica;

class GestoreRubricheTest {

	private GestoreRubriche R;
	
	@BeforeEach
	void setUp() {
		R = new GestoreRubriche();
	}
	
	@AfterEach 
	void tearDown() {
		R.svuotaElencoRub();
	}
	
	@Test
	void testCostruttore() {
		assertEquals(0, R.numRub());
		
		R.createRubrica("Amici", 5);
		assertEquals(1, R.numRub());
		
		R.createRubrica("Famiglia", 10);
		assertEquals(2, R.numRub());
	}
	
	@Test
	void testSelezioneRubrica() {
		R.createRubrica("Amici", 5);
		R.createRubrica("Famiglia", 10);
		R.createRubrica("Colleghi", 7);
		
		Rubrica ris = R.selezionaRubrica("Famiglia");
		assertEquals(10, ris.MAX_DIM);
		assertEquals("Famiglia", ris.getNome());
	}
	
	@Test
	void testDeleteRubrica() {
		R.createRubrica("Amici", 5);
		R.createRubrica("Famiglia", 10);
		R.createRubrica("Colleghi", 7);
		assertEquals(3, R.numRub());
		
		boolean ris = R.deleteRubrica("Famiglia");
		assertEquals(true, ris);
		assertEquals(2, R.numRub());
		
		ris = R.deleteRubrica("A");
		assertEquals(false, ris);
		assertEquals(2, R.numRub());
	}
	
	@Test
	void testSvuota() {
		R.createRubrica("Amici", 5);
		R.createRubrica("Famiglia", 10);
		R.createRubrica("Colleghi", 7);
		assertEquals(3, R.numRub());
		
		R.svuotaElencoRub();
		assertEquals(0, R.numRub());
	}
	
	@Test
	void testGetElenco() {
		ArrayList<Rubrica> ris = R.getElenco();
		assertEquals(0, ris.size());
		
		R.createRubrica("Amici", 5);
		R.createRubrica("Famiglia", 10);
		R.createRubrica("Colleghi", 7);
		
		ris = R.getElenco();
		assertEquals(3, ris.size());
	}
}
