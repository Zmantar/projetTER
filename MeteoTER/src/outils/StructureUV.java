package outils;

public class StructureUV {

	private double _u, _v;
	public StructureUV(){
		
	}
	public StructureUV(double u, double v) {

		this._u = u;
		this._v = v;
	}

	public double get_u() {
		return _u;
	}

	public void set_u(double _u) {
		this._u = _u;
	}

	public double get_v() {
		return _v;
	}

	public void set_v(double _v) {
		this._v = _v;
	}
 public double calculDistance(StructureUV pt1, StructureUV pt2)
 {
	 double x1, x2, y1, y2;
	 x1=pt1.get_u();
	 x2=pt2.get_u();
	 y1=pt1.get_v();
	 y2=pt2.get_v();
   return Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
 }
}
