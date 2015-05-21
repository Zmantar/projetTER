package outils;

import java.lang.Math;

/**
 * 
 * @author RihabZ
 *
 */

public class Conversion {

	private final static double CONSTKNOTS = 1.9438444924574;
	private final static double CONSTMS = 0.51444444444;
	private final static double CONSTKH = 3.6;

	/**
	 * Cette fonction permet de convertir une variable double y en latitude Elle
	 * retourne une valeur en degré
	 * 
	 * @param y
	 * @return double
	 */
	public static double yToLat(double y) {
		return Math.toDegrees(2 * Math.atan(Math.exp(Math.toRadians(y)))
				- Math.PI / 2);
	}

	/**
	 * Cette fonction permet de convertir la latitude en y Elle retourne une
	 * valeur en degré
	 * 
	 * @param lat
	 * @return double
	 */
	public static double latToY(double lat) {
		return Math.toDegrees(Math.log(Math.tan(Math.PI / 4
				+ Math.toRadians(lat) / 2)));
	}

	/**
	 * Cette fonction permet de convertir une variable double x en longitude
	 * Elle retourne une valeur en degré
	 * 
	 * @param x
	 * @return double
	 */
	public static double xToLon(double x) {
		return Math.toDegrees(x);
	}

	/**
	 * Cette fonction permet de convertir la longitude en x Elle retourne une
	 * valeur en degré
	 * 
	 * @param lon
	 * @return double
	 */
	public static double lonToX(double lon) {
		return Math.toDegrees(lon);
	}

	/**
	 * Cette fonction converti une variable en m/s a Knot
	 * 
	 * @param ms
	 * @return double
	 */
	public static double msToKnots(double ms) {
		return CONSTKNOTS * ms;
	}

	/**
	 * Cette fonction converti une variable en knot vers le m/s
	 * 
	 * @param knots
	 * @return double
	 */
	public static double knotsToMs(double knots) {
		return CONSTMS * knots;
	}

	
	/**
	 * Cette fonction converti la vitesse de m/s vers le km/h
	 * 
	 * @param vitesse
	 * @return double
	 */
	public static double msToKmh(double vitesse) {
		return vitesse * CONSTKH;
	}

	
}
