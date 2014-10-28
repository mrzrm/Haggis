package Gui;

import java.util.ArrayList;
import java.util.Collections;

import server.Karte;
import server.Deck.CustomComparator;

public class ZugVerifizieren {
	
	public static boolean verify (ArrayList <Karte> zug, ArrayList <Karte> gespielt){

		//zug und gespielte Karten sortieren
//		Collections.sort(zug, new CustomComparator());
//		Collections.sort(gespielt, new CustomComparator());

		//falls erster zug
		if (gespielt == null){
			if(zug.size()== 1){
				System.out.println("einzelne karte gespielt");
				return true;
			}else if ((zug.size() == 2) && (zug.get(0).getWert() == zug.get(1).getWert())){
				System.out.println("paar gespielt");
				return true;
			}else if ((zug.size() == 3) && (zug.get(0).getWert() == zug.get(1).getWert()) && (zug.get(0).getWert() ==zug.get(2).getWert())){
				System.out.println("drilling gespielt");
				return true;
			}else if ((zug.size() == 3) && (zug.get(0).getWert() == zug.get(1).getWert()+1) && (zug.get(1).getWert() == zug.get(2).getWert()+1)){
				System.out.println("strasse");
			}else if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert()) && (zug.get(0).getWert() == zug.get(2).getWert()) && (zug.get(0).getWert() == zug.get(3).getWert())){
				System.out.println("vierling gespielt");
				return true;
			//wert von joker karte muss noch umgewandelt werden
			}else if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert()) && (zug.get(0).getWert() == zug.get(2).getWert()) && (zug.get(0).getWert() == zug.get(3).getWert()) && (zug.get(0).getWert() == zug.get(4).getWert())){
				System.out.println("fuenfling gespielt");
				return true;
			}else if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(1).getWert()) && (zug.get(2).getWert() == zug.get(3).getWert()) && (zug.get(0).getFarbe() == zug.get(1).getFarbe()) && zug.get(2).getFarbe() == zug.get(3).getFarbe()){
				System.out.println("PaarStrasse gespielt");
				return true;
			}
//			else if ((zug.size() == 4) && (zug.get(0).getWert() == zug.get(2).getWert()) && (zug.get(1).getWert() == zug.get(3).getWert()) && (zug.get(0).getFarbe() == zug.get(1).getFarbe()) && zug.get(2).getFarbe() == zug.get(3).getFarbe()){
//				System.out.println("DrillingStrasse gespielt");
//				return true;
//			}
//			else if (){
//				System.out.println("vierlingStrasse gespielt");
//				return true;
//			}else if (){
//				System.out.println("secherstrasse gespielt");
//				return true;
//			}
			else{
				System.out.println("ungültiger Zug");
				return false;
			}
			
		//falls nicht der erste zug
		}else{
			
		}
		
		// sollte später false sein
		return true;
	}

}
