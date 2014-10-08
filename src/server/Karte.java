package server;

import javax.swing.ImageIcon;

public class Karte {

	private final Farbe farbe;
	private final int wert;
	private final ImageIcon icon;
	
	public Karte(Farbe f, int w, ImageIcon i){
		this.farbe = f;
		this.wert = w;
		this.icon = i;
	}
	
	public enum Farbe {
        RED, GREEN, GREY, YELLOW, JOKER;
	}

	public Farbe getFarbe() {
		return farbe;
	}

	public int getWert() {
		return wert;
	}

	public ImageIcon getIcon() {
		return icon;
	}
	
	
}
