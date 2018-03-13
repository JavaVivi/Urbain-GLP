package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Gui_test;

public class Gui_accueil_test extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton newGame;
	protected JButton charger;
	protected JButton quit;
	private Dimension dimButton = new Dimension(100,50);
	private Insets btn = new Insets(0,0,0,0); 
	
	protected JPanel buttonPanel, sidePane;
	
	Gui_accueil_test(String titre){
		
		setLayout(new BorderLayout());
		center();
		initActions();
		
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);
		setVisible(true);
	}
	
	
	public void center() {
		
		newGame = new JButton("New Game");//invButt(newGame);
		charger = new JButton("Charger");//invButt(charger);
		quit = new JButton("Quit");//invButt(quit);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		
		b.gridx =0;
		b.gridy =0;
		buttonPanel.add(newGame,b);
		
		b.gridx =0;
		b.gridy =1;
		buttonPanel.add(charger,b);
		
		b.gridx =0;
		b.gridy =2;
		buttonPanel.add(quit,b);
		
	}
	
	protected void initActions() {
		newGame.addActionListener(new createGame());
		charger.addActionListener(new chargeGame());
		quit.addActionListener(new quitGame(this));
	}
	
	/*permet de personnaliser les boutons*/
	public void invButt(JButton button) {
		/*button.setOpaque(false);
		button.setContentAreaFilled(false);*/
		button.setBackground(Color.gray);
		button.setBorderPainted(false);
		button.setPreferredSize(dimButton);
		button.setMargin(btn);
		
	}
	
	/*Permettra de passer une interface qui initialise une partie*/
	public class createGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
		}
		
		
	}
	/*permettra de choisir une déja sauvegarder*/
	public class chargeGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			new Gui_test("playGame");
		}
		
		
	}
	
	/*permet de quitter l'application*/
	public class quitGame implements ActionListener{

		private JFrame window;
		
		public  quitGame (JFrame window) {
			this.window = window;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			window.dispose();
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{
		new Gui_accueil_test("Test d'Interface Graphique");
	}
	
	
}
