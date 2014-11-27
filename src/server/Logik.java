package server;

import java.util.ArrayList;

import objekte.Karte;
import objekte.MasterObject;
import client.Client;

public class Logik {

	static int punkteBisSieg = 250;

	public static MasterObject Kontrolle(MasterObject m) {

		// Falls ein Spieler keine Karten mehr hat, neue Runde starten
		if (m.getKartenPlayer1().size() == 0
				&& isJokerEmpty(m.getKartenJoker1())
				|| m.getKartenPlayer2().size() == 0
				&& isJokerEmpty(m.getKartenJoker2())) {
			if (m.getKartenPlayer1().size() == 0) {

				Server.display(m.users.get(0).getName()
						+ " hat Runde gewonnen! Karten werden neu verteilt...");

				// Punkte bis letze Karte
				int tmpPunkte = m.users.get(0).getPunkte();
				tmpPunkte += m.getPunkteBisStich();

				// Zusätzlich fünf Punkte für jede Karte des Gegners
				int tmpKartenX5 = m.getKartenPlayer2().size() * 5;
				tmpPunkte += tmpKartenX5;

				// Punkte setzen
				m.users.get(0).setPunkte(tmpPunkte);

				// pukteBisStich reseten
				m.setPunkteBisStich(0);

				// Karten neu verteilen (neu verteilt auf true)
				// ServerThread.neuRunde();
				m.neuRunde();

				// am Zug setzen
				m.setAmZug(0);
			} else if (m.getKartenPlayer2().size() == 0) {

				Server.display(m.users.get(1).getName()
						+ " hat Runde gewonnen! Karten werden neu verteilt...");

				// Punkte bis letze Karte
				int tmpPunkte = m.users.get(1).getPunkte();
				tmpPunkte += m.getPunkteBisStich();

				// Zusätzlich fünf Punkte für jede Karte des Gegners
				int tmpKartenX5 = m.getKartenPlayer1().size() * 5;
				tmpPunkte += tmpKartenX5;

				// Punkte setzen
				m.users.get(1).setPunkte(tmpPunkte);

				// pukteBisStich reseten
				m.setPunkteBisStich(0);

				// Karten neu verteilen (neu verteilt auf true)
				// ServerThread.neuRunde();
				m.neuRunde();

				// am Zug setzen
				m.setAmZug(1);

			}

			// Checken, ob Player1 bereits gewonnen hat
			if (m.users.get(0).getPunkte() >= punkteBisSieg) {
				m.setSieger(1);
				Server.display(m.users.get(0).getName()
						+ " hat das Spiel Gewonnen!");
			}
			// Checken, ob Player2 bereits gewonnen hat
			else if (m.users.get(1).getPunkte() >= punkteBisSieg) {
				m.setSieger(2);
				Server.display(m.users.get(1).getName()
						+ " hat das Spiel Gewonnen!");
			}

		}

		// Wenn nächster Spieler am Zug
		else {

			// Falls Spieler passt
			if (m.isPasst()) {
				m.setPasst(false);

				

				// punkteBisStich dem Spieler der nicht gepasst hat hinzu
				// addieren
				int bekommtPunkte = 0;
				if (isBomb(m.gespielteKarten)) {
					if (m.getAmZug() == 1) {
						bekommtPunkte = 1;
					} else {
						bekommtPunkte = 0;
					}
				} else {
					if (m.getAmZug() == 1) {
						bekommtPunkte = 0;
					} else {
						bekommtPunkte = 1;
					}
				}
				int tPunkte = m.users.get(bekommtPunkte).getPunkte();
				tPunkte += m.getPunkteBisStich();
				m.users.get(bekommtPunkte).setPunkte(tPunkte);

				// pukteBisStich reseten
				m.setPunkteBisStich(0);
				
				// Spielfeld löschen
				m.gespielteKarten.clear();

				// Konsolenausgabe
				Server.display(m.users.get(m.getAmZug()).getName()
						+ " hat gepasst.");
			}

			// Wenn Spieler Karten ausspielt
			else {

				Server.display(m.users.get(m.getAmZug()).getName()
						+ " hat gespielt:");
				for (int r = 0; r < m.gespielteKarten.size(); r++) {
					System.out.print("Farbe: "
							+ m.gespielteKarten.get(r).getFarbe());
					System.out.println(" Wert: "
							+ m.gespielteKarten.get(r).getWert());
					Server.display(m.gespielteKarten.get(r).getFarbe() + " "
							+ m.gespielteKarten.get(r).getWert());
				}

			}

			// // Testausgabe joker
			// for (Karte k: m.kartenJoker1){
			// if(k != null){
			// System.out.println("Joker 1: Wert: " + k.getWert());
			// }
			// }
			// for (Karte k: m.kartenJoker2){
			// if(k != null){
			// System.out.println("Joker 2: Wert: " + k.getWert());
			// }
			// }

			// Den Spieler der am Zug ist wechseln
			if (m.getAmZug() == 1) {
				m.setAmZug(0);
			} else {
				m.setAmZug(1);
			}
			Server.display(m.users.get(m.getAmZug()).getName() + " ist am Zug.");

		}
		System.out.println("Logik.java bevor return- neu verteilt: "
				+ m.isNeuVerteilt());
		return m;
	}

	private static boolean isBomb(ArrayList<Karte> zug) {
		// ----Bombe6 (3,5,7,9) gleiche Farbe-----
		if (zug.size() == 4 && zug.get(0).getWert() == 3
				&& zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7
				&& zug.get(3).getWert() == 9
				&& zug.get(0).getFarbe() == zug.get(1).getFarbe()
				&& zug.get(0).getFarbe() == zug.get(2).getFarbe()
				&& zug.get(0).getFarbe() == zug.get(3).getFarbe()) {
			System.out.println("Bombaaaa 3,5,7,9 one color");
			return true;
		}
		// ----Bombe5 (bauer, dame, könig)-----
		if (zug.size() == 3 && zug.get(0).getWert() == 11
				&& zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13) {
			System.out.println("Bombaa bauer-dame-könig");
			return true;
		}
		// ----Bombe4 (dame, könig)-----
		if (zug.size() == 2 && zug.get(0).getWert() == 12
				&& zug.get(1).getWert() == 13) {
			System.out.println("Bombaa dame-könig");
			return true;
		}
		// ----Bombe3 (bube, könig)-----
		if (zug.size() == 2 && zug.get(0).getWert() == 11
				&& zug.get(1).getWert() == 13) {
			System.out.println("Bombaa bauer-könig");
			return true;
		}
		// ----Bombe2 (bauer, dame)-----
		if (zug.size() == 2 && zug.get(0).getWert() == 11
				&& zug.get(1).getWert() == 12) {
			System.out.println("Bombaa Bauer-Dame");
			return true;
		}
		// ----Bombe1 (3,5,7,9)-----
		if (zug.size() == 4 && zug.get(0).getWert() == 3
				&& zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7
				&& zug.get(3).getWert() == 9) {
			System.out.println("Bombaa");
			return true;
		}
		return false;
	}

	private static boolean isJokerEmpty(Karte[] kartenJoker) {

		for (int g = 0; g < kartenJoker.length; g++) {
			if (kartenJoker[g] != null) {
				return false;
			}
		}

		return true;
	}
}
