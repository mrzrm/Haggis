/**
 * Der CostomComparator wird dazu benötigt um die Methode sort() auf das Karten Array anzuwenden. 
 *  
 *
 * Bugs: keine Bekannt
 *
 * @author       Adrian Immer
 * @version      1.0
 * @see also     ZugVerifizieren, Deck
 */
package client;

import java.util.Comparator;

import objekte.Karte;

public class CustomComparator implements Comparator<Karte> {
	@Override
	public int compare(Karte k1, Karte k2) {
		if(k1.getWert() - (k2.getWert()) == 0){
			return k1.getFarbe().compareTo(k2.getFarbe());
		}
		
		return k1.getWert() - (k2.getWert());
	}
}