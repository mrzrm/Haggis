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
	public boolean passt = false;
	public int amZug = 0;


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
		
		//System.out.println(kartenPlayer1.get(0).getWert());
		System.out.println("Masteoject.java: MasterObject erstellt");
		
		this.passt = false;
		this.amZug = 0;
	}
	
	
}