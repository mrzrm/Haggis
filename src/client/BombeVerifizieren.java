/**
 * Diese Klasse übeprüft, ob der zu Spielende Zug eine Bombe ist. Falls ja, wird eine Audiodatei abgespiet.
 *
 * Bugs: keine Bekannt
 *
 * @author       Moritz Leimgrübler
 * @version      1.0
 * @see also     Login, Gui
 */
package client;

import java.awt.MediaTracker;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import objekte.Karte;
import client.CustomComparator;

public class BombeVerifizieren {

	public static boolean verifyBomb(ArrayList<Karte> zug, ArrayList<Karte> gespielt) {

		// falls erster zug
		if (gespielt == null || gespielt.size() == 0) {
			Client.m.letzerZug = Client.m.bombe;
			playBomba();
			return true;
		}
		// falls jemand schon gespielt hat
		else {
			System.out.println(Client.m.letzerZug);
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
				Client.m.letzerZug = 13;
				playBomba();
				// Gui.playBomba();
				return true;
			}// bombe 5 schlägt alles ausser bombe 6 und 5
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& zug.size() == 3 && zug.get(0).getName().equals("bube")
					&& zug.get(1).getName().equals("dame") && zug.get(2).getName().equals("koenig")) {
				System.out.println("bombe5 gespielt");
				playBomba();
				// Gui.playBomba();
				Client.m.letzerZug = 12;
				return true;
			}
			// bombe 4 schlägt alls ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && zug.size() == 2
					&& zug.get(0).getName().equals("dame") && zug.get(1).getName().equals("koenig")) {
				System.out.println("bombe4 gespielt");
				Client.m.letzerZug = 11;
				playBomba();
				// Gui.playBomba();
				return true;
			}
			// bombe 3 schlägt alles ausser bombe 6, 5 und 4
			else if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && Client.m.letzerZug != 10
					&& zug.size() == 2 && zug.get(0).getName().equals("bube")
					&& zug.get(1).getName().equals("koenig")) {
				System.out.println("bombe3 gespielt");
				Client.m.letzerZug = 10;
				// Gui.playBomba();
				playBomba();
				return true;
			}
			// bombe 2 schlägt alles ausser bombe 6, 5, 4, 3 und 2
			if (Client.m.letzerZug != 13 && Client.m.letzerZug != 12
					&& Client.m.letzerZug != 11 && Client.m.letzerZug != 10
					&& Client.m.letzerZug != 9 && zug.size() == 2
					&& zug.get(0).getName().equals("bube") && zug.get(1).getName().equals("dame")) {
				System.out.println("bombe2 gespielt");
				Client.m.letzerZug = 9;
				// Gui.playBomba();
				playBomba();
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
				Client.m.letzerZug = 8;
				playBomba();
				return true;
			}
		}
		return false;
	}
	public static void playBomba() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/audio/bomba/bomba.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}

}
