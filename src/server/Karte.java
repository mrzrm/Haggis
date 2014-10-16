package server;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Karte implements Serializable{

	private final Farbe farbe;
	private final int rang;
	private final int punkte;
	private final ImageIcon icon;
	
	public Karte(Farbe f, int r, int p, ImageIcon i){
		this.farbe = f;
		this.rang = r;
		this.punkte = p;
		this.icon = i;
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
	
	
	public int getPunkte() {
		return punkte;
	}

	public ImageIcon getIcon() {
		return icon;
	}
	
}
