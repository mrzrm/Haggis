package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
		setBounds(100, 100, 350, 340);
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
		panel_center.add(textField);
		textField.setColumns(10);
		
		lblmaxZeichen = new JLabel("(max.12 Zeichen)");
		panel_center.add(lblmaxZeichen);
		
		panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		
		lblCoverImage = new JLabel("");
		panel_north.add(lblCoverImage);
		lblCoverImage.setIcon(cover);
		
		
		panel_south = new JPanel();
		contentPane.add(panel_south, BorderLayout.SOUTH);
		
		btnSpielStarten = new JButton("Spiel starten");
		panel_south.add(btnSpielStarten);
		
		btnVerlassen = new JButton("Verlassen");
		btnVerlassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		panel_south.add(btnVerlassen);
	}

}
