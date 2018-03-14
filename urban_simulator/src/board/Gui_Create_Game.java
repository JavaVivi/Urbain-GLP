package board;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import assets.ImageLoader;
import assets.SpriteSheet;

/**
 * 
 * @author François-Laurent
 *
 */
public class Gui_Create_Game extends JFrame {

	protected JLabel name = new JLabel("Nom :");
	protected JPanel rightSection, saisiSection, buttonSection, persoSelection;
	private JTextField nameField;
	private JButton check,personnage_1,personnage_2,personnage_3, play;
	private JRadioButton boy_1Button, boy_2Button, girl_Button;
	
	private static final int width = 15, height = 16;
	public static BufferedImage boy1, boy2, girl;
	
	
	public Gui_Create_Game() {
		this.setLayout(new BorderLayout());
		initSectionDroite();
		initPersoSelectionSection();
		
		this.getContentPane().add(rightSection, BorderLayout.EAST);
		this.getContentPane().add(persoSelection, BorderLayout.WEST);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);
		
	}
	
	public void initSectionDroite() {
		rightSection = new JPanel();
		saisiSection = new JPanel();
		buttonSection = new JPanel();
		
		saisiSection.setLayout(new FlowLayout());
		buttonSection.setLayout(new FlowLayout());
		initSaisiSection();
		initButtonSection();
		rightSection.setLayout(new GridLayout(3,1));
		play = new JButton("JOUER");
		rightSection.add(saisiSection);
		rightSection.add(buttonSection);
		rightSection.add(play);
	}
	
	public void initSaisiSection() {
		nameField = new JTextField (10);
		check = new JButton("Valider");
		saisiSection.add(name);
		saisiSection.add(nameField);
		saisiSection.add(check);
		
	}
	
	public void initButtonSection() {
		personnage_1 = new JButton("Perso1");
		personnage_2 = new JButton("Perso2");
		personnage_3 = new JButton("Perso3");
		
		buttonSection.add(personnage_1);
		buttonSection.add(personnage_2);
		buttonSection.add(personnage_3);
		
	}
	
	public void initPersoSelectionSection() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/images/character1.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/images/character2.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/images/character3.png"));
		
		boy1 = sheet1.crop(0, 0, width, height);
		girl = sheet2.crop(0, 0, width, height);
		boy2 = sheet3.crop(0, 0, width, height);
		
		Image b1 = boy1;
		
		JRadioButton boy_1Button = new JRadioButton("boy_1");
		boy_1Button.setSelected(true);

	    JRadioButton boy_2Button = new JRadioButton("boy_2");

	    JRadioButton girl_Button = new JRadioButton("girl");
	    
	
	    	    
	    /*Register a listener for the radio buttons.
	    boy_1Button.addActionListener(this);
	    boy_2Button.addActionListener(this);
	    girl_Button.addActionListener(this);
		*/
	    
	    persoSelection = new JPanel();
	    
	    /*persoSelection.add(girl);
	    persoSelection.add(b1);
	    persoSelection.add(boy2);*/
	    persoSelection.add(girl_Button);
	    persoSelection.add(boy_1Button);
	    persoSelection.add(boy_2Button);
		
	}
	
	/*
	public void actionPerformed(ActionEvent e) {
		picture.setIcon(new ImageIcon("images/" 
				+ e.getActionCommand() 
				+ ".gif"));
	*/
	public static void main(String[] args) {
		new Gui_Create_Game ();
	}
	
}
