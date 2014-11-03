package Gui;

import java.util.ArrayList;
import java.util.Collections;

import server.CustomComparator;
import server.Karte;

public class BombeVerifizieren {

	public static boolean verifyBomb(ArrayList<Karte> zug, ArrayList<Karte> gespielt) {

		// falls erster zug
		if (gespielt == null || gespielt.size() == 0) {
			return true;
		}
		// falls jemand schon gespielt hat
		else {
			Collections.sort(gespielt, new CustomComparator());
			// ---- bomben prüfen, bomben können nur durch bomben geschlagen
			// werden -----
			// bombe 6 schlägt alles
			if (zug.size() == 4 && zug.get(0).getWert() == 3
					&& zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7
					&& zug.get(3).getWert() == 9
					&& zug.get(0).getFarbe() == zug.get(1).getFarbe()
					&& zug.get(0).getFarbe() == zug.get(2).getFarbe()
					&& zug.get(0).getFarbe() == zug.get(3).getFarbe()) {
				System.out.println("bombe6 gespielt");
				// Gui.playBomba();
				return true;
			}// bombe 5 schlägt alles ausser bombe 6 und 5
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& zug.size() == 3 && zug.get(0).getWert() == 11
					&& zug.get(1).getWert() == 12 && zug.get(2).getWert() == 13) {
				System.out.println("bombe5 gespielt");
				// Gui.playBomba();
				return true;
			}
			// bombe 4 schlägt alls ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && zug.size() == 2
					&& zug.get(0).getWert() == 12 && zug.get(1).getWert() == 13) {
				System.out.println("bombe4 gespielt");
				// Gui.playBomba();
				return true;
			}
			// bombe 3 schlägt alles ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && Client.m.letzerZug != 10
					&& zug.size() == 2 && zug.get(0).getWert() == 11
					&& zug.get(1).getWert() == 13) {
				System.out.println("bombe3 gespielt");
				// Gui.playBomba();
				return true;
			}
			// bombe 2 schlägt alles ausser bombe 6, 5, 4, 3 und 2
			if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && Client.m.letzerZug != 10
					&& Client.m.letzerZug != 9 && zug.size() == 2
					&& zug.get(0).getWert() == 11 && zug.get(1).getWert() == 12) {
				System.out.println("bombe2 gespielt");
				// Gui.playBomba();
				return true;
			}
			// bombe 1 schlägt alles ausser bombe 6, 5, 4, 3, 2 und 1
			if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && Client.m.letzerZug != 10
					&& Client.m.letzerZug != 9 && Client.m.letzerZug != 8
					&& zug.size() == 4 && zug.get(0).getWert() == 3
					&& zug.get(1).getWert() == 5 && zug.get(2).getWert() == 7
					&& zug.get(3).getWert() == 9) {
				System.out.println("bombe1 gespielt");
				// Gui.playBomba();
				return true;
			}
		}
		return false;
	}

}
