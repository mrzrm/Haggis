package server;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server extends JFrame{

	private ServerSocket server;
	private JTextArea output;
	private static Server s;

	public Server(){
			
		super("Gaggis Game-Server");
	
		try {
			server = new ServerSocket(5000, 2);
		}
		catch( IOException e ) {
			e.printStackTrace();
			System.exit( 1 );
		}

		output = new JTextArea();
		getContentPane().add( output, BorderLayout.CENTER );
		output.setText( "Server waiting for connections\n" );

		setLocation(100,100);
		setSize(300,300);
		setVisible(true);
	}
	
	public void display(String s){
		
		output.append(s + "\n");
	}
	
	public static void main(String[] args) {
		s = new Server();
	}

}

