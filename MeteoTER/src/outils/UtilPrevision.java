package outils;

/**
 * 
 * @author Arewa
 *
 */
public class UtilPrevision {

	
	/**
	 * Cette fonction calcul la direction a partir des deux variables
	 * d'orientation u et v La fonction retourne une valeur en degré
	 * 
	 * @param u
	 * @param v
	 * @return double
	 */
	public static double uvToDirection(double u, double v) {
		return Math.toDegrees(180 / Math.PI * Math.atan2(u, v) + 180);
	}

	/**
	 * Cette fonction calcul la vitesse a partir des deux variables
	 * d'orientation u et v
	 * 
	 * @param u
	 * @param v
	 * @return double
	 */
	public static double uvToVitesse(double u, double v) {
		return Math.sqrt(u * u + v * v);
	}

	/**
	 * Cette fonction calcul le U a partir de la valeur de vitesse et de
	 * direction La fonction retourne une valeur en degré
	 * 
	 * @param direction
	 * @param vitesse
	 * @return double
	 */
	public static double VitesseDirectionToU(double direction, double vitesse) {
		return Math.toDegrees(-Math.sin(direction * Math.PI / 180) * vitesse);
	}

	/**
	 * Cette fonction calcul le V a partir de la valeur de vitesse et de
	 * direction La fonction retourne une valeur en degré
	 * 
	 * @param direction
	 * @param vitesse
	 * @return double
	 */
	public static double VitesseDirectionToV(double direction, double vitesse) {
		return Math.toDegrees(-Math.cos(direction * Math.PI / 180) * vitesse);
	}

	
	/**
	 * Cette fonction calcul la force à partir de la vitesse Elle retourne la
	 * force en entier et remplie la variable terme avec la description associée
	 * 
	 * @param vitesse
	 * @return int
	 */
	public static Integer calculer_Force(double vitesse) {
		int res = 0;

		vitesse = Conversion.msToKmh(vitesse);

		if (vitesse < 1) {
			res = 0;
		} else if (1 <= vitesse && vitesse <= 5) {
			res = 1;
			
		} else if (6 <= vitesse && vitesse <= 11) {
			res = 2;
		} else if (12 <= vitesse && vitesse <= 19) {
			res = 3;
		} else if (20 <= vitesse && vitesse <= 28) {
			res = 4;
		} else if (29 <= vitesse && vitesse <= 38) {
			res = 5;
		} else if (39 <= vitesse && vitesse <= 49) {
			res = 6;
		} else if (50 <= vitesse && vitesse <= 61) {
			res = 7;
		} else if (62 <= vitesse && vitesse <= 74) {
			res = 8;
		} else if (75 <= vitesse && vitesse <= 88) {
			res = 9;
		} else if (89 <= vitesse && vitesse <= 102) {
			res = 10;
		} else if (103 <= vitesse && vitesse <= 117) {
			res = 11;
		} else if (vitesse >= 118) {
			res = 12;
		}

		return res;
	}

	/**
	 * Cette fonction sert à connaître a partir de la force 
	 * le terme qui décrit le vent
	 * @return String
	 */

	public static String getTermes(int force) {
		String Termes = null;

		if (force == 0) {
			Termes = "Calme";
		} else if (force == 1) {
			Termes = "Très légère brise";
		} else if (force == 2) {
			Termes = "légère brise";
		} else if (force == 3) {
			Termes = "Petite brise";
		} else if (force == 4) {
			Termes = "Jolie brise";
		} else if (force == 5) {
			Termes = "Bonne brise";
		} else if (force == 6) {
			Termes = "Vent frais";
		} else if (force == 7) {
			Termes = "Grand frais";
		} else if (force == 8) {
			Termes = "Coup de vent";
		} else if (force == 9) {
			Termes = "Fort coup de vent";
		} else if (force == 10) {
			Termes = "Tempête";
		} else if (force == 11) {
			Termes = "Violente tempête";
		} else if (force == 12) {
			Termes = "Ouragan";
		}

		return Termes;
	}

}
