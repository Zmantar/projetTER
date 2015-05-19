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
	ArrayList<StructureUV> list;
	ArrayList<Double> listVitesse;
	ArrayList<Integer> listForce;
	StructureUV uv;
	int nbDate;
	
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

			list = new ArrayList<StructureUV>();
			listVitesse = new ArrayList<Double>();
			listForce = new ArrayList<Integer>();

			nbDate = grb.getDatesForTypeGridLevel(ventU.getType(), r2,
					ventU.getLevel()).length;

			int  l = 0;

			for (int k = 0; k < nbDate; k++) {
				for (int i = 0; i < nbx; i++) {
					for (int j = 0; j < nby; j++) {

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
						
						listVitesse.add(j, Conversion.uvToVitesse(uv.get_u(), uv.get_v()));
						System.out.println(Conversion.calculer_Force(listVitesse.get(j)));
						listForce.add(j, Conversion.calculer_Force(listVitesse.get(j)));
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
