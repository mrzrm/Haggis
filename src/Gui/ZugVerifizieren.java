package Gui;

import java.util.ArrayList;
import java.util.Collections;

import server.Karte;
import server.CustomComparator;

public class ZugVerifizieren {

	public static boolean verify(ArrayList<Karte> zug, ArrayList<Karte> gespielt) {

		// zug und gespielte Karten sortieren
		Collections.sort(zug, new CustomComparator());
		// Collections.sort(gespielt, new CustomComparator());
		int counterStrasse = 1;
		int counterPaerchenStrasse = 0;
		int counterDrillingStrasse = 1;

		for (int i = 0; i < zug.size(); i++) {
			System.out.println(zug.get(i).getWert());
			System.out.println(zug.get(i).getFarbe());
		}

		// falls erster zug
		// if (gespielt == null){
		
		//---- einzelne Karte-----
		if (zug.size() == 1) {
			System.out.println("einzelne karte gespielt");
			return true;
		}
		//----Pärchen-----
		if ((zug.size() == 2) && (zug.get(0).getWert() == zug.get(1).getWert())) {
			System.out.println("paar gespielt");
			return true;
		}
		//----Drilling----
		if ((zug.size() == 3) && (zug.get(0).getWert() == zug.get(1).getWert())
				&& (zug.get(0).getWert() == zug.get(2).getWert())) {
			System.out.println("drilling gespielt");
			return true;
		}
		//----Strasse----
		if (zug.size() > 2) {
			for (int i = zug.size() - 1; i > 0; i--) {
				if (zug.get(i).getWert() == zug.get(i - 1).getWert() + 1
						&& zug.get(i).getFarbe() == zug.get(i - 1).getFarbe()) {
					counterStrasse++;
				} else {
					break;
				}
			}
			if (counterStrasse > 2) {
				System.out.println(counterStrasse + "er Strasse gespielt");
				return true;
			}

			else {

			}

		}
		//-----Vierling----
		if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert())
				&& (zug.get(0).getWert() == zug.get(2).getWert())
				&& (zug.get(0).getWert() == zug.get(3).getWert())) {
			System.out.println("vierling gespielt");
			return true;
		}
		
		//-----Pärchenstrasse----
		if (zug.size() >= 4) {
			System.out.println("if paerchen");

			int j = zug.size() - 1;
			for (int i = zug.size() - 1; i > 0; i = i - 2) {;
				if (zug.get(i).getWert() == zug.get(i - 1).getWert()
						&& zug.get(j).getFarbe() == zug.get(j - 2).getFarbe()
						&& zug.get(j).getWert() == zug.get(j - 2).getWert() + 1) {
					counterPaerchenStrasse++;
					j--;
				} else {
					j = zug.size() - 1;
					counterPaerchenStrasse = 1;
					break;
				}
			}
			if (counterPaerchenStrasse > 1) {
				System.out.println(counterPaerchenStrasse
						+ "er Pärchenstrasse gespielt");
				return true;
			}
		}
		
		//-----Drillingstrasse------
		if (zug.size() >= 6) {
			System.out.println("if paerchen");

//			int j = zug.size() - 1;
			for (int i = zug.size() - 1; i > 4; i = i - 3) {
				System.out.println("1. Schlaufe");
				if (	zug.get(i).getWert() == zug.get(i - 1).getWert()
						&& zug.get(i).getWert() == zug.get(i - 2).getWert()
						&& zug.get(i).getFarbe() == zug.get(i - 3).getFarbe()
						&& zug.get(i-1).getFarbe() == zug.get(i - 4).getFarbe()
						&& zug.get(i-2).getWert() == zug.get(i - 5).getWert() + 1) {
					counterDrillingStrasse++;
//					j--;
					System.out.println("counter" + counterDrillingStrasse);
				} else {
//					j = zug.size() - 1;
					counterDrillingStrasse = 1;
					System.out.println("counter wieder 1");
					break;
				}
			}
			if (counterDrillingStrasse > 1) {
				System.out.println(counterDrillingStrasse
						+ "er Drillingsstrasse gespielt");
				return true;
			}
		}
		

		else {
			System.out.println("ungültiger Zug");
			return false;
		}

		// falls nicht der erste zug
		// }else{

		// }

		// sollte später false sein
		return false;
	}

}
