package server;


public class Logik {
	
	public static MasterObject Kontrolle (MasterObject m){
		
		// Falls Spieler passt
		if (m.isPasst()){
			m.setPasst(false);
			
			//Spielfeld löschen
			m.gespielteKarten.clear();
			
			
			// Konsolenausgabe
			Server.display(m.users.get(m.getAmZug()).getName() + " hat gepasst.");
		}
		
		
		// Wenn Spieler Karten ausspielt
		else {
			
			Server.display(m.users.get(m.getAmZug()).getName() + " hat gespielt:");
			for(int r = 0; r < m.gespielteKarten.size(); r++){
				System.out.print("Farbe: " + m.gespielteKarten.get(r).getFarbe());
				System.out.println(" Wert: " + m.gespielteKarten.get(r).getWert());
				Server.display(m.gespielteKarten.get(r).getFarbe() + " " + m.gespielteKarten.get(r).getWert());
			}
			
		}
				
		// Testausgabe joker
		for (Karte k: m.kartenJoker1){
			if(k != null){
				System.out.println("Joker 1: Wert: " + k.getWert());
			}
		}
		for (Karte k: m.kartenJoker2){
			if(k != null){
				System.out.println("Joker 2: Wert: " + k.getWert());
			}
		}
		
		
		// Den Spieler der am Zug ist wechseln
		if (m.getAmZug() == 1){
			m.setAmZug(0);
		}else{
			m.setAmZug(1);
		}
		Server.display(m.users.get(m.getAmZug()).getName() + " ist am Zug.");
		
		
		return m;
	}
}
