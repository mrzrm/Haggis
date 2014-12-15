/**
 * Die Klasse User enthält den Aufbau eines Spielers.
 *
 * Bugs: keine Bekannt
 *
 * @author       Adrian Immer
 * @version      1.0
 * @see also     MasterObject, Logik
 */
package objekte;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	private int userId;
	private String name;
	private ArrayList<Karte> hand;
	private boolean aktiv;
	private int punkte;
	
	public User(String n){
		
		this.name = n;
		this.hand = new ArrayList<Karte>();
		this.aktiv = false;
		this.punkte = 0;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Karte> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Karte> hand) {
		this.hand = hand;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
