package server;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server extends JFrame {

	private ServerSocket server;
	private JTextArea output;
	public static Server s;
	private int port = 55559;
	private int loggedUser;

	public Server() {

		super("Haggis Game-Server");
		
		output = new JTextArea();
		getContentPane().add(output, BorderLayout.CENTER);
		this.display("Server waiting for connections...");

		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			while (loggedUser < 2) {
				new ServerThread(serverSocket.accept()).start();
				loggedUser++;

			}
		} catch (IOException e) {
			this.display("Could not listen on port " + port);
			System.err.println("Could not listen on port " + port);
			System.exit(-1);
		}
	}

	/**
	 * Methode welche auf die Serverkonsole schreibt.
	 * 
	 * @param s
	 *            : Text der auf Serverkonsole ausgegeben werden soll.
	 */
	public void display(String s) {

		output.append(s + "\n");
	}

	public static void main(String[] args) {
		s = new Server();
	}

}
