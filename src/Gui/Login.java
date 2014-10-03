package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblSpielerNameEingeben;
	private JPanel panel_north;
	private JLabel lblCoverImage;
	private JPanel panel_center;
	private JPanel panel_south;
	
	public Icon cover = new ImageIcon(Gui.class.getResource("/images/special/cover.jpg"));
	private JButton btnSpielStarten;
	private JButton btnVerlassen;
	private JLabel lblmaxZeichen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login Haggis Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_center = new JPanel();
		contentPane.add(panel_center);
		
		lblSpielerNameEingeben = new JLabel("Spieler Name eingeben:");
		lblSpielerNameEingeben.setHorizontalAlignment(SwingConstants.CENTER);
		panel_center.add(lblSpielerNameEingeben);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addActionListener(this);
		panel_center.add(textField);
		textField.setColumns(10);
		
		lblmaxZeichen = new JLabel("(max. 14 Zeichen)");
		panel_center.add(lblmaxZeichen);
		
		panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		
		lblCoverImage = new JLabel("");
		panel_north.add(lblCoverImage);
		lblCoverImage.setIcon(cover);
		
		
		panel_south = new JPanel();
		contentPane.add(panel_south, BorderLayout.SOUTH);
		
		btnSpielStarten = new JButton("Spiel starten");
		btnSpielStarten.addActionListener(this);
		panel_south.add(btnSpielStarten);
		
		btnVerlassen = new JButton("Verlassen");
		btnVerlassen.addActionListener(this);
		panel_south.add(btnVerlassen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		
		//Input von btnSpielStarten
		if (src == btnSpielStarten){
			if (textField.getText().length() <= 14){
				System.out.println("Login: btnSpielStarten");
//					//Methode um User zu ertstellen	
//					User Loginuser = new User(tfEnterNickname.getText());
//					this.out.writeObject(Loginuser);
//					tfEnterNickname.setText("");
//					setVisible(false);
//					playtable = new Playtable(this.out, this.in);
			}else{
				textField.setText("");
				JOptionPane.showMessageDialog(null, "Spielername darf nicht mehr als 14 Zeichen haben!", "Dein Spielername ist zu lang!", JOptionPane.PLAIN_MESSAGE);
			}
			
		// Input von textField (Eingabe mit Enter-Taste)
		}else if (src == textField){
			if(textField.getText().length() <= 14){
				System.out.println("Login: textField");
//					//Methode um User zu ertstellen	
//					User Loginuser = new User(tfEnterNickname.getText());
//					this.out.writeObject(Loginuser);
//					tfEnterNickname.setText("");
//					setVisible(false);
//					playtable = new Playtable(this.out, this.in);
			}else{
				textField.setText("");
				JOptionPane.showMessageDialog(null, "Spielername darf nicht mehr als 14 Zeichen haben!", "Dein Spielername ist zu lang!", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		//Input von btnVerlassen
		if (src == btnVerlassen){
			System.out.println("Login: btnVerlassen");
			System.exit(-1);
		}
		
	}

}
