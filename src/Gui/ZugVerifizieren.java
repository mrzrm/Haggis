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

		for (int i = 0; i < zug.size(); i++) {
			System.out.println(zug.get(i).getWert());
			System.out.println(zug.get(i).getFarbe());
		}

		// falls erster zug
		// if (gespielt == null){
		if (zug.size() == 1) {
			System.out.println("einzelne karte gespielt");
			return true;
		}
		if ((zug.size() == 2) && (zug.get(0).getWert() == zug.get(1).getWert())) {
			System.out.println("paar gespielt");
			return true;
		}
		if ((zug.size() == 3) && (zug.get(0).getWert() == zug.get(1).getWert())
				&& (zug.get(0).getWert() == zug.get(2).getWert())) {
			System.out.println("drilling gespielt");
			return true;
		}
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
		if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert())
				&& (zug.get(0).getWert() == zug.get(2).getWert())
				&& (zug.get(0).getWert() == zug.get(3).getWert())) {
			System.out.println("vierling gespielt");
			return true;
			// wert von joker karte muss noch umgewandelt werden
		}
		// else if ((zug.size() == 4) && (zug.get(0).getWert() ==
		// zug.get(1).getWert()) && (zug.get(0).getWert() ==
		// zug.get(2).getWert()) && (zug.get(0).getWert() ==
		// zug.get(3).getWert()) && (zug.get(0).getWert() ==
		// zug.get(4).getWert())){
		// System.out.println("fuenfling gespielt");
		// return true;
		// }
		if (zug.size() >= 4) {
			System.out.println("if paerchen");

			int j = zug.size() - 1;
			for (int i = zug.size() - 1; i > 0; i = i - 2) {
				System.out.println("1. Schlaufe");
				if ((zug.get(i).getWert() == zug.get(i - 1).getWert())
						&& zug.get(j).getFarbe() == zug.get(j - 2).getFarbe()
						&& zug.get(j).getWert() == zug.get(j - 2).getWert() + 1) {
					counterPaerchenStrasse++;
					j--;
					System.out.println("counter" + counterPaerchenStrasse);
				} else {
					j = zug.size() - 1;
					counterPaerchenStrasse = 1;
					System.out.println("counter wieder 1");
					break;
				}
			}
			if (counterPaerchenStrasse > 1) {
				System.out.println(counterPaerchenStrasse
						+ "er Pärchenstrasse gespielt");
				return true;
			}

			else {

			}

		}
		// else if ((zug.size() == 4) && (zug.get(0).getWert() ==
		// zug.get(2).getWert()) && (zug.get(1).getWert() ==
		// zug.get(3).getWert()) && (zug.get(0).getFarbe() ==
		// zug.get(1).getFarbe()) && zug.get(2).getFarbe() ==
		// zug.get(3).getFarbe()){
		// System.out.println("DrillingStrasse gespielt");
		// return true;
		// }
		// else if (){
		// System.out.println("vierlingStrasse gespielt");
		// return true;
		// }else if (){
		// System.out.println("secherstrasse gespielt");
		// return true;
		// }
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
