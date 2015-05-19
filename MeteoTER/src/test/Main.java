package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import outils.GribReader;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Date, ArrayList<Integer>> force = new HashMap<Date,  ArrayList<Integer>>();
		String path = "C:/Users/rihab/Desktop/fichierGrib/Bretagne.grb";
		@SuppressWarnings("unused")
		GribReader test = new GribReader(path);
		force = test.getMapForce();
		
		for (HashMap.Entry<Date, ArrayList<Integer>> entry : force.entrySet())
		{
			for(int i=0; i<force.size(); i++)
				System.out.println(entry.getKey() + "  Force:  " + entry.getValue().get(i));
		}
	}

}
