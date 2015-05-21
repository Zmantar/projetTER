package outils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import java.util.Iterator;
import java.util.Set;

import net.sourceforge.jgrib.GribFile;
import net.sourceforge.jgrib.GribRecord;
import net.sourceforge.jgrib.GribRecordGDS;
import net.sourceforge.jgrib.NoValidGribException;
import net.sourceforge.jgrib.NotSupportedException;

public class GribReader {

	HashMap<Date, ArrayList<StructureUV>> listUV = new HashMap<>();
	HashMap<Date, ArrayList<Double>> mapVitesse = new HashMap<>();
	HashMap<Date, ArrayList<Integer>> mapForce = new HashMap<>();
	
	GribFile grb;
	int nbx, nby;
	GribRecordGDS r2;
	GribRecord ventU, ventV;
	ArrayList<StructureUV> list = new ArrayList<StructureUV>();
	ArrayList<Double> listVitesse = new ArrayList<Double>();
	ArrayList<Integer> listForce = new ArrayList<Integer>();
	StructureUV uv;
	int nbDate;
	int k =0, i=0, l=0, j=0;
	
	public GribReader(){
		
	}

	public GribReader(String path) {
		reupererUV(path);
	}

	@SuppressWarnings("deprecation")
	public void reupererUV(String path) {

		try {
			grb = new GribFile(path);
			r2 = grb.getGrids()[0];

			nbx = r2.getGridNX();
			nby = r2.getGridNY();

			if (grb.getRecord(1).getDescription().equals("u wind")) {
				ventU = grb.getRecord(1);
				ventV = grb.getRecord(2);
			} else {
				ventV = grb.getRecord(1);
				ventU = grb.getRecord(2);
			}

		

			nbDate = grb.getDatesForTypeGridLevel(ventU.getType(), r2,
					ventU.getLevel()).length;

		

			for ( k = 0; k < nbDate; k++) {
				for (i = 0; i < nbx; i++) {
					for ( j = 0; j < nby; j++) {

						uv = new StructureUV(grb.getRecord(
								ventU.getType(),
								r2,
								ventU.getLevel(),
								grb.getDatesForTypeGridLevel(ventU.getType(),
										r2, ventU.getLevel())[k])
								.getValue(i, j), grb.getRecord(
								ventV.getType(),
								r2,
								ventV.getLevel(),
								grb.getDatesForTypeGridLevel(ventV.getType(),
										r2, ventV.getLevel())[k])
								.getValue(i, j));

						list.add(j, uv);
						
						listVitesse.add(j, UtilPrevision.uvToVitesse(uv.get_u(), uv.get_v()));
						System.out.println(UtilPrevision.calculer_Force(listVitesse.get(j)));
						listForce.add(j, UtilPrevision.calculer_Force(listVitesse.get(j)));
					}

					
					
					listUV.put(grb.getDatesForTypeGridLevel(ventU.getType(),
							r2, ventU.getLevel())[l], list);
					mapVitesse.put(grb.getDatesForTypeGridLevel(ventU.getType(),
							r2, ventU.getLevel())[l], listVitesse);
					mapForce.put(grb.getDatesForTypeGridLevel(ventU.getType(),
							r2, ventU.getLevel())[l], listForce);

				}

				l++;
			}

			
		} catch (IOException | NotSupportedException | NoValidGribException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	public HashMap<Date, ArrayList<StructureUV>> getListUV() {
		return listUV;
	}


	public HashMap<Date, ArrayList<Double>> getMapVitesse() {
		return mapVitesse;
	}

	public HashMap<Date, ArrayList<Integer>> getMapForce() {
		return mapForce;
	}



	

}
