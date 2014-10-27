package server;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class Server extends JFrame {

	private ServerSocket server;
	private static JTextArea output;
	public static Server s;
	private int port = 55558;
	private int loggedUser;
	private JScrollPane scrollPane;

	public Server() {

		super("Haggis Game-Server");
		output = new JTextArea();
		output.setEditable(false);
		scrollPane = new JScrollPane(output);
		
		// Immer runterscrollen
		DefaultCaret caret = (DefaultCaret)output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		this.display("Server wartet auf Spieler ...");

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
	public static void display(String s) {

		output.append(s + "\n");
	}

	public static void main(String[] args) {
		s = new Server();
	}

}
