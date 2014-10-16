package Gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import server.MasterObject;


public class Client {

	Login login;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	static int clientId;
	static String hostName = "localhost";
	static int portNumber = 55558;
	public MasterObject m;
	

	
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

	
	public void receiveObjectFromServer() {
		// receive the Masterobject 
		try {
			while ((inputObject = in.readObject()) != null) {
				
				// empfangen der ClientID
				if (inputObject instanceof Integer) {
					clientId = (int) inputObject;
					System.out.println("ClientId empfangen: " + clientId );
				} 
				
				
				
				// empfangen des Masteobjekts
				else if (inputObject instanceof MasterObject) {
					m = (MasterObject) inputObject;
					System.out.println("MsterObject empfangen - Spieler: " + m.users.get(0).getName() + " und " + m.users.get(1).getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					refreshGui();
				} 
				// set Client_ID
				if (inputObject instanceof Integer) {
					clientId = (int) inputObject;
					Gui frame = new Gui();
					frame.setVisible(true);
				} 
				
				// Error if someone disconnects or closes game
				else if (inputObject instanceof SocketException){
					JOptionPane.showMessageDialog(null, "Bitte starte das Spiel neu", "Ein Spieler hat die Verbindung getrennt", JOptionPane.ERROR_MESSAGE);
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
		if(Gui.lblSpieler1.getText().equals("Spieler 1")){
			
			for (int i = 0; i < m.users.size(); i++){
				if (m.users.get(i).getUserId() == clientId){
					Gui.lblSpieler1.setText(m.users.get(i).getName());
				}
				else{
					Gui.lblSpieler2.setText(m.users.get(i).getName());
				}
			}
		}
		
		// Spielkarten laden
		if(clientId == 0){
			kartenSetzen(0);
		}
		else{
			kartenSetzen(1);
		}
		
	}

	private void kartenSetzen(int i) {
		if(i == 0){
			for (int j = 0; j < m.kartenPlayer1.size(); j++){
				ImageIcon tmpii = m.kartenPlayer1.get(j).getIcon();
				Gui.alKarten.get(j).setIcon(tmpii);
			}
		}
		else{
			for (int j = 0; j < m.kartenPlayer2.size(); j++){
				ImageIcon tmpii = m.kartenPlayer2.get(j).getIcon();
				Gui.alKarten.get(j).setIcon(tmpii);
			}
			
		}
		
	}
	
	

}
