package board;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import player.Player;
import processing.Chronometer;

public class Gui_game extends JFrame implements Runnable {

	private Chronometer chrono = new Chronometer();
	
	private Player player1 = new Player(40,40,"Jules"), player2 = new Player(160,40,"Julie"),player3 = new Player(40, 120, "Lolita");
	
	private JPanel mapSection, rightSection, particularSection, infoSection, list_need, list_actions, list_buttonAction, action;
	
	private JButton perso1, perso2, perso3, addaction, delaction;
	
	private String firstname = "";
	private JLabel infosPerso = new JLabel("Information:");
	protected JLabel name = new JLabel("Nom :");
	protected JLabel name_perso = new JLabel(firstname);
	private JLabel needs = new JLabel ("Besoins :");
	private JLabel energy = new JLabel ("Energie :");
	private JLabel health = new JLabel ("Santé :");
	private JLabel hygiene = new JLabel ("Hygiène :");
	private JLabel humeur = new JLabel ("Humeur :");
	private JLabel bienetre = new JLabel ("Bien-être");
	
	private JProgressBar energybar, healthbar, hygienebar, humeurbar;
	
	private JTabbedPane tab;
	private JList<String> zoneActions;
	private DefaultListModel<String> liste;
	
	private int en = 0, hu = 0, hy = 0,sa = 0;
	
	/*Setters permettant de changer les valeurs des progressbar*/ 
	
	public void setEn(int en) {
		this.en = en;
	}
	
	public void setHu(int hu) {
		this.hu = hu;
	}
	
	public void setHy(int hy) {
		this.hy = hy;
	}
	
	public void setSa(int sa) {
		this.sa = sa;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public Gui_game() {
		initPerso();
		initSectionMap();
		initSectionDroite();
		
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(mapSection, BorderLayout.CENTER);
		this.getContentPane().add(rightSection, BorderLayout.EAST);
		
		this.addWindowListener(new actionFermer());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setResizable(false);
		setVisible(true);
	}
	
	// permet d'initialiser la carte
	public void initSectionMap() {
		mapSection = new TestPoly(player1,player2,player3);

	}
	
	// permet d'afficher les informations relative à un personnage
	public void initSectionDroite() {
		rightSection = new JPanel();
		particularSection = new JPanel();
		particularSection.setLayout(new FlowLayout());
		rightSection.setLayout(new GridLayout (4, 1));
		initInfos();
		initSectionBesoin();
		
		
		perso1 = new JButton("Perso1");
		perso2 = new JButton("Perso2");
		perso3 = new JButton("Perso3");
		
		perso1.addActionListener(new acessPerso1());
		perso2.addActionListener(new acessPerso2());
		perso3.addActionListener(new acessPerso3());

		
		/*personnage_1.setSize(100, 30);
		personnage_2.setSize(100, 30);
		personnage_3.setSize(100, 30);
		*/
		//initActions();
		
		particularSection.add(perso1);
		particularSection.add(perso2);
		particularSection.add(perso3);
		
		//rightSection.add(chronometer, BorderLayout.NORTH);
		rightSection.add(infoSection);
		rightSection.add(tab);
		rightSection.add(particularSection, BorderLayout.CENTER);
		rightSection.setSize(100,500);
	}
	
	public void initInfos() {
		
		infoSection = new JPanel();
		infoSection.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		
		b.gridx = 0;
		b.gridy = 0;
		infoSection.add(name, b);
		
		b.gridx = 1;
		b.gridy = 0;
		infoSection.add(name_perso, b);
		
		b.gridx = 0;
		b.gridy = 1;
		infoSection.add(bienetre, b);
		
		/*b.gridx = 1;
		b.gridy = 1;
		sectionInfos.add(, b);
		*/
		
	}
	
	public void initSectionBesoin() {
		list_need = new JPanel();
		list_actions = new JPanel();
		list_buttonAction = new JPanel();
		action = new JPanel();
		
		
		energybar = new JProgressBar();
		healthbar = new JProgressBar();
		humeurbar = new JProgressBar();
		hygienebar = new JProgressBar();
		
		tab = new JTabbedPane();

		list_actions.setLayout(new GridLayout());
		list_need.setLayout(new GridBagLayout());
		list_buttonAction.setLayout(new FlowLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		list_need.add(energy, c);
		
		c.gridx = 0;
		c.gridy = 1;
		list_need.add(health, c);
		
		c.gridx = 0;
		c.gridy = 2;
		list_need.add(hygiene, c);
		
		c.gridx = 0;
		c.gridy = 3;
		list_need.add(humeur, c);
		
		//ajout des barres
		
		energybar.setValue(en);
		c.gridx = 1;
		c.gridy = 0;
		list_need.add(energybar, c);
		
		healthbar.setValue(sa);
		c.gridx = 1;
		c.gridy = 1;
		list_need.add(healthbar, c);
		
		hygienebar.setValue(hy);
		c.gridx = 1;
		c.gridy = 2;
		list_need.add(hygienebar, c);
		
		humeurbar.setValue(hu);
		c.gridx = 1;
		c.gridy = 3;
		list_need.add(humeurbar, c);
		
		
		tab.addTab("Besoin", list_need);
		
		addaction = new JButton("Ajouter");
		delaction = new JButton("Supprimer");
		
		liste = new DefaultListModel<String>();
		zoneActions = new JList<String>(liste);
        zoneActions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        zoneActions.setLayoutOrientation(JList.VERTICAL);
		
		
		list_buttonAction.add(addaction);
		list_buttonAction.add(delaction);
		list_actions.add(list_buttonAction);
		list_actions.add(zoneActions);
		
		tab.addTab("Actions", list_actions);
	}
	
	
	public void initPerso() {
		//initialisation du 1er personnage
		player1.setEnergy(80);
		player1.setHealth(50);
		player1.setHumeur(40);
		player1.setHygiene(70);
		player1.setLieu("home");
		
		//initialisation du 2e personnage
		player2.setEnergy(70);
		player2.setHealth(60);
		player2.setHumeur(80);
		player2.setHygiene(50);
		player2.setLieu("cinéma");
		
		//initialisation du 3e personnage
		player3.setEnergy(90);
		player3.setHealth(70);
		player3.setHumeur(90);
		player3.setHygiene(60);
		player3.setLieu("restaurant");
		
	}
	
	
	public class acessPerso1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new Infos(player1);
		}
		
	}
	
	public class acessPerso2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new Infos(player2);
		}
		
	}
	
	
	public class acessPerso3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new Infos(player3);
		}
		
	}
	
	
	
	public class actionFermer implements WindowListener {
		
		public void windowClosing(WindowEvent e) {
			int exit = JOptionPane.showConfirmDialog(null,  "Voulez vous quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
			if(exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			
		}
		
		public void windowActivated(WindowEvent e) {}
		
		public void windowClosed(WindowEvent e) {}
		
		public void windowDeactivated(WindowEvent e){}
		
		public void windowDeiconified(WindowEvent e) {}
		
		public void windowIconified(WindowEvent e) {}
		
		public void windowOpened(WindowEvent e) {}
		
	}
	
	public void setList(Player player) {
		
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) 
	{
		new Gui_game ();
	}
}
