package objekte;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Karte implements Serializable{

	private String name;
	private Farbe farbe;
	private int rang;
	private final int punkte;
	private final ImageIcon icon;
	
	public Karte(String n, Farbe f, int r, int p, ImageIcon i){
		this.name = n;
		this.farbe = f;
		this.rang = r;
		this.punkte = p;
		this.icon = i;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public enum Farbe {
        RED, GREEN, GREY, YELLOW, JOKER;
	}

	public Farbe getFarbe() {
		return farbe;
	}

	public int getWert() {
		return rang;
	}
	
	public void setWert(int rang) {
		this.rang = rang;
	}

	public void setFarbe(Farbe farbe) {
		this.farbe = farbe;
	}

	public int getPunkte() {
		return punkte;
	}

	public ImageIcon getIcon() {
		return icon;
	}
	
}
