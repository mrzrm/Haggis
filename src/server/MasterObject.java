package server;

import java.io.Serializable;
import java.util.ArrayList;

public class MasterObject implements Serializable {

	// Attributes
	public ArrayList<User> users;
	public Deck d;
	public ArrayList<Karte> kartenPlayer1;
	public ArrayList<Karte> kartenPlayer2;
	public ArrayList<Karte> kartenJoker1;
	public ArrayList<Karte> kartenJoker2;
	public ArrayList<Karte> gespielteKarten;
	public boolean passt;
	public int amZug;
	public boolean neuVerteilt;


	//constructor
	public MasterObject(){
	}
	
	public MasterObject(ArrayList<User> userList){
		this.users = userList;
		
		d  = new Deck();
		d.giveCards();
		
		this.kartenPlayer1 = d.getKartenPlayer1();
		this.kartenPlayer2 = d.getKartenPlayer2();
		this.kartenJoker1 = d.getJokerPlayer1();
		this.kartenJoker2 = d.getJokerPlayer2();
		this.gespielteKarten = null;
		
		this.neuVerteilt = true;
		
		//System.out.println(kartenPlayer1.get(0).getWert());
		System.out.println("Masteoject.java: MasterObject erstellt");
		
	}

	public boolean isPasst() {
		return passt;
	}

	public void setPasst(boolean passt) {
		this.passt = true;
	}

	public int getAmZug() {
		return amZug;
	}

	public void setAmZug(int amZug) {
		this.amZug = amZug;
	}
	public boolean isNeuVerteilt() {
		return neuVerteilt;
	}

	public void setNeuVerteilt(boolean neuVerteilt) {
		this.neuVerteilt = neuVerteilt;
	}

	public ArrayList<Karte> getGespielteKarten() {
		return gespielteKarten;
	}

	public void setGespielteKarten(ArrayList<Karte> gespielteKarten) {
		this.gespielteKarten = gespielteKarten;
	}

	public ArrayList<Karte> getKartenJoker1() {
		return kartenJoker1;
	}

	public void setKartenJoker1(ArrayList<Karte> kartenJoker1) {
		this.kartenJoker1 = kartenJoker1;
	}

	public ArrayList<Karte> getKartenJoker2() {
		return kartenJoker2;
	}

	public void setKartenJoker2(ArrayList<Karte> kartenJoker2) {
		this.kartenJoker2 = kartenJoker2;
	}
		
}