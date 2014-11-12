package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import Gui.Client;



public class ServerThread extends Thread {

	private Socket connection;
	//private DataInputStream input;
	//private DataOutputStream output;
	public static MasterObject m;
	// private Server server;
	static int userId = 0;
	public static ArrayList<User> userList = new ArrayList<User>(2);
	public static ArrayList<ObjectOutputStream> outlist = new ArrayList<ObjectOutputStream>(
			2);

	// Konstruktor
	public ServerThread(Socket socket) {
		this.connection = socket;

	}

	// Run Methode
	public void run() {

		// sends object (out) and receives object (in)
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					connection.getOutputStream());
			out.flush();
			outlist.add(out);
			ObjectInputStream in = new ObjectInputStream(
					connection.getInputStream());

			Object inputObject;
			try {

				while ((inputObject = in.readObject()) != null) {

					if (inputObject instanceof User) {
						User user = (User) inputObject;
						user.setUserId(userId);
						userList.add(user);
						out.writeObject(userId);
						userId++;
						System.out.println("Thread Id: " + this.getId() + " Spieler "
								+ user.getName() + " hat sich eingeloggt! (UserId:"
								+ user.getUserId() + ")");

						// Ausgabe in Serverkonsole
						Server.display(user.getName() + " hat sich eingeloggt.");

						// falls 2 spieler angemeldet sind, wird masterobject
						// erstellt
						if (userList.size() == 2) {
							m = new MasterObject(userList);

							// send Masterobject to Clients
							Iterator<ObjectOutputStream> i = outlist.iterator();
							while (i.hasNext()) {
								i.next().writeObject(m);
								System.out.println("ServerThread.java: MasterObject wurde geschickt!");
								Server.display(m.users.get(0).getName() + " ist am Zug.");
							}
							
													
							// sleep
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
					
					// Input vom  MasterObjekt
					else if (inputObject instanceof MasterObject) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						MasterObject m = (MasterObject) inputObject;
						
						// Spiellogik aufrufen
						m = Logik.Kontrolle(m);
						
						// Neues MasterObejct zu den Clients zurückschicken
						Iterator<ObjectOutputStream> i = outlist.iterator();
						while (i.hasNext()) {
							i.next().writeObject(m);
							System.out.println("Masterobjekt: sent back");
							System.out.println("ServerThread.class - amZug:" + m.getAmZug());
						}
					}
					
					// Falls ein kaputtes Objekt ankommt 
					else {
						Server.display("Unerwartetes Objekt erhalten: " + inputObject.getClass().getName());
					}

				}
			} catch (ClassNotFoundException cnfException) {
				cnfException.printStackTrace();
				Server.display("Class Not Found Exception: " + cnfException.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
			Server.display("Ein Spieler hat das Spiel verlassen!\n" + e.toString()); 

		}

	}

	public static void neueRunde() {
		//m = new MasterObject(userList);
		m.d.shuffleDeck();
		m.d.giveCards();				
		m.kartenPlayer1 = m.d.getKartenPlayer1();
		m.kartenPlayer2 = m.d.getKartenPlayer2();
		m.kartenJoker1 =  m.d.getJokerPlayer1().toArray(new Karte[m.d.getJokerPlayer1().size()]);
		m.kartenJoker2 = m.d.getJokerPlayer2().toArray(new Karte[m.d.getJokerPlayer2().size()]);
		m.setNeuVerteilt(true);
		System.out.println("serverthread " + m.isNeuVerteilt());
		
		System.out.println(m.d.getKartenPlayer1().get(1).getWert());


		System.out.println("neuRunde(): Karten neu verteilt");
	}
}
