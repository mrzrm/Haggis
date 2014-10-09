package Gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;


public class Client {

	Login login;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Object inputObject;
	static int clientId;
	static String hostName = "localhost";
	static int portNumber = 55559;
	

	
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
		// receive the UserObject and do whatever the client has to do...
		try {
			while ((inputObject = in.readObject()) != null) {
//				if (inputObject instanceof Masterobject) {
//					//mo = (Masterobject) inputObject;
//					
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					UpdatePlaytable();
//				} 
				// set Client_ID
				if (inputObject instanceof Integer) {
					clientId = (int) inputObject;
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
	
	

}
