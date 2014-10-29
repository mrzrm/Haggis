package Gui;

import java.util.ArrayList;
import java.util.Collections;

import server.Karte;
import server.CustomComparator;

public class ZugVerifizieren {

	public static boolean verify(ArrayList<Karte> zug, ArrayList<Karte> gespielt) {

		// zug sortieren
		Collections.sort(zug, new CustomComparator());
		int counterStrasse = 1;
		int counterPaerchenStrasse = 0;
		int counterDrillingStrasse = 1;

		for (int i = 0; i < zug.size(); i++) {
			System.out.println(zug.get(i).getWert());
			System.out.println(zug.get(i).getFarbe());
		}

		// falls erster zug
		if (gespielt == null || gespielt.size() == 0){

			//---- einzelne Karte-----
			if (zug.size() == 1) {
				System.out.println("einzelne karte gespielt");
				Client.m.letzerZug = 1;
				return true;
			}
			//----Pärchen-----
			if ((zug.size() == 2) && (zug.get(0).getWert() == zug.get(1).getWert())) {
				System.out.println("paar gespielt");
				Client.m.letzerZug = 2;
				return true;
			}
			//----Drilling----
			if ((zug.size() == 3) && (zug.get(0).getWert() == zug.get(1).getWert())
					&& (zug.get(0).getWert() == zug.get(2).getWert())) {
				System.out.println("drilling gespielt");
				Client.m.letzerZug = 3;
				return true;
			}
			//-----Vierling----
			if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert())
					&& (zug.get(0).getWert() == zug.get(2).getWert())
					&& (zug.get(0).getWert() == zug.get(3).getWert())) {
				System.out.println("vierling gespielt");
				Client.m.letzerZug = 4;
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
					Client.m.letzerZug = 5;
					return true;
				}
				else {
				}
			}

			//-----Pärchenstrasse----
			if (zug.size() >= 4) {
				System.out.println("if paerchen");

				int j = zug.size() - 1;
				for (int i = zug.size() - 1; i > 0; i = i - 2) {
					if (zug.get(i).getWert() == zug.get(i - 1).getWert()
							&& zug.get(j).getFarbe() == zug.get(j - 2).getFarbe()
							&& zug.get(j).getWert() == zug.get(j - 2).getWert() + 1) {
						counterPaerchenStrasse++;
						j--;
					} 
					else {
						j = zug.size() - 1;
						counterPaerchenStrasse = 1;
						break;
					}
				}
				if (counterPaerchenStrasse > 1) {
					System.out.println(counterPaerchenStrasse
							+ "er Pärchenstrasse gespielt");
					Client.m.letzerZug = 6;
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
					Client.m.letzerZug = 7;
					return true;
				}
			}


			else {
				System.out.println("ungültiger Zug");
				return false;
			}

		// falls nicht der erste zug
		}else{
			 Collections.sort(gespielt, new CustomComparator());
			//---- einzelne Karte-----
			if (Client.m.letzerZug == 1){
				if (zug.size() == 1 && zug.get(0).getWert() > gespielt.get(0).getWert()) {
					System.out.println("einzelne karte gespielt");
					return true;
				}
			}
			//----Pärchen-----
			if (Client.m.letzerZug == 2){
				if (zug.size() == 2 && zug.get(0).getWert() > gespielt.get(0).getWert() && zug.get(0).getWert() == zug.get(1).getWert()) {
				System.out.println("paar gespielt");
				return true;
				}
			}
			//----Drilling----
			else if (Client.m.letzerZug == 3){
				if (zug.size() == 3 && zug.get(0).getWert() > gespielt.get(0).getWert() && zug.get(0).getWert() == zug.get(1).getWert()
					&& zug.get(0).getWert() == zug.get(2).getWert()) {
					System.out.println("drilling gespielt");
					return true;
				}
			}
			//-----Vierling----
			else if (Client.m.letzerZug == 4){
				if (zug.size() == 4 && zug.get(0).getWert() > gespielt.get(0).getWert() && zug.get(0).getWert() == zug.get(1).getWert()
					&& zug.get(0).getWert() == zug.get(2).getWert() &&  zug.get(0).getWert() == zug.get(3).getWert()) {
					System.out.println("vierling gespielt");
					return true;
				}
			}
			//----Strasse----
			else if (Client.m.letzerZug == 5){
				if (zug.size() > 2 && zug.get(0).getWert() > gespielt.get(0).getWert()) {
					for (int i = zug.size() - 1; i > 0; i--) {
						if (zug.get(i).getWert() == zug.get(i - 1).getWert() + 1
								&& zug.get(i).getFarbe() == zug.get(i - 1).getFarbe()) {
							counterStrasse++;
						}
						else{
							break;
						}
					}
					if (counterStrasse > 2) {
						System.out.println(counterStrasse + "er Strasse gespielt");
						return true;
					}
					else{
					}
				}
			}
			//-----Pärchenstrasse----
			else if (Client.m.letzerZug == 6){
				if (zug.size() >= 4 && zug.get(0).getWert() > gespielt.get(0).getWert()) {
					int j = zug.size() - 1;
					for (int i = zug.size() - 1; i > 0; i = i - 2) {
						if (zug.get(i).getWert() == zug.get(i - 1).getWert()
								&& zug.get(j).getFarbe() == zug.get(j - 2).getFarbe()
								&& zug.get(j).getWert() == zug.get(j - 2).getWert() + 1) {
							counterPaerchenStrasse++;
							j--;
						}
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
			else if (Client.m.letzerZug == 7){
				if (zug.size() >= 6 && zug.get(0).getWert() > gespielt.get(0).getWert()) {
					for (int i = zug.size() - 1; i > 4; i = i - 3) {
						if (	zug.get(i).getWert() == zug.get(i - 1).getWert()
								&& zug.get(i).getWert() == zug.get(i - 2).getWert()
								&& zug.get(i).getFarbe() == zug.get(i - 3).getFarbe()
								&& zug.get(i-1).getFarbe() == zug.get(i - 4).getFarbe()
								&& zug.get(i-2).getWert() == zug.get(i - 5).getWert() + 1) {
							counterDrillingStrasse++;
							System.out.println("counter" + counterDrillingStrasse);
						} else {
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
			}
			else {
				return false;
			}
		}
		return false;
	}
}