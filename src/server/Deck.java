package server;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import server.Karte;
import Gui.Gui;

public class Deck {
	
	public ImageIcon iie02 = new ImageIcon(Gui.class.getResource("/images/green/gruen02.jpg"));
	public ImageIcon iie03 = new ImageIcon(Gui.class.getResource("/images/green/gruen03.jpg"));
	public ImageIcon iie04 = new ImageIcon(Gui.class.getResource("/images/green/gruen04.jpg"));
	public ImageIcon iie05 = new ImageIcon(Gui.class.getResource("/images/green/gruen05.jpg"));
	public ImageIcon iie06 = new ImageIcon(Gui.class.getResource("/images/green/gruen06.jpg"));
	public ImageIcon iie07 = new ImageIcon(Gui.class.getResource("/images/green/gruen07.jpg"));
	public ImageIcon iie08 = new ImageIcon(Gui.class.getResource("/images/green/gruen08.jpg"));
	public ImageIcon iie09 = new ImageIcon(Gui.class.getResource("/images/green/gruen09.jpg"));
	public ImageIcon iie10 = new ImageIcon(Gui.class.getResource("/images/green/gruen10.jpg"));

	public ImageIcon iig02 = new ImageIcon(Gui.class.getResource("/images/grey/grau02.jpg"));
	public ImageIcon iig03 = new ImageIcon(Gui.class.getResource("/images/grey/grau03.jpg"));
	public ImageIcon iig04 = new ImageIcon(Gui.class.getResource("/images/grey/grau04.jpg"));
	public ImageIcon iig05 = new ImageIcon(Gui.class.getResource("/images/grey/grau05.jpg"));
	public ImageIcon iig06 = new ImageIcon(Gui.class.getResource("/images/grey/grau06.jpg"));
	public ImageIcon iig07 = new ImageIcon(Gui.class.getResource("/images/grey/grau07.jpg"));
	public ImageIcon iig08 = new ImageIcon(Gui.class.getResource("/images/grey/grau08.jpg"));
	public ImageIcon iig09 = new ImageIcon(Gui.class.getResource("/images/grey/grau09.jpg"));
	public ImageIcon iig10 = new ImageIcon(Gui.class.getResource("/images/grey/grau10.jpg"));
	
	public ImageIcon iir02 = new ImageIcon(Gui.class.getResource("/images/red/rot02.jpg"));
	public ImageIcon iir03 = new ImageIcon(Gui.class.getResource("/images/red/rot03.jpg"));
	public ImageIcon iir04 = new ImageIcon(Gui.class.getResource("/images/red/rot04.jpg"));
	public ImageIcon iir05 = new ImageIcon(Gui.class.getResource("/images/red/rot05.jpg"));
	public ImageIcon iir06 = new ImageIcon(Gui.class.getResource("/images/red/rot06.jpg"));
	public ImageIcon iir07 = new ImageIcon(Gui.class.getResource("/images/red/rot07.jpg"));
	public ImageIcon iir08 = new ImageIcon(Gui.class.getResource("/images/red/rot08.jpg"));
	public ImageIcon iir09 = new ImageIcon(Gui.class.getResource("/images/red/rot09.jpg"));
	public ImageIcon iir10 = new ImageIcon(Gui.class.getResource("/images/red/rot10.jpg"));
	
	public ImageIcon iiy02 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb02.jpg"));
	public ImageIcon iiy03 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb03.jpg"));
	public ImageIcon iiy04 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb04.jpg"));
	public ImageIcon iiy05 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb05.jpg"));
	public ImageIcon iiy06 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb06.jpg"));
	public ImageIcon iiy07 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb07.jpg"));
	public ImageIcon iiy08 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb08.jpg"));
	public ImageIcon iiy09 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb09.jpg"));
	public ImageIcon iiy10 = new ImageIcon(Gui.class.getResource("/images/yellow/gelb10.jpg"));

	private Karte e02, e03, e04, e05, e06, e07, e08, e09, e10;
	private Karte g02, g03, g04, g05, g06, g07, g08, g09, g10;
	private Karte r02, r03, r04, r05, r06, r07, r08, r09, r10;
	private Karte y02, y03, y04, y05, y06, y07, y08, y09, y10;
	
	private ArrayList<Karte> kartendeck = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer1 = new ArrayList<Karte>();
	public ArrayList<Karte> kartenPlayer2 = new ArrayList<Karte>();
	
	
	
	
	public Deck(){
		
		// Grüne Karten erstellen und zur ArrayList hinzufügen
		kartendeck.add(e02 = new Karte(Karte.Farbe.GREEN,2,iie02));
		kartendeck.add(e03 = new Karte(Karte.Farbe.GREEN,3,iie03));
		kartendeck.add(e04 = new Karte(Karte.Farbe.GREEN,4,iie04));
		kartendeck.add(e05 = new Karte(Karte.Farbe.GREEN,5,iie05));
		kartendeck.add(e06 = new Karte(Karte.Farbe.GREEN,6,iie06));
		kartendeck.add(e07 = new Karte(Karte.Farbe.GREEN,7,iie07));
		kartendeck.add(e08 = new Karte(Karte.Farbe.GREEN,8,iie08));
		kartendeck.add(e09 = new Karte(Karte.Farbe.GREEN,9,iie09));
		kartendeck.add(e10 = new Karte(Karte.Farbe.GREEN,10,iie10));
				
		// Graue Karten erstellen und zur ArrayList hinzufügen
		kartendeck.add(g02 = new Karte(Karte.Farbe.GREY,2,iig02));
		kartendeck.add(g03 = new Karte(Karte.Farbe.GREY,3,iig03));
		kartendeck.add(g04 = new Karte(Karte.Farbe.GREY,4,iig04));
		kartendeck.add(g05 = new Karte(Karte.Farbe.GREY,5,iig05));
		kartendeck.add(g06 = new Karte(Karte.Farbe.GREY,6,iig06));
		kartendeck.add(g07 = new Karte(Karte.Farbe.GREY,7,iig07));
		kartendeck.add(g08 = new Karte(Karte.Farbe.GREY,8,iig08));
		kartendeck.add(g09 = new Karte(Karte.Farbe.GREY,9,iig09));
		kartendeck.add(g10 = new Karte(Karte.Farbe.GREY,10,iig10));
		
		// Rote Karten erstellen und zur ArrayList hinzufügen
		kartendeck.add(r02 = new Karte(Karte.Farbe.RED,2,iir02));
		kartendeck.add(r03 = new Karte(Karte.Farbe.RED,3,iir03));
		kartendeck.add(r04 = new Karte(Karte.Farbe.RED,4,iir04));
		kartendeck.add(r05 = new Karte(Karte.Farbe.RED,5,iir05));
		kartendeck.add(r06 = new Karte(Karte.Farbe.RED,6,iir06));
		kartendeck.add(r07 = new Karte(Karte.Farbe.RED,7,iir07));
		kartendeck.add(r08 = new Karte(Karte.Farbe.RED,8,iir08));
		kartendeck.add(r09 = new Karte(Karte.Farbe.RED,9,iir09));
		kartendeck.add(r10 = new Karte(Karte.Farbe.RED,10,iir10));
		
		// Gelbe Karten erstellen und zur ArrayList hinzufügen
		kartendeck.add(y02 = new Karte(Karte.Farbe.YELLOW,2,iiy02));
		kartendeck.add(y03 = new Karte(Karte.Farbe.YELLOW,3,iiy03));
		kartendeck.add(y04 = new Karte(Karte.Farbe.YELLOW,4,iiy04));
		kartendeck.add(y05 = new Karte(Karte.Farbe.YELLOW,5,iiy05));
		kartendeck.add(y06 = new Karte(Karte.Farbe.YELLOW,6,iiy06));
		kartendeck.add(y07 = new Karte(Karte.Farbe.YELLOW,7,iiy07));
		kartendeck.add(y08 = new Karte(Karte.Farbe.YELLOW,8,iiy08));
		kartendeck.add(y09 = new Karte(Karte.Farbe.YELLOW,9,iiy09));
		kartendeck.add(y10 = new Karte(Karte.Farbe.YELLOW,10,iiy10));

	}
	
	public void shuffleDeck(){
		
		Collections.shuffle(kartendeck);
		
	}
	
	public void giveCards(){
		
		// am besten nochmals Mischen
		this.shuffleDeck();
		
		for (int j = 0; j < 28; j++){
			if(j<14){
				kartenPlayer1.add(this.kartendeck.get(j)); 
			}
			else{
				kartenPlayer2.add(this.kartendeck.get(j));
			}
		}
		
		
	}

	public static void main(String[] args) {
			
		// Neues Deck erstellen
		Deck d = new Deck();
		
		// Karten mischen und verteilen
		d.giveCards();
		
		/*
		for(int i = 0; i < d.kartendeck.size(); i++){
			System.out.print("Farbe: " + d.kartendeck.get(i).getFarbe() + " ");
			System.out.println("Wert: " + d.kartendeck.get(i).getWert());
			
		}
		
		*/
		
		
		System.out.println("KARTEN SPIELER 1");
		for(int i = 0; i < d.kartenPlayer1.size(); i++){
			System.out.print("Farbe: " + d.kartendeck.get(i).getFarbe() + " ");
			System.out.println("Wert: " + d.kartendeck.get(i).getWert());
			
		}
		
		System.out.println("KARTEN SPIELER 2");
		for(int i = 0; i < d.kartenPlayer2.size(); i++){
			System.out.print("Farbe: " + d.kartendeck.get(i).getFarbe() + " ");
			System.out.println("Wert: " + d.kartendeck.get(i).getWert());
			
		}
		
		
		

	}
	

}
