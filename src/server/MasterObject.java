package server;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MasterObject implements Serializable {

	// Attributes
	public ArrayList<User> users;
	public Deck d;
	public ArrayList<Karte> kartenPlayer1;
	public ArrayList<Karte> kartenPlayer2;
	public Karte[] kartenJoker1;
	public Karte[] kartenJoker2;
	public ArrayList<Karte> gespielteKarten;
	public boolean passt;
	public int amZug;
	public boolean neuVerteilt;
	public boolean verify;
	public boolean verifyBombe;
	public int letzerZug;
	public int punkteBisStich;
	public int bombe;


	//constructor
	public MasterObject(){
	}
	
	public MasterObject(ArrayList<User> userList){
		this.users = userList;
		
		d  = new Deck();
		d.giveCards();
		
		this.kartenPlayer1 = d.getKartenPlayer1();
		this.kartenPlayer2 = d.getKartenPlayer2();
		this.kartenJoker1 =  d.getJokerPlayer1().toArray(new Karte[d.getJokerPlayer1().size()]);
		this.kartenJoker2 = d.getJokerPlayer2().toArray(new Karte[d.getJokerPlayer2().size()]);
		//this.gespielteKarten = null;
		
		
		this.neuVerteilt = true;
		
		//System.out.println(kartenPlayer1.get(0).getWert());
		System.out.println("Masteoject.java: MasterObject erstellt");
		
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public boolean isPasst() {
		return passt;
	}

	public void setPasst(boolean passt) {
		this.passt = passt;
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

	public Karte[] getKartenJoker1() {
		return kartenJoker1;
	}

	public void setKartenJoker1(Karte[] kartenJoker1) {
		this.kartenJoker1 = kartenJoker1;
	}

	public Karte[] getKartenJoker2() {
		return kartenJoker2;
	}

	public void setKartenJoker2(Karte[] kartenJoker2) {
		this.kartenJoker2 = kartenJoker2;
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

	public int getPunkteBisStich() {
		return punkteBisStich;
	}

	public void setPunkteBisStich(int punkteBisStich) {
		this.punkteBisStich = punkteBisStich;
	}

	public void neuRunde() {
		
		d = null;
		d  = new Deck();
		d.giveCards();
		
		this.kartenPlayer1 = d.getKartenPlayer1();
		this.kartenPlayer2 = d.getKartenPlayer2();
		this.kartenJoker1 =  d.getJokerPlayer1().toArray(new Karte[d.getJokerPlayer1().size()]);
		this.kartenJoker2 = d.getJokerPlayer2().toArray(new Karte[d.getJokerPlayer2().size()]);
		
		this.neuVerteilt = true;
		this.gespielteKarten = null;
		this.passt = false;
		this.amZug = 0;
		
	}	
}
