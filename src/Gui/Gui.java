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

public class Gui extends JFrame {
	
		
	private JPanel contentPane;
	private JToggleButton btn1;
	private JToggleButton btn3;
	private JToggleButton btn2;
	private JToggleButton btn4;
	private JToggleButton btn5;
	private JToggleButton btn6;
	private JToggleButton btn7;
	private JToggleButton btn8;
	private JToggleButton btn9;
	private JToggleButton btn10;
	private JToggleButton btn11;
	private JToggleButton btn12;
	private JToggleButton btn13;
	private JToggleButton btn14;
	
	// ArrayLists für die JToggleButtons
	public static ArrayList<JToggleButton> alKarten = new ArrayList<JToggleButton>();
	public static ArrayList<JToggleButton> alJoker = new ArrayList<JToggleButton>();
	
	public ImageIcon iibube = new ImageIcon(Gui.class.getResource("/images/special/Bube.jpg"));
	public ImageIcon iidame = new ImageIcon(Gui.class.getResource("/images/special/Dame.jpg"));
	public ImageIcon iikoenig = new ImageIcon(Gui.class.getResource("/images/special/König.jpg"));
	
	// JButtons
	public static JButton btnPassen;
	public static JButton btnAusspielen;
	
	
	// JToggleButtons Bube, Dame, König 
	private JToggleButton btnp1dame;
	private JToggleButton btnp1koenig;
	private JToggleButton btnp1bube;
	
	
	// JLabels
	private JLabel btnp2bube;
	private JLabel btnp2dame;
	private JLabel btnp2koenig;
	public static JLabel lblSpieler1;
	public static JLabel lblSpieler2;
	public static JLabel jlStatus;
	
	// JPanels
	private JPanel p2joker;
	private JPanel panel_status;
	private JPanel panel;
	private JPanel panel_mycards;
	private JPanel panel_spieler2;
	private JPanel panel_spieler1;
	private JPanel p1joker;
	private JPanel btnPanel;
	
	
	
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
		setBounds(100, 100, 930, 600);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(640, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(panel_mycards, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 604, Short.MAX_VALUE)
						.addComponent(panel_status, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(p2joker, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
						.addComponent(panel_spieler2, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addComponent(p1joker, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addComponent(panel_spieler1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_spieler2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(p2joker, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_spieler1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(p1joker, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_mycards, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		panel_status.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jlStatus = new JLabel("Auf Mitspieler warten ...");
		jlStatus.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_status.add(jlStatus);
		
	
		
		
		// Bube im Spieler 1 panel
		btnp1bube = new JToggleButton("");
		btnp1bube.setPreferredSize(new Dimension(76, 123));
		p1joker.add(btnp1bube);
		
		Image iibubeimage =  iibube.getImage();
		Image newimg = iibubeimage.getScaledInstance(76, 123, java.awt.Image.SCALE_SMOOTH); 
		ImageIcon iibube2 = new ImageIcon(newimg);  
		btnp1bube.setIcon(iibube2);
		
		
		// Dame im Spieler 1 panel
		btnp1dame = new JToggleButton("");
		btnp1dame.setPreferredSize(new Dimension(76, 123));
		p1joker.add(btnp1dame);
		
		Image iidameimage =  iidame.getImage();
		Image newimg2 = iidameimage.getScaledInstance(76, 123, java.awt.Image.SCALE_SMOOTH); 
		ImageIcon iidame2 = new ImageIcon(newimg2);  
		btnp1dame.setIcon(iidame2);
		
		// König im Spieler 1 panel
		btnp1koenig = new JToggleButton("");
		btnp1koenig.setPreferredSize(new Dimension(76, 123));
		p1joker.add(btnp1koenig);
		
		Image iikoenigimage =  iikoenig.getImage();
		Image newimg3 = iikoenigimage.getScaledInstance(76, 123, java.awt.Image.SCALE_SMOOTH); 
		ImageIcon iikoenig2 = new ImageIcon(newimg3);  
		btnp1koenig.setIcon(iikoenig2);
		
		
		// p1joker panel
		//
		btnp2bube = new JLabel("");
		btnp2bube.setPreferredSize(new Dimension(76, 123));
		p2joker.add(btnp2bube);
		btnp2bube.setIcon(iibube2);
		
		btnp2dame = new JLabel("");
		btnp2dame.setFocusCycleRoot(true);
		btnp2dame.setPreferredSize(new Dimension(76, 123));
		p2joker.add(btnp2dame);
		btnp2dame.setIcon(iidame2);
				
		btnp2koenig = new JLabel("");
		btnp2koenig.setPreferredSize(new Dimension(76, 123));
		p2joker.add(btnp2koenig);
		btnp2koenig.setIcon(iikoenig2);
				
		
		p1joker.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAusspielen = new JButton("Ausspielen");
		btnAusspielen.setActionCommand("Ausspielen");
		btnPanel.add(btnAusspielen);
		
		
		btnPassen = new JButton("Passen");
		btnPanel.add(btnPassen);
		
		lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpieler2.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_spieler2.add(lblSpieler2);
		
		lblSpieler1 = new JLabel("Spieler 1");
		lblSpieler1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSpieler1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_spieler1.add(lblSpieler1);
		panel_mycards.setLayout(new GridLayout(2, 7, 0, 0));
		
		// Karten JToggleButtons erstellen
		btn1 = new JToggleButton("");
		btn1.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn1);
						
		btn2 = new JToggleButton("");
		btn2.setPreferredSize(new Dimension(87, 140));
		btn2.setSize(new Dimension(87, 140));
		panel_mycards.add(btn2);
				
		btn3 = new JToggleButton("");
		btn3.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn3);
				
		btn4 = new JToggleButton("");
		btn4.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn4);
				
		btn5 = new JToggleButton("");
		btn5.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn5);
				
		btn6 = new JToggleButton("");
		btn6.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn6);
				
		btn7 = new JToggleButton("");
		btn7.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn7);
				
		btn8 = new JToggleButton("");
		btn8.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn8);
				
		btn9 = new JToggleButton("");
		btn9.setSize(new Dimension(87, 140));
		btn9.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn9);
				
		btn10 = new JToggleButton("");
		btn10.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn10);
				
		btn11 = new JToggleButton("");
		btn11.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn11);
				
		btn12 = new JToggleButton("");
		btn12.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn12);
				
		btn13 = new JToggleButton("");
		btn13.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn13);
				
		btn14 = new JToggleButton("");
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
				// HIER CODE EINFÜGEN UM AUSZUSPIELEN
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
}
