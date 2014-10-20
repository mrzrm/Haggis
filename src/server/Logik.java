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
			
			Server.display(m.users.get(m.getAmZug()).getName() + " hat gespielt:");
			
			for(int r = 0; r < m.gespielteKarten.size(); r++){
				System.out.print("Farbe: " + m.gespielteKarten.get(r).getFarbe());
				System.out.println(" Wert: " + m.gespielteKarten.get(r).getWert());
				Server.display(m.gespielteKarten.get(r).getFarbe() + " " + m.gespielteKarten.get(r).getWert());
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
