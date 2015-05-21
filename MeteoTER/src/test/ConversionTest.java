package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import outils.Conversion;
/**
 * 
 * @author Arewa 
 * Cette classe permet de faire les tests unitaires de la conversion
 */
public class ConversionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testX_To_Lon() {
		assertEquals(859.437, Conversion.xToLon(15),0.01);
	}

	
	@Test
	public void testLon_To_X() {
		assertEquals(859.4367, Conversion.lonToX(15),0.01);
	}
	
	@Test
	public void testLat_To_Y() {
		assertEquals(15.1744, Conversion.latToY(15),0.01);
	}
	
	@Test
	public void testY_To_Lat() {
		assertEquals(14.8316, Conversion.yToLat(15),0.01);
	}
	
	@Test
	public void testMs_To_Knots() {
		assertEquals(29.1577, Conversion.msToKnots(15),0.01);
	}
	
	@Test
	public void testKnots_To_Ms() {
		assertEquals(7.7167, Conversion.knotsToMs(15),0.01);
	}
	
	
}
