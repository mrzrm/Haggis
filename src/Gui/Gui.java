package Gui;
//test kevin
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.border.SoftBevelBorder;

import server.Deck;
import server.Karte;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

public class Gui extends JFrame {
	
	// JPanel Content Pane
	private JPanel contentPane;
	
	// JToggleButtons meine Kartenhand
	private JKartenButton<Karte> btn1;
	private JKartenButton<Karte> btn3;
	private JKartenButton<Karte> btn2;
	private JKartenButton<Karte> btn4;
	private JKartenButton<Karte> btn5;
	private JKartenButton<Karte> btn6;
	private JKartenButton<Karte> btn7;
	private JKartenButton<Karte> btn8;
	private JKartenButton<Karte> btn9;
	private JKartenButton<Karte> btn10;
	private JKartenButton<Karte> btn11;
	private JKartenButton<Karte> btn12;
	private JKartenButton<Karte> btn13;
	private JKartenButton<Karte> btn14;
	
	// ArrayLists für die JToggleButtons
	public static ArrayList<JKartenButton<Karte>> alKarten = new ArrayList<JKartenButton<Karte>>();
	public static ArrayList<JKartenButton<Karte>> alJoker = new ArrayList<JKartenButton<Karte>>();
	public static ArrayList<JKartenButton<Karte>> alAlleKarten = new ArrayList<JKartenButton<Karte>>();
	
	// Bube, Dame, König Icons laden
	public ImageIcon iibube = new ImageIcon(Gui.class.getResource("/images/special/Bube.jpg"));
	public ImageIcon iidame = new ImageIcon(Gui.class.getResource("/images/special/Dame.jpg"));
	public ImageIcon iikoenig = new ImageIcon(Gui.class.getResource("/images/special/König.jpg"));
	
	// JButtons
	public static JButton btnPassen;
	public static JButton btnAusspielen;
	
	
	// JToggleButtons Bube, Dame, König 
	private JKartenButton<Karte> btnp1dame;
	private JKartenButton<Karte> btnp1koenig;
	private JKartenButton<Karte> btnp1bube;
	
	
	// JLabels
	public static JLabel lblp2bube;
	public static JLabel lblp2dame;
	public static JLabel lblp2koenig;
	public static JLabel lblSpieler1;
	public static JLabel lblSpieler2;
	public static JLabel jlStatus;
	
	// JPanels
	private JPanel p2joker;
	private JPanel panel_status;
	private JPanel panel_Spielfeld;
	private JPanel panel_mycards;
	private JPanel panel_spieler2;
	private JPanel panel_spieler1;
	private JPanel p1joker;
	private JPanel btnPanel;
	
	// JLabel Kartentisch
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	
	// ArrayList für die JLabels auf dem Kartentisch
	public static ArrayList<JLabel> alKartenTisch = new ArrayList<JLabel>();
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Gui frame = new Gui();
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
	public Gui() {
		setResizable(false);
		setTitle("Haggis Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 620);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(640, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_Spielfeld = new JPanel();
		panel_Spielfeld.setMaximumSize(new Dimension(611, 298));
		panel_Spielfeld.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_mycards = new JPanel();
		panel_mycards.setMinimumSize(new Dimension(608, 280));
		panel_mycards.setMaximumSize(new Dimension(608, 280));
		panel_mycards.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_mycards.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_mycards.setPreferredSize(new Dimension(609, 280));
		panel_mycards.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_spieler1 = new JPanel();
		panel_spieler1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_spieler2 = new JPanel();
		panel_spieler2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnPanel = new JPanel();
		btnPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		p1joker = new JPanel();
		p1joker.setMaximumSize(new Dimension(228, 123));
		p1joker.setMinimumSize(new Dimension(228, 123));
		p1joker.setPreferredSize(new Dimension(228, 123));
		
		p2joker = new JPanel();
		
		panel_status = new JPanel();
		panel_status.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_Spielfeld, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
						.addComponent(panel_mycards, GroupLayout.PREFERRED_SIZE, 611, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_spieler2, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(p2joker, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
						.addComponent(panel_status, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(p1joker, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(panel_spieler1, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_spieler2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(p2joker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(panel_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_Spielfeld, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_spieler1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(p1joker, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_mycards, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_Spielfeld.setLayout(new GridLayout(0, 7, 0, 0));
		
		lbl1 = new JLabel("");
		lbl1.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl10);
		
		lbl11 = new JLabel("");
		lbl11.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl11);
		
		lbl12 = new JLabel("");
		lbl12.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl12);
		
		lbl13 = new JLabel("");
		lbl13.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl13);
		
		lbl14 = new JLabel("");
		lbl14.setPreferredSize(new Dimension(87, 140));
		panel_Spielfeld.add(lbl14);
		
		// Alle JLabel dem alKartenTisch Array hinzufügen
		alKartenTisch.add(lbl1);
		alKartenTisch.add(lbl2);
		alKartenTisch.add(lbl3);
		alKartenTisch.add(lbl4);
		alKartenTisch.add(lbl5);
		alKartenTisch.add(lbl6);
		alKartenTisch.add(lbl7);
		alKartenTisch.add(lbl8);
		alKartenTisch.add(lbl9);
		alKartenTisch.add(lbl10);
		alKartenTisch.add(lbl11);
		alKartenTisch.add(lbl12);
		alKartenTisch.add(lbl13);
		alKartenTisch.add(lbl14);
		
		
		
		// Statusleiste erstellen
		panel_status.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jlStatus = new JLabel("Auf Mitspieler warten ...");
		jlStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_status.add(jlStatus);
		
	
		
		
		// Bube im Spieler 1 panel
		btnp1bube = new JKartenButton<Karte>();
		btnp1bube.setPreferredSize(new Dimension(87, 140));
		p1joker.add(btnp1bube);
		btnp1bube.setIcon(iibube);
		
		
		// Dame im Spieler 1 panel
		btnp1dame = new JKartenButton<Karte>();
		btnp1dame.setPreferredSize(new Dimension(87, 140));
		p1joker.add(btnp1dame);  
		btnp1dame.setIcon(iidame);
		
		// König im Spieler 1 panel
		btnp1koenig = new JKartenButton<Karte>();
		btnp1koenig.setPreferredSize(new Dimension(87, 140));
		p1joker.add(btnp1koenig); 
		btnp1koenig.setIcon(iikoenig);
		
		
		// Player 2 - Joker panel
		lblp2bube = new JLabel("");
		lblp2bube.setPreferredSize(new Dimension(87, 140));
		p2joker.add(lblp2bube);
		lblp2bube.setIcon(iibube);
		
		lblp2dame = new JLabel("");
		lblp2dame.setPreferredSize(new Dimension(87, 140));
		p2joker.add(lblp2dame);
		lblp2dame.setIcon(iidame);
				
		lblp2koenig = new JLabel("");
		lblp2koenig.setPreferredSize(new Dimension(87, 140));
		p2joker.add(lblp2koenig);
		lblp2koenig.setIcon(iikoenig);
				
		
		p1joker.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// JButton Ausspielen erstellen
		btnAusspielen = new JButton("Ausspielen");
		btnAusspielen.setEnabled(false);
		btnAusspielen.setActionCommand("Ausspielen");
		btnPanel.add(btnAusspielen);
		
		// JButton Passen erstellen
		btnPassen = new JButton("Passen");
		btnPassen.setEnabled(false);
		btnPanel.add(btnPassen);
		
		// JLabel Spieler 2 erstellen
		lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpieler2.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_spieler2.add(lblSpieler2);
		
		// JLabel Spieler 1 erstellen
		lblSpieler1 = new JLabel("Spieler 1");
		lblSpieler1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSpieler1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_spieler1.add(lblSpieler1);
		panel_mycards.setLayout(new GridLayout(2, 7, 0, 0));
		
		// Karten JToggleButtons erstellen
		btn1 = new JKartenButton<Karte>();
		btn1.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn1);
						
		btn2 = new JKartenButton<Karte>();
		btn2.setPreferredSize(new Dimension(87, 140));
		btn2.setSize(new Dimension(87, 140));
		panel_mycards.add(btn2);
				
		btn3 = new JKartenButton<Karte>();
		btn3.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn3);
				
		btn4 = new JKartenButton<Karte>();
		btn4.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn4);
				
		btn5 = new JKartenButton<Karte>();
		btn5.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn5);
				
		btn6 = new JKartenButton<Karte>();
		btn6.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn6);
				
		btn7 = new JKartenButton<Karte>();
		btn7.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn7);
				
		btn8 = new JKartenButton<Karte>();
		btn8.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn8);
				
		btn9 = new JKartenButton<Karte>();
		btn9.setSize(new Dimension(87, 140));
		btn9.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn9);
				
		btn10 = new JKartenButton<Karte>();
		btn10.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn10);
				
		btn11 = new JKartenButton<Karte>();
		btn11.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn11);
				
		btn12 = new JKartenButton<Karte>();
		btn12.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn12);
				
		btn13 = new JKartenButton<Karte>();
		btn13.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn13);
				
		btn14 = new JKartenButton<Karte>();
		btn14.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn14);
				
		// Karten Array alKarten mit JToggleButtons füllen
		alKarten.add(btn1);
		alKarten.add(btn2);
		alKarten.add(btn3);
		alKarten.add(btn4);
		alKarten.add(btn5);
		alKarten.add(btn6);
		alKarten.add(btn7);
		alKarten.add(btn8);
		alKarten.add(btn9);
		alKarten.add(btn10);
		alKarten.add(btn11);
		alKarten.add(btn12);
		alKarten.add(btn13);
		alKarten.add(btn14);
		
		alJoker.add(btnp1bube);
		alJoker.add(btnp1dame);
		alJoker.add(btnp1koenig);
		
		alAlleKarten.addAll(alKarten);
		alAlleKarten.addAll(alJoker);
		
		
		contentPane.setLayout(gl_contentPane);
		
		// ----- Buttons dem ItemListener übergeben -----
		// Alle JToggleButtons Karten dem ItemListener übergeben
		btnListener btnl1 = new btnListener();
		for(int k = 0; k < alKarten.size(); k++){
			alKarten.get(k).addItemListener(btnl1);
		}
		// Alle JToggleButtons Joker dem Item Listener übergeben
		for(int l = 0; l < alJoker.size(); l++){
			alJoker.get(l).addItemListener(btnl1);
		}
		
		// ----- Buttons dem ActionListener übergeben -----
		actnListener actnl1 = new actnListener();
		btnPassen.addActionListener(actnl1);
		btnAusspielen.addActionListener(actnl1);
		
		
	}
	
	public class actnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == btnAusspielen){
				System.out.println("Button: Ausspielen");
				
				// ----- HIER CODE EINFÜGEN UM AUSZUSPIELEN -----
				
				ArrayList<JKartenButton<Karte>> selectedButtons = new ArrayList<JKartenButton<Karte>>();
				// welche Karten sind alle selektiert?
				for (int z = 0; z < alAlleKarten.size(); z++){
					if(alAlleKarten.get(z).isSelected()){
						selectedButtons.add(alAlleKarten.get(z));
					}
					
				}
				
				// Selektiere Karten in die alTmp ArrayList
				ArrayList<Karte> alTmp = new ArrayList<Karte>();
				
				for (int b = 0; b < selectedButtons.size(); b++){
					alTmp.add(selectedButtons.get(b).getKarte());
				}
				
				
				
				
				// Hier Code einfügen um Pass zu verifizieren ;-)
				// Verifikation müsste etwa so aussehen:
//				boolean verify = false;
//				verify = zugVerifizieren.verify(alTmp, Client.m.gespielteKarten);
				
				
				
				
				
				// Selektierte Karten auf Spielfeld anzeigen lassen
				for (int a = 0; a < selectedButtons.size(); a++){
					alKartenTisch.get(a).setIcon(selectedButtons.get(a).getIcon());
					selectedButtons.get(a).setVisible(false);
				}
							
				// Wenn Joker gespielt worden sind, diese aus MasterObjekt entfernen
								
				if (Client.clientId == 0){
					Karte[] temp = new Karte[3];
					temp = Client.m.getKartenJoker1();
					for (int g = 0; g < selectedButtons.size(); g++){
						
						if(selectedButtons.get(g).getKarte().getWert() == 11){
							temp[0] = null;
							System.out.println("Bube p1 entfernt");
						}
						if(selectedButtons.get(g).getKarte().getWert() == 12){
							temp[1] = null;
						}
						if(selectedButtons.get(g).getKarte().getWert() == 13){
							temp[2] = null;
						}
						Client.m.setKartenJoker1(temp);
					}
				} else {
					Karte[] temp2 = new Karte[3];
					temp2 = Client.m.getKartenJoker2();
					for (int g = 0; g < selectedButtons.size(); g++) {

						if (selectedButtons.get(g).getKarte().getWert() == 11) {
							temp2[0] = null;
							System.out.println("Bube p2 entfernt");
						}
						if (selectedButtons.get(g).getKarte().getWert() == 12) {
							temp2[1] = null;
						}
						if (selectedButtons.get(g).getKarte().getWert() == 13) {
							temp2[2] = null;
						}
					}
					Client.m.setKartenJoker2(temp2);
					
				}

				// Alle karten deselektieren
				for (int w = 0; w < alAlleKarten.size(); w++){
					if(alAlleKarten.get(w).isSelected()){
						alAlleKarten.get(w).setSelected(false);
					}
				}
				
				
				
				
				Client.m.setGespielteKarten(alTmp);
				Client.sendObjectToServer();
				selectedButtons.clear();
				alTmp.clear();
			}
			
			if(e.getSource() == btnPassen){
				System.out.println("Button: Passen");
				
				// HIER CODE EINFÜGEN UM ZU PASSEN
				Client.m.setPasst(true);
				Client.sendObjectToServer();
			}
			
		}
		
	}
	
	public class btnListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			// Wenn eine Karte (JToggleButton) ausgewählt wird, wird er
			// hervorgehoben
			for (int x = 0; x < alKarten.size(); x++) {
				if (e.getSource() == alKarten.get(x)) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Border selectedBorder = new LineBorder(Color.BLUE, 6);
						alKarten.get(x).setBorder(selectedBorder);
						System.out.println("Karte Selected:" + x);
					}
					else if (e.getStateChange() == ItemEvent.DESELECTED) {
						Border deselectedBorder = new LineBorder(Color.GRAY, 1);
						alKarten.get(x).setBorder(deselectedBorder);
						System.out.println("Karte Deselected:" + x);
					}
				}
			}
			for (int y = 0; y < alJoker.size(); y++) {
				if (e.getSource() == alJoker.get(y)) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Border selectedBorder = new LineBorder(Color.BLUE, 6);
						alJoker.get(y).setBorder(selectedBorder);
						System.out.println("Joker Selected:" + y);
					}
					else if (e.getStateChange() == ItemEvent.DESELECTED) {
						Border deselectedBorder = new LineBorder(Color.GRAY, 1);
						alJoker.get(y).setBorder(deselectedBorder);
						System.out.println("Joker Deselected:" + y);
					}
				}
			}
		}
	}
	
	public class JKartenButton<Karte> extends JToggleButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Karte karte;

		public Karte getKarte() {
			return this.karte;
		}

		public void setKarte(Karte karte) {
			this.karte = karte;
		}
	}

}
