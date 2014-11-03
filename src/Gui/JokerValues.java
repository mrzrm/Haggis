package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;

import server.Karte;
import server.Karte.Farbe;

public class JokerValues extends JFrame {
	
	private int jokerWert = 0;
	private Karte.Farbe jokerFarbe = null;
	
	private JPanel contentPane;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_10;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_13;
	private JRadioButton rdbtn_rot;
	private JRadioButton rdbtn_gruen;
	private JRadioButton rdbtn_gelb;
	private JRadioButton rdbtn_grau;
	private JButton btnOk;
	private int wert;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JokerValues frame = new JokerValues();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JokerValues(int wert, Farbe farbe) {
		this.wert = wert;
		setResizable(false);
		setTitle("Jokerwert bestimmen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_top = new JPanel();
		contentPane.add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblWert = new JLabel("Wert");
		lblWert.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(lblWert);

		JLabel lblFarbe = new JLabel("Farbe");
		lblFarbe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFarbe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(lblFarbe);

		JPanel panel_middle = new JPanel();
		contentPane.add(panel_middle, BorderLayout.CENTER);
		panel_middle.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_m_left = new JPanel();
		panel_m_left.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_middle.add(panel_m_left);
		panel_m_left.setLayout(new GridLayout(0, 2, 0, 0));

		radioButton_2 = new JRadioButton("2");
		panel_m_left.add(radioButton_2);

		radioButton_3 = new JRadioButton("3");
		panel_m_left.add(radioButton_3);

		radioButton_4 = new JRadioButton("4");
		panel_m_left.add(radioButton_4);

		radioButton_5 = new JRadioButton("5");
		panel_m_left.add(radioButton_5);

		radioButton_6 = new JRadioButton("6");
		panel_m_left.add(radioButton_6);

		radioButton_7 = new JRadioButton("7");
		panel_m_left.add(radioButton_7);

		radioButton_8 = new JRadioButton("8");
		panel_m_left.add(radioButton_8);

		radioButton_9 = new JRadioButton("9");
		panel_m_left.add(radioButton_9);

		radioButton_10 = new JRadioButton("10");
		panel_m_left.add(radioButton_10);

		radioButton_11 = new JRadioButton("11");
		panel_m_left.add(radioButton_11);

		radioButton_12 = new JRadioButton("12");
		panel_m_left.add(radioButton_12);

		radioButton_13 = new JRadioButton("13");
		panel_m_left.add(radioButton_13);

		// Buttons dem RadioListener hinzüfügen
		RadioListener rl1 = new RadioListener();
		radioButton_2.addActionListener(rl1);
		radioButton_3.addActionListener(rl1);
		radioButton_4.addActionListener(rl1);
		radioButton_5.addActionListener(rl1);
		radioButton_6.addActionListener(rl1);
		radioButton_7.addActionListener(rl1);
		radioButton_8.addActionListener(rl1);
		radioButton_9.addActionListener(rl1);
		radioButton_10.addActionListener(rl1);
		radioButton_11.addActionListener(rl1);
		radioButton_12.addActionListener(rl1);
		radioButton_13.addActionListener(rl1);

		// group the radio buttons on the left
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton_2);
		group.add(radioButton_3);
		group.add(radioButton_4);
		group.add(radioButton_5);
		group.add(radioButton_6);
		group.add(radioButton_7);
		group.add(radioButton_8);
		group.add(radioButton_9);
		group.add(radioButton_10);
		group.add(radioButton_11);
		group.add(radioButton_12);
		group.add(radioButton_13);

		JPanel panel_m_right = new JPanel();
		panel_m_right.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_middle.add(panel_m_right);
		panel_m_right.setLayout(new GridLayout(0, 1, 0, 0));

		rdbtn_rot = new JRadioButton("rot    ");
		rdbtn_rot.setHorizontalAlignment(SwingConstants.CENTER);
		panel_m_right.add(rdbtn_rot);

		rdbtn_grau = new JRadioButton("grau ");
		rdbtn_grau.setHorizontalAlignment(SwingConstants.CENTER);
		panel_m_right.add(rdbtn_grau);

		rdbtn_gruen = new JRadioButton("gruen");
		rdbtn_gruen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_m_right.add(rdbtn_gruen);

		rdbtn_gelb = new JRadioButton("gelb   ");
		rdbtn_gelb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_m_right.add(rdbtn_gelb);
		
		// RadioButtons dem RadioListenerFarbe hinzufügen
		RadioListenerFarbe rlf1 = new RadioListenerFarbe();
		rdbtn_rot.addActionListener(rlf1);
		rdbtn_grau.addActionListener(rlf1);
		rdbtn_gruen.addActionListener(rlf1);
		rdbtn_gelb.addActionListener(rlf1);
		
		// group the radio buttons on the left
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtn_rot);
		group2.add(rdbtn_grau);
		group2.add(rdbtn_gruen);
		group2.add(rdbtn_gelb);

		JPanel panel_down = new JPanel();
		contentPane.add(panel_down, BorderLayout.SOUTH);

		btnOk = new JButton("OK");
		okListener ol1 = new okListener();
		btnOk.addActionListener(ol1);
		panel_down.add(btnOk);
	}

	public class RadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton radio = (JRadioButton) e.getSource();
			int iRadio = Integer.parseInt(radio.getText());

			switch (iRadio) {

			case 2:
				System.out.println("Selected 2");
				jokerWert = 2;
				break;
			case 3:
				System.out.println("Selected 3");
				jokerWert = 3;
				break;
			case 4:
				System.out.println("Selected 4");
				jokerWert = 4;
				break;
			case 5:
				System.out.println("Selected 5");
				jokerWert = 5;
				break;
			case 6:
				System.out.println("Selected 6");
				jokerWert = 6;
				break;
			case 7:
				System.out.println("Selected 7");
				jokerWert = 7;
				break;
			case 8:
				System.out.println("Selected 8");
				jokerWert = 8;
				break;
			case 9:
				System.out.println("Selected 9");
				jokerWert = 9;
				break;
			case 10:
				System.out.println("Selected 10");
				jokerWert = 10;
				break;
			case 11:
				System.out.println("Selected 11");
				jokerWert = 11;
				break;
			case 12:
				System.out.println("Selected 12");
				jokerWert = 12;
				break;
			case 13:
				System.out.println("Selected 13");
				jokerWert = 13;
				break;
			default:
				System.out.println("fehler: Selected wert");
				jokerWert = 0;
				break;
			}

		}

	}
	
	public class RadioListenerFarbe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton radio2 = (JRadioButton) e.getSource();
			String sRadio2 = radio2.getText();
			
			switch (sRadio2) {

			case "rot    ":
				System.out.println("Selected rot");
				jokerFarbe = Karte.Farbe.RED;
				break;
			case "grau ":
				System.out.println("Selected grau");
				jokerFarbe = Karte.Farbe.GREY;
				break;
			case "gruen":
				System.out.println("Selected gruen");
				jokerFarbe = Karte.Farbe.GREEN;
				break;
			case "gelb   ":
				System.out.println("Selected gelb");
				jokerFarbe = Karte.Farbe.YELLOW;
				break;
			default:
				System.out.println("fehler: Selected farbe");
				jokerFarbe = null;
				break;
			}

			
		}
		
	}
	
	public class okListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnOk){
				System.out.println("Button OK gedrückt");
				
				if(jokerWert == 0){
					javax.swing.JOptionPane.showMessageDialog(null,"Bitte einen Jokerwert auswählen!");
				
				}
				else if(jokerFarbe == null){
					javax.swing.JOptionPane.showMessageDialog(null,"Bitte eine Jokerfarbe auswählen!");
				}
				
				else{
					System.out.println("jokervalues " + wert);
					
					setJokerWert(jokerWert);
//					Karte.setWert(jokerWert);
					setJokerFarbe(jokerFarbe);
					System.out.println("jokervalues " + jokerWert);

//					Gui.alTmp.get(0).setWert(wert);
//					System.out.println("jovervalues altmp"+ Gui.alTmp.get(0).getWert() );
//					
//					ArrayList<Karte> temp = new ArrayList<Karte>();
//					temp = Gui.alTmp;
//					System.out.println(Gui.alTmp.get(0).getWert());
//					for (int i = 0; i <= temp.size()-1; i++){
//						System.out.println("joker value for");
//						if (temp.get(i).getWert() == wert){
//							temp.get(i).setWert(jokerWert);
//							temp.get(9).setFarbe(jokerFarbe);
//							System.out.println("jokerValue: " +temp.get(i).getWert());
//							System.out.println("jokerValue:" +temp.get(i).getFarbe());
//						}
//					}
//					Gui.alTmp = temp;
					dispose();
				}
			}
		}
	}

	public int getJokerWert() {
		return jokerWert;
	}

	public void setJokerWert(int jokerWert) {
		this.jokerWert = jokerWert;
	}

	public Karte.Farbe getJokerFarbe() {
		return jokerFarbe;
	}

	public void setJokerFarbe(Karte.Farbe jokerFarbe) {
		this.jokerFarbe = jokerFarbe;
	}

}
