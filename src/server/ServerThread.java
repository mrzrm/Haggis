package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ServerThread extends Thread {

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
//	private Server server;
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
						System.out.println(this.getId() + ": Spieler " + user.getName() + " hat sich eingeloggt! (" + user.getUserId() + ")");
						
						// Ausgabe in Serverkonsole
						Server.display(this.getId() + ": Spieler " + user.getName() + " hat sich eingeloggt! (" + user.getUserId() + ")");
						
						//falls 2 spieler angemeldet sind, wird masterobject erstellt
						if (userList.size() == 2) {
							MasterObject mo = new MasterObject(userList);
						}

					}

				}
			} catch (ClassNotFoundException cnfException) {
				cnfException.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}
}
