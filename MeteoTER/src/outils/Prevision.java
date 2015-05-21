package outils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.math.analysis.RombergIntegrator;

public class Prevision {
	
	public ArrayList<StructureUV> getNearestPoints(double x,double y,ArrayList<StructureUV> listUV ){
		ArrayList<StructureUV> points= new ArrayList<StructureUV>();
		double[] listeDistance=new double[listUV.size()];
		StructureUV struct =new StructureUV();
		HashMap<Double,Integer> l=new HashMap<Double, Integer>();
		StructureUV unPoint=new StructureUV(x, y);
		for(int i=0; i<listUV.size();i++)
		{
			listeDistance[i]=struct.calculDistance(unPoint, listUV.get(i));
			l.put(listeDistance[i], i);
			
		}
		Arrays.sort(listeDistance);
		for(int j=0; j<4; j++){
			points.add(listUV.get(l.get(listeDistance[j])));
		}
		
		
		return points;
		
	}
	
	public static void main(String[] args) {
		Prevision p=new Prevision();
		ArrayList<StructureUV> listUV=new ArrayList<StructureUV>();
		
		for(int i=0;i<100;i++){
			listUV.add(new StructureUV(new Random().nextDouble(), new Random().nextDouble()));
			System.out.println("U "+listUV.get(i).get_u()+"v "+listUV.get(i).get_v());
		}
		ArrayList<StructureUV> points=p.getNearestPoints(0.5, 0.8,listUV);
		for(int j=0;j<points.size();j++){
			System.out.println("*********");
			System.out.println("U "+points.get(j).get_u()+"v "+points.get(j).get_v());
		}
		
	}

}
