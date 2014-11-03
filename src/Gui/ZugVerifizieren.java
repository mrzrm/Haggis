package Gui;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
			//----Bombe1 (2,5,7,9)-----
			if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9){
				System.out.println("Bombaa");
				Client.m.letzerZug = 8;
				playBomba();
				return true;
			}
			//----Bombe2 (bauer, dame)-----
			if (zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12){
				System.out.println("Bombaa Bauer-Dame");
				Client.m.letzerZug = 9;
				playBomba();
				return true;
			}
			
			//----Bombe3 (bube, könig)-----
			if (zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 13){
				System.out.println("Bombaa bauer-könig");
				Client.m.letzerZug = 10;
				playBomba();
				return true;
			}
			
			//----Bombe4 (dame, könig)-----
			if (zug.size() == 2 && zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13){
				System.out.println("Bombaa dame-könig");
				Client.m.letzerZug = 11;
				playBomba();
				return true;
			}
			
			//----Bombe5 (bauer, dame, könig)-----
			if (zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
				System.out.println("Bombaa bauer-dame-könig");
				Client.m.letzerZug = 12;
				playBomba();
				return true;
			}

			//----Bombe6-----
			if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
					&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
				System.out.println("Bombaaaa");
				Client.m.letzerZug = 13;
				playBomba();
				return true;
			}
			// prüfen ob joker karten gespielt
			if (zug.size() > 1){
				System.out.println("test if");
				for (Karte k: zug){
					System.out.println("test for");
					System.out.println("alle karten:" + k.getWert());
					if (k.getWert() == 11 ){
						JokerValues jvBube = new JokerValues(k.getWert(), k.getFarbe());
						jvBube.setVisible(true);
						System.out.println("wert: " + k.getWert());
					}
					if (k.getWert() == 12 ){
						JokerValues jvDame = new JokerValues(k.getWert(), k.getFarbe());
						jvDame.setVisible(true);
						System.out.println("wert: " + k.getWert());
					}
					if (k.getWert() == 13 ){
						JokerValues jvKoenig = new JokerValues(k.getWert(), k.getFarbe());
						jvKoenig.setVisible(true);
						System.out.println("wert: " + k.getWert());
					}
				}
				return true;
			}
			
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
			if (zug.size() > 2 && zug.get(0).getWert() != 11) {
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
		///////////////////////////////
		// falls nicht der erste zug///
		///////////////////////////////
		}else{
			Collections.sort(gespielt, new CustomComparator());
			//---- bomben prüfen, bomben können nur durch bomben geschlagen werden -----
			//bombe 6 schlägt alles
			if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
					&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
				System.out.println("bombe6 gespielt");
				playBomba();
				return true;
			}// bombe 5 schlägt alles ausser bombe 6 und 5
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12 && zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
				System.out.println("bombe5 gespielt");
				playBomba();
				return true;
			}
			//bombe 4 schlägt alls ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12 && Client.m.letzerZug != 11  && zug.size() == 2 && zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13){
				System.out.println("bombe4 gespielt");
				playBomba();
				return true;
			}
			// bombe 3 schlägt alles ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12 && Client.m.letzerZug != 11 && Client.m.letzerZug != 10 && zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 13){
				System.out.println("bombe3 gespielt");
				playBomba();
				return true;
			}
			//bombe 2 schlägt alles ausser bombe 6, 5, 4, 3 und 2
			if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12 && Client.m.letzerZug != 11 && Client.m.letzerZug != 10 && Client.m.letzerZug != 9 && zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12){
				System.out.println("bombe2 gespielt");
				playBomba();
				return true;
			}
			//bombe 1 schlägt alles ausser bombe 6, 5, 4, 3, 2 und 1
			if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12 && Client.m.letzerZug != 11 && Client.m.letzerZug != 10 && Client.m.letzerZug != 9 && Client.m.letzerZug != 8 && zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9){
				System.out.println("bombe1 gespielt");
				playBomba();
				return true;
			}
			
			// prüfen ob joker karten gespielt
			else if (zug.size() > 1){
				System.out.println("test if");
				for (Karte k: zug){
					System.out.println("test for");
					System.out.println("alle karten:" + k.getWert());
					if (k.getWert() == 11 ){
						JokerValues jvBube = new JokerValues(k.getWert(), k.getFarbe());
						jvBube.setVisible(true);
						System.out.println("zugverifizieren, wert: " + k.getWert());
					}
					if (k.getWert() == 12 ){
						JokerValues jvDame = new JokerValues(k.getWert(), k.getFarbe());
						jvDame.setVisible(true);
						System.out.println("zugverifizieren, wert: " + k.getWert());
					}
					if (k.getWert() == 13 ){
						JokerValues jvKoenig = new JokerValues(k.getWert(), k.getFarbe());
						jvKoenig.setVisible(true);
						System.out.println("zugverifizieren, wert: " + k.getWert());
					}
				}
				return true;
			}
			
			//---- einzelne Karte-----
			else if (Client.m.letzerZug == 1){
				if (zug.size() == 1 && zug.get(0).getWert() > gespielt.get(0).getWert()) {
					System.out.println("einzelne karte gespielt");
					return true;
				}
			}
			//----Pärchen-----
			else if (Client.m.letzerZug == 2){
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
					System.out.println(j);
					for (int i = zug.size() - 1; i > 0; i = i - 2) {
						if (zug.get(i).getWert() == zug.get(i - 1).getWert()
								&& zug.get(j).getFarbe() == zug.get(j - 2).getFarbe()
								&& zug.get(j).getWert() == zug.get(j - 2).getWert() + 1) {
							counterPaerchenStrasse++;
							j--;
						}else{
							j = zug.size() - 1;
							counterPaerchenStrasse = 1;
							break;
						}
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
//			//----Bombe1------
//			else if (Client.m.letzerZug == 8){
//				if (zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12){
//					System.out.println("bombe2 gespielt");
//					return true;
//				}else if (zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 13){
//					System.out.println("bombe3 gespielt");
//					return true;
//				}else if (zug.size() == 2 && zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13){
//					System.out.println("bombe4 gespielt");
//					return true;
//				}else if (zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
//					System.out.println("bombe5 gespielt");
//					return true;
//				}else if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
//						&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
//					System.out.println("bombe6 gespielt");
//					return true;
//				}else{
//					return false;
//				}
//			}
//			//----Bombe2------
//			else if (Client.m.letzerZug == 9){
//				if (zug.size() == 2 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 13){
//					System.out.println("bombe3 gespielt");
//					return true;
//				}else if (zug.size() == 2 && zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13){
//					System.out.println("bombe4 gespielt");
//					return true;
//				}else if (zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
//					System.out.println("bombe5 gespielt");
//					return true;
//				}else if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
//						&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
//					System.out.println("bombe6 gespielt");
//					return true;
//				}else{
//					return false;
//				}
//			}
//			//----Bombe3------
//			else if (Client.m.letzerZug == 10){
//				if (zug.size() == 2 && zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13){
//					System.out.println("bombe4 gespielt");
//					return true;
//				}else if (zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
//					System.out.println("bombe5 gespielt");
//					return true;
//				}else if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
//						&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
//					System.out.println("bombe6 gespielt");
//					return true;
//				}else{
//					return false;
//				}
//			}
//			//----Bombe4------
//			else if (Client.m.letzerZug == 11){
//				if (zug.size() == 3 && zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13){
//					System.out.println("bombe5 gespielt");
//					return true;
//				}else if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
//						&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
//					System.out.println("bombe6 gespielt");
//					return true;
//				}else{
//					return false;
//				}
//			}
//			//----Bombe5------
//			else if (Client.m.letzerZug == 12){
//				if (zug.size() == 4 && zug.get(0).getWert() == 3 && zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7 && zug.get(3).getWert() == 9
//						&& zug.get(0).getFarbe() == zug.get(1).getFarbe() && zug.get(0).getFarbe() == zug.get(2).getFarbe() && zug.get(0).getFarbe() == zug.get(3).getFarbe()){
//					System.out.println("bombe6 gespielt");
//					return true;
//				}else{
//					return false;
//				}
//			}
//
//			else {
//				return false;
//			}
		}
		return false;
	}
	
	public static void playBomba() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/bomba.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}