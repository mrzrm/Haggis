package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
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

public class Gui extends JFrame {
	
	//test
	
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
	
	public ImageIcon yellow2 = new ImageIcon(Gui.class.getResource("/images/gelb02.jpg"));
	private JButton btnPassen;
	private JButton btnAusspielen;
	private JButton btnSort;
	boolean state = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setResizable(false);
		setTitle("Haggis Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(640, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_mycards = new JPanel();
		panel_mycards.setMinimumSize(new Dimension(608, 280));
		panel_mycards.setMaximumSize(new Dimension(608, 280));
		panel_mycards.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_mycards.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_mycards.setPreferredSize(new Dimension(609, 280));
		panel_mycards.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_spieler1 = new JPanel();
		panel_spieler1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_spieler2 = new JPanel();
		panel_spieler2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_mycards, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_spieler1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_spieler2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_spieler2, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_spieler1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel_mycards, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(new GridLayout(2, 2, 2, 2));
		
		btnAusspielen = new JButton("Ausspielen");
		btnAusspielen.setActionCommand("Ausspielen");
		panel_1.add(btnAusspielen);
		
		
		btnPassen = new JButton("Passen");
		panel_1.add(btnPassen);
		
		btnSort = new JButton("Farbe sortieren");
		panel_1.add(btnSort);
		btnSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (state){
					
					// Methode für nach Farbe sortieren hier einfügen
					btnSort.setText("Rang sortieren");
					state = false;
					
				}
				else{
										
					// Methode für nach Rang sortieren hier einfügen
					btnSort.setText("Farbe sortieren");
					state = true;
				}

				
				
			}
		});
		
		JLabel lblSpieler_1 = new JLabel("Spieler 2");
		lblSpieler_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpieler_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_spieler2.add(lblSpieler_1);
		
		JLabel lblSpieler = new JLabel("Spieler 1");
		lblSpieler.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSpieler.setHorizontalAlignment(SwingConstants.LEFT);
		panel_spieler1.add(lblSpieler);
		panel_mycards.setLayout(new GridLayout(2, 7, 0, 0));
		
		btn1 = new JToggleButton("");
		btn1.setPreferredSize(new Dimension(87, 140));
		panel_mycards.add(btn1);
		btn1.setIcon(yellow2);
		
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
		contentPane.setLayout(gl_contentPane);
		
		btnListener btnl1 = new btnListener();
		
		
	}
	
	
	public class btnListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			
			
			
		}
		
	}
}
