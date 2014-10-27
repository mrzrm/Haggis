package Gui;

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
					System.out.println("MasterObject empfangen - Spieler: "
							+ m.users.get(0).getName() + " und "
							+ m.users.get(1).getName());
					refreshGui();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// ClientId setzen
				else if (inputObject instanceof Integer) {
					clientId = (int) inputObject;
					Gui frame = new Gui();
					frame.setVisible(true);
				}

				// Error if someone disconnects or closes game
				else if (inputObject instanceof SocketException) {
					JOptionPane.showMessageDialog(null,
							"Bitte starte das Spiel neu",
							"Ein Spieler hat die Verbindung getrennt",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
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
		// Spielfl�che laden
		else {
			
			// Reset Spielfl�che
			for (int g = 0; g < Gui.alKartenTisch.size(); g++) {
				Gui.alKartenTisch.get(g).setIcon(null);
			}
			// neue gespielte Karten setzen
			for (int f = 0; f < m.getGespielteKarten().size(); f++) {
				Gui.alKartenTisch.get(f).setIcon(
						m.getGespielteKarten().get(f).getIcon());
			}
			// Array gespielte Karten l�schen
			m.getGespielteKarten().clear();
			//System.out.println("Spielfl�che neu geladen. Anz. gespielte Karten:" + m.getGespielteKarten().size());
		}

		//Joker aktualisieren
		
		
		//Gui.lblp2bube.setVisible(false);
		//Gui.lblp2dame.setVisible(false);
		//Gui.lblp2koenig.setVisible(false);
		
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
				Gui.alKarten.get(j).setIcon(tmpii);
				// Kartenobjekt dem Button zuweisen
				Gui.alKarten.get(j).setKarte(m.kartenPlayer1.get(j));
			}

			for (int k = 0; k < m.kartenJoker1.length; k++) {
				Gui.alJoker.get(k).setKarte(m.kartenJoker1[k]);
			}

		} else {
			for (int j = 0; j < m.kartenPlayer2.size(); j++) {
				// ImageIcon setzen
				ImageIcon tmpii = m.kartenPlayer2.get(j).getIcon();
				Gui.alKarten.get(j).setIcon(tmpii);
				// Kartenobjekt dem Button zuweisen
				Gui.alKarten.get(j).setKarte(m.kartenPlayer2.get(j));
			}

			for (int k = 0; k < m.kartenJoker2.length; k++) {
				Gui.alJoker.get(k).setKarte(m.kartenJoker2[k]);
			}

		}

	}

}
