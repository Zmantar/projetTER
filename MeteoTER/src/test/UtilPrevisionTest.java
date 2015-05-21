package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import outils.UtilPrevision;

/**
 * 
 * @author Arewa 
 * Cette classe permet de faire les tests unitaires des methodes utiles pour la prevision
 */
public class UtilPrevisionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testUv_To_Direction() {
		assertEquals(12891.5504, UtilPrevision.uvToDirection(15, 15),0.01);
	}
	
	
	@Test
	public void testUv_To_Vitesse() {
		assertEquals(21.2133, UtilPrevision.uvToVitesse(15, 15),0.01);
	}
	

	@Test
	public void testVitesse_Direction_To_U() {
		assertEquals(-222.4386, UtilPrevision.VitesseDirectionToU(15, 15),0.01);
	}
	
	@Test
	public void testVitesse_Direction_To_V() {
		assertEquals(-830.1521, UtilPrevision.VitesseDirectionToV(15, 15),0.01);
	}

	@Test
	public void testCalculer_Force() {
		assertEquals(10, (int)UtilPrevision.calculer_Force(100));
		//assertEquals("Tempête", Conversion.getTermes());
	}
	

}
