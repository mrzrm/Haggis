package server;

import java.util.Comparator;

public class CustomComparator implements Comparator<Karte> {
	@Override
	public int compare(Karte k1, Karte k2) {
		return k1.getWert() - (k2.getWert());
	}
}