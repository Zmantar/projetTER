package outils;

public class Interpolation {
	
	private double[] arr = new double[4];
	
	public static double getValue1 (double[] p, double x) {
		
		return p[1] + 0.5 * x*(p[2] - p[0] + x*(2.0*p[0] - 5.0*p[1] + 4.0*p[2] - p[3] + x*(3.0*(p[1] - p[2]) + p[3] - p[0])));
	}
	
	public double getValue2 (double[][] p, double x, double y) {
		
		arr[0] = getValue1(p[0], y);
		arr[1] = getValue1(p[1], y);
		arr[2] = getValue1(p[2], y);
		arr[3] = getValue1(p[3], y);
		
		return getValue1(arr, x);
	}
	
	public double getValue (double[][][] p, double x, double y, double z) {
		
		arr[0] = getValue2(p[0], y, z);
		arr[1] = getValue2(p[1], y, z);
		arr[2] = getValue2(p[2], y, z);
		arr[3] = getValue2(p[3], y, z);
			
		return getValue1(arr, x);
	}
	
	
}
