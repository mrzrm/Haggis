package server;


public class Logik {
	
	public static MasterObject Kontrolle (MasterObject m){
		
		// Falls ein Spieler keine Karten mehr hat, neue Runde starten
		if(m.getKartenPlayer1().size() == 0 || m.getKartenPlayer2().size() == 0){
			if(m.getKartenPlayer1().size() == 0){
				
				Server.display(m.users.get(0).getName() + " hat Runde gewonnen! Karten werden neu verteilt...");
				
				
				// Punkte bis letze Karte
				int tmpPunkte = m.users.get(0).getPunkte();
				tmpPunkte += m.getPunkteBisStich();
				
				// Zus�tzlich f�nf Punkte f�r jede Karte des Gegners
				int tmpKartenX5 = m.getKartenPlayer2().size() * 5;
				tmpPunkte += tmpKartenX5;
				
				//Punkte setzen
				m.users.get(0).setPunkte(tmpPunkte);
				
				// pukteBisStich reseten
				m.setPunkteBisStich(0);
				
				// Karten neu verteilen (neu verteilt auf true)
				ServerThread.neueRunde();
				
							
			}
			else if(m.getKartenPlayer2().size() == 0){
				
				Server.display(m.users.get(1).getName() + " hat Runde gewonnen! Karten werden neu verteilt...");
				
				// Punkte bis letze Karte
				int tmpPunkte = m.users.get(1).getPunkte();
				tmpPunkte += m.getPunkteBisStich();
							
				// Zus�tzlich f�nf Punkte f�r jede Karte des Gegners
				int tmpKartenX5 = m.getKartenPlayer1().size() * 5;
				tmpPunkte += tmpKartenX5;
							
				//Punkte setzen
				m.users.get(1).setPunkte(tmpPunkte);
				
				// pukteBisStich reseten
				m.setPunkteBisStich(0);
				
				// Karten neu verteilen (neu verteilt auf true)
				ServerThread.neueRunde();
				
				
			}
		}
		
		// Wenn n�chster Spieler am Zug
		else{
					
			// Falls Spieler passt
			if (m.isPasst()){
				m.setPasst(false);
				
				// Spielfeld l�schen
				m.gespielteKarten.clear();
				
				// punkteBisStich dem Spieler der nicht gepasst hat hinzu addieren
				int bekommtPunkte = 0;
				if(m.getAmZug() == 1 ){
					bekommtPunkte = 0;
				}else{
					bekommtPunkte = 1;
				}
				int tPunkte = m.users.get(bekommtPunkte).getPunkte();
				tPunkte += m.getPunkteBisStich();
				m.users.get(bekommtPunkte).setPunkte(tPunkte);
				
				// pukteBisStich reseten
				m.setPunkteBisStich(0);
				
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
					
	//		// Testausgabe joker
	//		for (Karte k: m.kartenJoker1){
	//			if(k != null){
	//				System.out.println("Joker 1: Wert: " + k.getWert());
	//			}
	//		}
	//		for (Karte k: m.kartenJoker2){
	//			if(k != null){
	//				System.out.println("Joker 2: Wert: " + k.getWert());
	//			}
	//		}
			
			
			// Den Spieler der am Zug ist wechseln
			if (m.getAmZug() == 1){
				m.setAmZug(0);
			}else{
				m.setAmZug(1);
			}
			Server.display(m.users.get(m.getAmZug()).getName() + " ist am Zug.");
			
		}
		
		return m;
	}
}
