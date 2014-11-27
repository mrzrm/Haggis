package Gui;

import java.awt.Window;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import server.Karte;
import server.MasterObject;

public class Client {

	Login login;
	Socket socket;
	static ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	private Gui frame;
	static int clientId;
	static String hostName = "localhost";
	static int portNumber = 55558;
	public static MasterObject m;
	public static ArrayList<ObjectOutputStream> outlist = new ArrayList<ObjectOutputStream>();

	public static void main(String[] args) {
		new Client(hostName, portNumber);

	}

	public Client(String hostName, int portNumber) {
		init(hostName, portNumber);
		login = new Login(this.out, this.in);
		receiveObjectFromServer();

	}

	public void init(String hostName, int portNumber) {
		try {
			socket = new Socket(hostName, portNumber);
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());

		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	public static void sendObjectToServer() {
		// send Masterobject from client
		try {
			out.writeObject(Client.m);
			System.out.println("Masterobject: sent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receiveObjectFromServer() {
		// receive the Masterobject
		try {
			while ((inputObject = in.readObject()) != null) {

				// empfangen des Masterobjekts
				if (inputObject instanceof MasterObject) {
					m = (MasterObject) inputObject;
					
					System.out.println("Client MasteObjekt emfangen - neuVerteilt: " + m.isNeuVerteilt());
					
					System.out.println("MasterObject empfangen - Spieler: "
							+ m.users.get(0).getName() + " und "
							+ m.users.get(1).getName());
					
					if(m.getSieger() == 0){
						refreshGui();
					}else{
						zeigeGewinner(m.getSieger());
						m.setSieger(0);
						refreshGui();
						
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// ClientId setzen
				else if (inputObject instanceof Integer) {
					
					clientId = (int) inputObject;
					frame = new Gui();
					frame.setVisible(true);
					
				}

				// Error wenn Server disconected
				else if (inputObject instanceof SocketException) {
					JOptionPane.showMessageDialog(null,
							"Bitte starte das Spiel neu",
							"Ein Spieler hat die Verbindung getrennt",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				
				else if (inputObject instanceof String) {
					JOptionPane.showMessageDialog(null,
							"Ein Spieler hat die Verbindung getrennt \n"
							+ "Bitte starte das Spiel neu!",
							"Verbindungsfehler",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				else {
					System.out.println("Unexpected object type:  "
							+ inputObject.getClass().getName());
				}
			}
		} catch (ClassNotFoundException | IOException cnfException) {
			cnfException.printStackTrace();
		}
	}

	private void zeigeGewinner(int sieger) {
		if(sieger == clientId+1){
			System.out.println("Sie haben das Spiel Gewonnen! Gratuliere :-)");
			
			// Kartenanzahl Label aktualisieren
			if(clientId == 0){
				Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer1.size()));
				Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer2.size()));
			}else{
				Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer2.size()));
				Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer1.size()));
			}
				
			// Punkte Label aktualisieren
			if(clientId == 0){
				Gui.lblp1Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
				Gui.lblp2Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
			}else{
				Gui.lblp1Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
				Gui.lblp2Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
			}
			
			
			// Custom button text
			Object[] options = { "Neue Runde starten", "Spiel beenden" };
			int w = JOptionPane.showOptionDialog(frame,
					"Gratulation, Sie haben das Spiel gewonnen!", "Haggis",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(w == 1){
				System.exit(0);
			}else{
				// Punkte zurücksetzen
				m.users.get(0).setPunkte(0);
				m.users.get(1).setPunkte(0);
			}
		}else{
			System.out.println("Sie haben leider verloren");
			
			// Kartenanzahl Label aktualisieren
			if(clientId == 0){
				Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer1.size()));
				Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer2.size()));
			}else{
				Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer2.size()));
				Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer1.size()));
			}
		
			// Punkte Label aktualisieren
			if(clientId == 0){
				Gui.lblp1Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
				Gui.lblp2Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
			}else{
				Gui.lblp1Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
				Gui.lblp2Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
			}
			
			// Custom button text
			Object[] options = { "Neue Runde starten", "Spiel beenden" };
			int l = JOptionPane.showOptionDialog(frame,
					"Sie haben leider verloren. Vielleicht haben Sie in der nächsten Runde mehr Glück?", "Haggis",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(l == 1){
				System.exit(0);
			}else{
				// Punkte zurücksetzen
				m.users.get(0).setPunkte(0);
				m.users.get(1).setPunkte(0);
			}
			
		}
		
	}

	private void refreshGui() {

		// Spielernamen setzen
		if (Gui.lblSpieler1.getText().equals("Spieler 1")) {

			for (int i = 0; i < m.users.size(); i++) {
				if (m.users.get(i).getUserId() == clientId) {
					Gui.lblSpieler1.setText(m.users.get(i).getName());
				} else {
					Gui.lblSpieler2.setText(m.users.get(i).getName());
				}
			}
		}

		// Spielkarten auf Hand laden (wenn neu verteilt)
		if (m.isNeuVerteilt()) {

			if (clientId == 0) {
				kartenSetzen(0);
			} else {
				kartenSetzen(1);
			}
			System.out.println("Karten neu verteilt");
		}
		// Spielfläche laden
		else {
			
			// Reset Spielfläche
			for (int g = 0; g < Gui.alKartenTisch.size(); g++) {
				Gui.alKartenTisch.get(g).setIcon(null);
			}
			// neue gespielte Karten setzen
			for (int f = 0; f < m.getGespielteKarten().size(); f++) {
				Gui.alKartenTisch.get(f).setIcon(
						m.getGespielteKarten().get(f).getIcon());
			}
		}

		//Joker aktualisieren

		if (clientId == 0){
			Karte[] temp = m.getKartenJoker2();
			if (temp[0] == null){
				Gui.lblp2bube.setVisible(false);
			}
			if (temp[1] == null){
				Gui.lblp2dame.setVisible(false);
			}
			if (temp[2] == null){
				Gui.lblp2koenig.setVisible(false);
			}
			
		} else {
			Karte[] temp1 = m.getKartenJoker1();
			if (temp1[0] == null){
				Gui.lblp2bube.setVisible(false);
			}
			if (temp1[1] == null){
				Gui.lblp2dame.setVisible(false);
			}
			if (temp1[2] == null){
				Gui.lblp2koenig.setVisible(false);
			}
			
		}
		
		// Kartenanzahl Label aktualisieren
		if(clientId == 0){
			Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer1.size()));
			Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer2.size()));
		}else{
			Gui.lblp1KartenAnzahl.setText(Integer.toString(m.kartenPlayer2.size()));
			Gui.lblp2Karten.setText(Integer.toString(m.kartenPlayer1.size()));
		}
		
		//System.out.println("Anz. KartenPlayer1: " + m.kartenPlayer1.size());
		//System.out.println("Anz. KartenPlayer2: " + m.kartenPlayer2.size());
					
		// Punkte Label aktualisieren
		if(clientId == 0){
			Gui.lblp1Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
			Gui.lblp2Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
		}else{
			Gui.lblp1Punkte.setText(Integer.toString(m.users.get(1).getPunkte()));
			Gui.lblp2Punkte.setText(Integer.toString(m.users.get(0).getPunkte()));
		}
		
		
		// Buttons aktivieren und Status setzen wenn Spieler am Zug ist
		if (m.getAmZug() == clientId) {
			Gui.btnAusspielen.setEnabled(true);
			if (m.isNeuVerteilt()) {
				// Erster Zug darf man nicht passen!
				Gui.btnPassen.setEnabled(false);
			} else {
				Gui.btnPassen.setEnabled(true);
			}
			Gui.jlStatus.setText("Sie sind am Zug");
			// Fenster in Fokus setzen
			java.awt.EventQueue.invokeLater(new Runnable() {

				@Override
			    public void run() {
			        frame.toFront();
			        frame.repaint();
			    }
			});
		} else {
			Gui.btnAusspielen.setEnabled(false);
			Gui.btnPassen.setEnabled(false);
			Gui.jlStatus.setText("Ihr Gegner ist am Zug");
		}

		m.setNeuVerteilt(false);

		// System.out.println("Client: gui refreshed");
		// System.out.println("am zug:" + m.getAmZug());
		// System.out.println("NeuVerteilt: " + m.isNeuVerteilt());
		System.out.println("clientId: " + clientId);
	}

	private void kartenSetzen(int i) {
		if (i == 0) {
			for (int j = 0; j < m.kartenPlayer1.size(); j++) {
				// ImageIcon setzen
				ImageIcon tmpii = m.kartenPlayer1.get(j).getIcon();
				// Icons visible machen
				Gui.alKarten.get(j).setVisible(true);
				Gui.alKarten.get(j).setIcon(null);
				Gui.alKarten.get(j).setIcon(tmpii);
				// Kartenobjekt dem Button zuweisen
				Gui.alKarten.get(j).setKarte(m.kartenPlayer1.get(j));
				
			}
			
			// alle eigenen Joker visible setzen
			for (int l = 0; l < Gui.alJoker.size(); l++){
				Gui.alJoker.get(l).setVisible(true);
			}
			
			// den eigenen Jokerbuttens die entsprechenden Werte zuweisen
			for (int k = 0; k < m.kartenJoker1.length; k++) {
				Gui.alJoker.get(k).setKarte(m.kartenJoker1[k]);
			}
			
			// Jokerlabel des Gegners Visible setzen
			Gui.lblp2bube.setVisible(true);
			Gui.lblp2dame.setVisible(true);
			Gui.lblp2koenig.setVisible(true);
			
			// Reset Spielfläche
			for (int g = 0; g < Gui.alKartenTisch.size(); g++) {
				Gui.alKartenTisch.get(g).setIcon(null);
			}
			
			System.out.println("Karten player1 wurden neu gesetzt");

		} else {
			for (int j = 0; j < m.kartenPlayer2.size(); j++) {
				// ImageIcon setzen
				ImageIcon tmpii = m.kartenPlayer2.get(j).getIcon();
				//Icons visible machen
				Gui.alKarten.get(j).setVisible(true);
				Gui.alKarten.get(j).setIcon(null);
				Gui.alKarten.get(j).setIcon(tmpii);
				// Kartenobjekt dem Button zuweisen
				Gui.alKarten.get(j).setKarte(m.kartenPlayer2.get(j));
				
			}
			
			// alle eigenen Joker visible setzen
			for (int l = 0; l < Gui.alJoker.size(); l++) {
				Gui.alJoker.get(l).setVisible(true);
			}

			// den eigenen Jokerbuttens die entsprechenden Werte zuweisen
			for (int k = 0; k < m.kartenJoker2.length; k++) {
				Gui.alJoker.get(k).setKarte(m.kartenJoker2[k]);
			}
			
			// Jokerlabel des Gegners Visible setzen
			Gui.lblp2bube.setVisible(true);
			Gui.lblp2dame.setVisible(true);
			Gui.lblp2koenig.setVisible(true);
			
			// Reset Spielfläche
			for (int g = 0; g < Gui.alKartenTisch.size(); g++) {
				Gui.alKartenTisch.get(g).setIcon(null);
			}
			
			System.out.println("Karten player2 wurden neu gesetzt");

		}

	}

}
