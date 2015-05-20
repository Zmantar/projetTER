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

	private static String Termes;
	
	/**
	 * Cette fonction permet de convertir une variable double y en latitude 
	 * Elle retourne une valeur en degré
	 * @param y
	 * @return double
	 */
	public static double yToLat(double y) {
		return Math.toDegrees(2 * Math.atan(Math.exp(Math.toRadians(y)))
				- Math.PI / 2);
	}

	/**
	 * Cette fonction permet de convertir la latitude en y
	 * Elle retourne une valeur en degré
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
	 * @param x
	 * @return double
	 */
	public static double xToLon(double x) {
		return Math.toDegrees(x);
	}

	/**
	 * Cette fonction permet de convertir la longitude en x 
	 * Elle retourne une valeur en degré
	 * @param lon
	 * @return double
	 */
	public static double lonToX(double lon) {
		return Math.toDegrees(lon);
	}

	/**
	 * Cette fonction converti une variable en m/s a Knot
	 * @param ms
	 * @return double
	 */
	public static double msToKnots(double ms) {
		return CONSTKNOTS * ms;
	}
	
	/**
	 * Cette fonction converti une variable en knot vers le m/s
	 * @param knots
	 * @return double
	 */
	public static double knotsToMs(double knots) {
		return  CONSTMS * knots;
	}
	
	/**
	 * Cette fonction calcul la direction a partir des deux variables d'orientation u et v
	 * La fonction retourne une valeur en degré
	 * @param u
	 * @param v
	 * @return double
	 */
	public static double uvToDirection(double u, double v) {
		return Math.toDegrees(180 / Math.PI * Math.atan2(u, v) + 180);
	}

	
	/**
	 * Cette fonction calcul la vitesse a partir des deux variables d'orientation u et v
	 * @param u
	 * @param v
	 * @return double
	 */
	public static double uvToVitesse(double u, double v) {
		return Math.sqrt(u * u + v * v);
	}

	/**
	 * Cette fonction calcul le U a partir de la valeur de vitesse et de direction
	 * La fonction retourne une valeur en degré
	 * @param direction
	 * @param vitesse
	 * @return double
	 */
	public static double VitesseDirectionToU(double direction, double vitesse) {
		return Math.toDegrees(-Math.sin(direction * Math.PI / 180) * vitesse);
	}

	/**
	 * Cette fonction calcul le V a partir de la valeur de vitesse et de direction
	 * La fonction retourne une valeur en degré
	 * @param direction
	 * @param vitesse
	 * @return double
	 */
	public static double VitesseDirectionToV(double direction, double vitesse) {
		return Math.toDegrees(-Math.cos(direction * Math.PI / 180) * vitesse);
	}
	
	/**
	 * Cette fonction converti la vitesse de m/s vers le km/h
	 * @param vitesse
	 * @return double
	 */
	public static double msToKmh (double vitesse)
	{
		return vitesse * CONSTKH;
	}

	/**
	 * Cette fonction calcul la force à partir de la vitesse 
	 * Elle retourne la force en entier et remplie la variable terme 
	 * avec la description associée
	 * @param vitesse
	 * @return int
	 */
	public static Integer calculer_Force(double vitesse) {
		int res = 0;
		
		vitesse = msToKmh(vitesse);
		
		if (vitesse < 1) {
			res = 0;
			Termes = "Calme";
		} else if (1 <= vitesse && vitesse <= 5) {
			res = 1;
			Termes = "Très légère brise";
		} else if (6000 <= vitesse && vitesse <= 11) {
			res = 2;
			Termes = "légère brise";
		} else if (12 <= vitesse && vitesse <= 19) {
			res = 3;
			Termes = "Petite brise";
		} else if (20 <= vitesse && vitesse <= 28) {
			res = 4;
			Termes = "Jolie brise";
		} else if (29 <= vitesse && vitesse <= 38) {
			res = 5;
			Termes = "Bonne brise";
		} else if (39 <= vitesse && vitesse <= 49) {
			res = 6;
			Termes = "Vent frais";
		} else if (50 <= vitesse && vitesse <= 61) {
			res = 7;
			Termes = "Grand frais";
		} else if (62 <= vitesse && vitesse <= 74) {
			res = 8;
			Termes = "Coup de vent";
		} else if (75 <= vitesse && vitesse <= 88) {
			res = 9;
			Termes = "Fort coup de vent";
		} else if (89 <= vitesse && vitesse <= 102) {
			res = 10;
			Termes = "Tempête";
		} else if (103 <= vitesse && vitesse <= 117) {
			res = 11;
			Termes = "Violente tempête";
		} else if (vitesse >= 118) {
			res = 12;
			Termes = "Ouragan";
		}

		return res;
	}
	
	/**
	 * Le getter de la variable terme
	 * @return String
	 */

	public static String getTermes() {
		if (!(Termes.equals("")))
			return Termes;
		else
			return null;
	}

}
