package server;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import server.Karte;
import Gui.Gui;

public class Deck {

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
			Gui.class.getResource("/images/special/K�nig.jpg"));

	private Karte e02, e03, e04, e05, e06, e07, e08, e09, e10;
	private Karte g02, g03, g04, g05, g06, g07, g08, g09, g10;
	private Karte r02, r03, r04, r05, r06, r07, r08, r09, r10;
	private Karte y02, y03, y04, y05, y06, y07, y08, y09, y10;
	private Karte j1, q1, k1;

	private ArrayList<Karte> kartenDeck = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer1 = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer2 = new ArrayList<Karte>();
	public ArrayList<Karte> jokerPlayer1 = new ArrayList<Karte>();
	public ArrayList<Karte> jokerPlayer2 = new ArrayList<Karte>();

	public Deck() {

		// Gr�ne Karten erstellen und zur ArrayList hinzuf�gen
		kartenDeck.add(e02 = new Karte(Karte.Farbe.GREEN, 2, iie02));
		kartenDeck.add(e03 = new Karte(Karte.Farbe.GREEN, 3, iie03));
		kartenDeck.add(e04 = new Karte(Karte.Farbe.GREEN, 4, iie04));
		kartenDeck.add(e05 = new Karte(Karte.Farbe.GREEN, 5, iie05));
		kartenDeck.add(e06 = new Karte(Karte.Farbe.GREEN, 6, iie06));
		kartenDeck.add(e07 = new Karte(Karte.Farbe.GREEN, 7, iie07));
		kartenDeck.add(e08 = new Karte(Karte.Farbe.GREEN, 8, iie08));
		kartenDeck.add(e09 = new Karte(Karte.Farbe.GREEN, 9, iie09));
		kartenDeck.add(e10 = new Karte(Karte.Farbe.GREEN, 10, iie10));

		// Graue Karten erstellen und zur ArrayList hinzuf�gen
		kartenDeck.add(g02 = new Karte(Karte.Farbe.GREY, 2, iig02));
		kartenDeck.add(g03 = new Karte(Karte.Farbe.GREY, 3, iig03));
		kartenDeck.add(g04 = new Karte(Karte.Farbe.GREY, 4, iig04));
		kartenDeck.add(g05 = new Karte(Karte.Farbe.GREY, 5, iig05));
		kartenDeck.add(g06 = new Karte(Karte.Farbe.GREY, 6, iig06));
		kartenDeck.add(g07 = new Karte(Karte.Farbe.GREY, 7, iig07));
		kartenDeck.add(g08 = new Karte(Karte.Farbe.GREY, 8, iig08));
		kartenDeck.add(g09 = new Karte(Karte.Farbe.GREY, 9, iig09));
		kartenDeck.add(g10 = new Karte(Karte.Farbe.GREY, 10, iig10));

		// Rote Karten erstellen und zur ArrayList hinzuf�gen
		kartenDeck.add(r02 = new Karte(Karte.Farbe.RED, 2, iir02));
		kartenDeck.add(r03 = new Karte(Karte.Farbe.RED, 3, iir03));
		kartenDeck.add(r04 = new Karte(Karte.Farbe.RED, 4, iir04));
		kartenDeck.add(r05 = new Karte(Karte.Farbe.RED, 5, iir05));
		kartenDeck.add(r06 = new Karte(Karte.Farbe.RED, 6, iir06));
		kartenDeck.add(r07 = new Karte(Karte.Farbe.RED, 7, iir07));
		kartenDeck.add(r08 = new Karte(Karte.Farbe.RED, 8, iir08));
		kartenDeck.add(r09 = new Karte(Karte.Farbe.RED, 9, iir09));
		kartenDeck.add(r10 = new Karte(Karte.Farbe.RED, 10, iir10));

		// Gelbe Karten erstellen und zur ArrayList hinzuf�gen
		kartenDeck.add(y02 = new Karte(Karte.Farbe.YELLOW, 2, iiy02));
		kartenDeck.add(y03 = new Karte(Karte.Farbe.YELLOW, 3, iiy03));
		kartenDeck.add(y04 = new Karte(Karte.Farbe.YELLOW, 4, iiy04));
		kartenDeck.add(y05 = new Karte(Karte.Farbe.YELLOW, 5, iiy05));
		kartenDeck.add(y06 = new Karte(Karte.Farbe.YELLOW, 6, iiy06));
		kartenDeck.add(y07 = new Karte(Karte.Farbe.YELLOW, 7, iiy07));
		kartenDeck.add(y08 = new Karte(Karte.Farbe.YELLOW, 8, iiy08));
		kartenDeck.add(y09 = new Karte(Karte.Farbe.YELLOW, 9, iiy09));
		kartenDeck.add(y10 = new Karte(Karte.Farbe.YELLOW, 10, iiy10));


	}

	public void shuffleDeck() {

		Collections.shuffle(kartenDeck);

	}

	public void giveCards() {

		// am besten nochmals Mischen
		this.shuffleDeck();

		for (int j = 0; j < 28; j++) {
			if (j < 14) {
				kartenPlayer1.add(this.kartenDeck.get(j));
			} else {
				kartenPlayer2.add(this.kartenDeck.get(j));
			}
		}

		jokerPlayer1.add(new Karte(Karte.Farbe.JOKER, 0, iij1));
		jokerPlayer1.add(new Karte(Karte.Farbe.JOKER, 1, iiq1));
		jokerPlayer1.add(new Karte(Karte.Farbe.JOKER, 2, iik1));

		jokerPlayer2.add(new Karte(Karte.Farbe.JOKER, 0, iij1));
		jokerPlayer2.add(new Karte(Karte.Farbe.JOKER, 1, iiq1));
		jokerPlayer2.add(new Karte(Karte.Farbe.JOKER, 2, iik1));

	}

	public static void main(String[] args) {

		// Neues Deck erstellen
		Deck d = new Deck();

		// Karten mischen und verteilen
		d.giveCards();

		/*
		 * for(int i = 0; i < d.kartendeck.size(); i++){
		 * System.out.print("Farbe: " + d.kartendeck.get(i).getFarbe() + " ");
		 * System.out.println("Wert: " + d.kartendeck.get(i).getWert());
		 * 
		 * }
		 */

		System.out.println("KARTEN SPIELER 1");
		for (int i = 0; i < d.kartenPlayer1.size(); i++) {
			System.out.print("Farbe: " + d.kartenPlayer1.get(i).getFarbe()
					+ " ");
			System.out.println("Wert: " + d.kartenPlayer1.get(i).getWert());

		}

		for (int i = 0; i < d.jokerPlayer1.size(); i++) {
			System.out
					.print("Farbe: " + d.jokerPlayer1.get(i).getFarbe() + " ");
			System.out.println("Wert: " + d.jokerPlayer1.get(i).getWert());
		}

		System.out.println("KARTEN SPIELER 2");
		for (int i = 0; i < d.kartenPlayer2.size(); i++) {
			System.out.print("Farbe: " + d.kartenPlayer2.get(i).getFarbe()
					+ " ");
			System.out.println("Wert: " + d.kartenPlayer2.get(i).getWert());

		}

		for (int i = 0; i < d.jokerPlayer2.size(); i++) {
			System.out
					.print("Farbe: " + d.jokerPlayer2.get(i).getFarbe() + " ");
			System.out.println("Wert: " + d.jokerPlayer2.get(i).getWert());

		}
	}

}