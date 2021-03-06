/**
 * Der ServerThread wartet jeweils auf empfangene Objekte des Clients und l�st dementsprechend
 * die Klasse Logik auf. Anschliessend wird MasterObjekt zur�ckgeschickt.
 *
 * Bugs: keine Bekannt
 *
 * @author       Moritz Leimgr�bler, Kevin Schenk
 * @version      1.0
 * @see also     Server, Logik
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import objekte.MasterObject;
import objekte.User;



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
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						MasterObject m = (MasterObject) inputObject;
						
						// Spiellogik aufrufen
						m = Logik.Kontrolle(m);
						
						// Neues MasterObejct zu den Clients zur�ckschicken
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
			Server.display("Ein Spieler hat das Spiel verlassen!");
			
			// Hier sollte eine meldung an Mitspieler gemacht werden, dass sein opponent geleaved hat
			Iterator<ObjectOutputStream> i = outlist.iterator();
			while (i.hasNext()) {
				try {
					i.next().writeObject("fertig");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Meldung Spiel beendet verschickt");
			}

		}

	}

}
