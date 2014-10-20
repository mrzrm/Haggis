package server;


public class Logik {
	
	public static MasterObject Kontrolle (MasterObject m){
		
		// Falls Spieler passt
		if (m.isPasst()){
			m.setPasst(false);
			
			// Konsolenausgabe
			Server.display(m.users.get(m.getAmZug()).getName() + " hat gepasst.");
		}
		
		
		// Wenn Spieler Karten ausspielt
		else {
			
			// Code hier einfügen wenn Karten gespielt werden
			
			
			
			
			
			
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
