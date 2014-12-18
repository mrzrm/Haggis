/**
 * Diese Klasse erstellt ein Deck aus 36 Spielkarten, mischt sie und verteilt diese auf zwei Arrays.
 * Die Arrays werden anschliessend sortiert. Ebenso werden je 3 Joker erstellt und verteilt.
 *
 * Bugs: keine Bekannt
 *
 * @author       Moritz Leimgrübler, Adrian Immer
 * @version      1.0
 * @see also     Karte, MasterObject
 */
package objekte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;

import objekte.Karte;
import client.Gui;
import client.CustomComparator;

public class Deck implements Serializable {

	public ImageIcon iie02 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen02.jpg"));
	public ImageIcon iie03 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen03.jpg"));
	public ImageIcon iie04 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen04.jpg"));
	public ImageIcon iie05 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen05.jpg"));
	public ImageIcon iie06 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen06.jpg"));
	public ImageIcon iie07 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen07.jpg"));
	public ImageIcon iie08 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen08.jpg"));
	public ImageIcon iie09 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen09.jpg"));
	public ImageIcon iie10 = new ImageIcon(
			Gui.class.getResource("/images/green/gruen10.jpg"));

	public ImageIcon iig02 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau02.jpg"));
	public ImageIcon iig03 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau03.jpg"));
	public ImageIcon iig04 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau04.jpg"));
	public ImageIcon iig05 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau05.jpg"));
	public ImageIcon iig06 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau06.jpg"));
	public ImageIcon iig07 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau07.jpg"));
	public ImageIcon iig08 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau08.jpg"));
	public ImageIcon iig09 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau09.jpg"));
	public ImageIcon iig10 = new ImageIcon(
			Gui.class.getResource("/images/grey/grau10.jpg"));

	public ImageIcon iir02 = new ImageIcon(
			Gui.class.getResource("/images/red/rot02.jpg"));
	public ImageIcon iir03 = new ImageIcon(
			Gui.class.getResource("/images/red/rot03.jpg"));
	public ImageIcon iir04 = new ImageIcon(
			Gui.class.getResource("/images/red/rot04.jpg"));
	public ImageIcon iir05 = new ImageIcon(
			Gui.class.getResource("/images/red/rot05.jpg"));
	public ImageIcon iir06 = new ImageIcon(
			Gui.class.getResource("/images/red/rot06.jpg"));
	public ImageIcon iir07 = new ImageIcon(
			Gui.class.getResource("/images/red/rot07.jpg"));
	public ImageIcon iir08 = new ImageIcon(
			Gui.class.getResource("/images/red/rot08.jpg"));
	public ImageIcon iir09 = new ImageIcon(
			Gui.class.getResource("/images/red/rot09.jpg"));
	public ImageIcon iir10 = new ImageIcon(
			Gui.class.getResource("/images/red/rot10.jpg"));

	public ImageIcon iiy02 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb02.jpg"));
	public ImageIcon iiy03 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb03.jpg"));
	public ImageIcon iiy04 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb04.jpg"));
	public ImageIcon iiy05 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb05.jpg"));
	public ImageIcon iiy06 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb06.jpg"));
	public ImageIcon iiy07 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb07.jpg"));
	public ImageIcon iiy08 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb08.jpg"));
	public ImageIcon iiy09 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb09.jpg"));
	public ImageIcon iiy10 = new ImageIcon(
			Gui.class.getResource("/images/yellow/gelb10.jpg"));

	public ImageIcon iij1 = new ImageIcon(
			Gui.class.getResource("/images/special/Bube.jpg"));
	public ImageIcon iiq1 = new ImageIcon(
			Gui.class.getResource("/images/special/Dame.jpg"));
	public ImageIcon iik1 = new ImageIcon(
			Gui.class.getResource("/images/special/Koenig.jpg"));

	private Karte e02, e03, e04, e05, e06, e07, e08, e09, e10;
	private Karte g02, g03, g04, g05, g06, g07, g08, g09, g10;
	private Karte r02, r03, r04, r05, r06, r07, r08, r09, r10;
	private Karte y02, y03, y04, y05, y06, y07, y08, y09, y10;
	public Karte j1, q1, k1;

	private ArrayList<Karte> kartenDeck = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer1 = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer2 = new ArrayList<Karte>();
	public ArrayList<Karte> jokerPlayer1 = new ArrayList<Karte>();
	public ArrayList<Karte> jokerPlayer2 = new ArrayList<Karte>();
	public ArrayList<Karte> haggis = new ArrayList<Karte>();

	/**
	 * 
	 */
	public Deck() {

		// Grüne Karten erstellen und zur ArrayList hinzufügen
		kartenDeck.add(e02 = new Karte("gruen2", Karte.Farbe.GREEN, 2, 0, iie02));
		kartenDeck.add(e03 = new Karte("gruen3", Karte.Farbe.GREEN, 3, 1, iie03));
		kartenDeck.add(e04 = new Karte("gruen4", Karte.Farbe.GREEN, 4, 0, iie04));
		kartenDeck.add(e05 = new Karte("gruen5", Karte.Farbe.GREEN, 5, 1, iie05));
		kartenDeck.add(e06 = new Karte("gruen6", Karte.Farbe.GREEN, 6, 0, iie06));
		kartenDeck.add(e07 = new Karte("gruen7", Karte.Farbe.GREEN, 7, 1, iie07));
		kartenDeck.add(e08 = new Karte("gruen8", Karte.Farbe.GREEN, 8, 0, iie08));
		kartenDeck.add(e09 = new Karte("gruen9", Karte.Farbe.GREEN, 9, 1, iie09));
		kartenDeck.add(e10 = new Karte("gruen10", Karte.Farbe.GREEN, 10, 0, iie10));

		// Graue Karten erstellen und zur ArrayList hinzufügen
		kartenDeck.add(g02 = new Karte("grau2", Karte.Farbe.GREY, 2, 0, iig02));
		kartenDeck.add(g03 = new Karte("grau3", Karte.Farbe.GREY, 3, 1, iig03));
		kartenDeck.add(g04 = new Karte("grau4", Karte.Farbe.GREY, 4, 0, iig04));
		kartenDeck.add(g05 = new Karte("grau5", Karte.Farbe.GREY, 5, 1, iig05));
		kartenDeck.add(g06 = new Karte("grau6", Karte.Farbe.GREY, 6, 0, iig06));
		kartenDeck.add(g07 = new Karte("grau7", Karte.Farbe.GREY, 7, 1, iig07));
		kartenDeck.add(g08 = new Karte("grau8", Karte.Farbe.GREY, 8, 0, iig08));
		kartenDeck.add(g09 = new Karte("grau9", Karte.Farbe.GREY, 9, 1, iig09));
		kartenDeck.add(g10 = new Karte("grau10", Karte.Farbe.GREY, 10, 0, iig10));

		// Rote Karten erstellen und zur ArrayList hinzufügen
		kartenDeck.add(r02 = new Karte("rot2", Karte.Farbe.RED, 2, 0, iir02));
		kartenDeck.add(r03 = new Karte("rot3", Karte.Farbe.RED, 3, 1, iir03));
		kartenDeck.add(r04 = new Karte("rot4", Karte.Farbe.RED, 4, 0, iir04));
		kartenDeck.add(r05 = new Karte("rot5", Karte.Farbe.RED, 5, 1, iir05));
		kartenDeck.add(r06 = new Karte("rot6", Karte.Farbe.RED, 6, 0, iir06));
		kartenDeck.add(r07 = new Karte("rot7", Karte.Farbe.RED, 7, 1, iir07));
		kartenDeck.add(r08 = new Karte("rot8", Karte.Farbe.RED, 8, 0, iir08));
		kartenDeck.add(r09 = new Karte("rot9", Karte.Farbe.RED, 9, 1, iir09));
		kartenDeck.add(r10 = new Karte("rot10", Karte.Farbe.RED, 10, 0, iir10));

		// Gelbe Karten erstellen und zur ArrayList hinzufügen
		kartenDeck.add(y02 = new Karte("gelb1", Karte.Farbe.YELLOW, 2, 0, iiy02));
		kartenDeck.add(y03 = new Karte("gelb1", Karte.Farbe.YELLOW, 3, 1, iiy03));
		kartenDeck.add(y04 = new Karte("gelb1", Karte.Farbe.YELLOW, 4, 0, iiy04));
		kartenDeck.add(y05 = new Karte("gelb1", Karte.Farbe.YELLOW, 5, 1, iiy05));
		kartenDeck.add(y06 = new Karte("gelb1", Karte.Farbe.YELLOW, 6, 0, iiy06));
		kartenDeck.add(y07 = new Karte("gelb1", Karte.Farbe.YELLOW, 7, 1, iiy07));
		kartenDeck.add(y08 = new Karte("gelb1", Karte.Farbe.YELLOW, 8, 0, iiy08));
		kartenDeck.add(y09 = new Karte("gelb1", Karte.Farbe.YELLOW, 9, 1, iiy09));
		kartenDeck.add(y10 = new Karte("gelb1", Karte.Farbe.YELLOW, 10, 0, iiy10));

	}

	public void shuffleDeck() {

		Collections.shuffle(kartenDeck);

	}

	/**
	 * 
	 */
	public void giveCards() {

		// am besten nochmals Mischen
		this.shuffleDeck();

		for (int j = 0; j < this.kartenDeck.size(); j++) {
			if (j < 14) {
				kartenPlayer1.add(this.kartenDeck.get(j));
			} 
			else if (j < 28){
				kartenPlayer2.add(this.kartenDeck.get(j));
			}
			else {
				haggis.add(this.kartenDeck.get(j));
			}
		}

		// Sorting
		Collections.sort(kartenPlayer1, new CustomComparator());
		Collections.sort(kartenPlayer2, new CustomComparator());

		jokerPlayer1.add(new Karte("bube", Karte.Farbe.JOKER, 11, 2, iij1));
		jokerPlayer1.add(new Karte("dame", Karte.Farbe.JOKER, 12, 3, iiq1));
		jokerPlayer1.add(new Karte("koenig", Karte.Farbe.JOKER, 13, 5, iik1));

		jokerPlayer2.add(new Karte("bube", Karte.Farbe.JOKER, 11, 2, iij1));
		jokerPlayer2.add(new Karte("dame", Karte.Farbe.JOKER, 12, 3, iiq1));
		jokerPlayer2.add(new Karte("koenig", Karte.Farbe.JOKER, 13, 5, iik1));

	}

	public ArrayList<Karte> getHaggis() {
		return haggis;
	}

	public void setHaggis(ArrayList<Karte> haggis) {
		this.haggis = haggis;
	}

	public ArrayList<Karte> getKartenPlayer1() {
		return kartenPlayer1;
	}

	public void setKartenPlayer1(ArrayList<Karte> kartenPlayer1) {
		this.kartenPlayer1 = kartenPlayer1;
	}

	public ArrayList<Karte> getKartenPlayer2() {
		return kartenPlayer2;
	}

	public void setKartenPlayer2(ArrayList<Karte> kartenPlayer2) {
		this.kartenPlayer2 = kartenPlayer2;
	}

	public ArrayList<Karte> getJokerPlayer1() {
		return jokerPlayer1;
	}

	public void setJokerPlayer1(ArrayList<Karte> jokerPlayer1) {
		this.jokerPlayer1 = jokerPlayer1;
	}

	public ArrayList<Karte> getJokerPlayer2() {
		return jokerPlayer2;
	}

	public void setJokerPlayer2(ArrayList<Karte> jokerPlayer2) {
		this.jokerPlayer2 = jokerPlayer2;
	}
	
	public ArrayList<Karte> getKartenDeck() {
		return kartenDeck;
	}

	public void setKartenDeck(ArrayList<Karte> kartenDeck) {
		this.kartenDeck = kartenDeck;
	}
	

//	public static void main(String[] args) {
//
//		 //Neues Deck erstellen
//		 Deck d = new Deck();
//
//		// Karten mischen und verteilen
//		 d.giveCards();
//
//		
//
//		System.out.println("KARTEN SPIELER 1");
//		for (int i = 0; i < d.kartenPlayer1.size(); i++) {
//			System.out.print("Farbe: " + d.kartenPlayer1.get(i).getFarbe()
//					+ " ");
//			System.out.println("Wert: " + d.kartenPlayer1.get(i).getWert());
//
//		}
//
//		for (int i = 0; i < d.jokerPlayer1.size(); i++) {
//			System.out
//					.print("Farbe: " + d.jokerPlayer1.get(i).getFarbe() + " ");
//			System.out.println("Wert: " + d.jokerPlayer1.get(i).getWert());
//		}
//
//		System.out.println("KARTEN SPIELER 2");
//		for (int i = 0; i < d.kartenPlayer2.size(); i++) {
//			System.out.print("Farbe: " + d.kartenPlayer2.get(i).getFarbe()
//					+ " ");
//			System.out.println("Wert: " + d.kartenPlayer2.get(i).getWert());
//
//		}
//
//		for (int i = 0; i < d.jokerPlayer2.size(); i++) {
//			System.out
//					.print("Farbe: " + d.jokerPlayer2.get(i).getFarbe() + " ");
//			System.out.println("Wert: " + d.jokerPlayer2.get(i).getWert());
//
//		}
//	}





//	public class CustomComparator implements Comparator<Karte> {
//		@Override
//		public int compare(Karte k1, Karte k2) {
//			return k1.getWert() - (k2.getWert());
//		}
//	}

}
