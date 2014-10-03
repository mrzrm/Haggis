package server;

import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket socket = null;


	//Konstruktor
	public ServerThread(Socket socket) {
		this.socket  = socket;
	}

	//Run Methode
	public void run(){
		
		
	}
}
