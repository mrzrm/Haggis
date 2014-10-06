package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private Server server;

	//Konstruktor
	public ServerThread(Socket socket, Server s) {
		this.connection = socket;
		
		try {
			input = new DataInputStream(connection.getInputStream() );
			output = new DataOutputStream(connection.getOutputStream() );
		}
		catch( IOException e ) {
			e.printStackTrace();
			System.exit(1);
		}
		
		server = s;
		
		
	}

	//Run Methode
	public void run(){
		
		
	}
}
