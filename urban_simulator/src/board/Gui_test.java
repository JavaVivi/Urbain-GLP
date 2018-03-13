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

import assets.Display;
import processing.Chrono;

/**
 * @author FranÃ§ois-Laurent
 *
 */

public class Gui_test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel mapSection;
	protected JPanel rightSection;
	protected JPanel particularSection;
	protected JPanel infoSection;
	protected JPanel list_need;
	protected JPanel list_actions;
	protected JPanel list_buttonAction;
	protected JPanel action;
	
	protected JButton personnage_1;
	protected JButton personnage_2;
	protected JButton personnage_3;
	protected JButton addaction;
	protected JButton delaction;
	
	private String firstname = "";
	
	protected JLabel infos_personnage = new JLabel ("Information :");
	protected JLabel name = new JLabel("Nom :");
	protected JLabel name_perso = new JLabel(firstname);
	protected JLabel needs = new JLabel ("Besoins :");
	protected JLabel energy = new JLabel ("Energie :");
	protected JLabel health = new JLabel ("Santé :");
	protected JLabel hygiene = new JLabel ("Hygiène :");
	protected JLabel humeur = new JLabel ("Humeur :");
	protected JLabel bienetre = new JLabel ("Bien-être");
	
	protected JProgressBar barenergie, barsante, barhygiene, barhum;
	
	
	private JTabbedPane tab;
	private Display map;
	private Chrono chronometer;
	
	private JList<String> zoneActions;
	private DefaultListModel<String> liste;

	private int en=0 ,hu=0 ,hy=0 ,sa =0 ;
	
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setChronometer(Chrono chronometer) {
		this.chronometer = chronometer;
	}
	
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
	
	public Gui_test(String titre) {
		
		
		initSectionMap();
		initSectionDroite();
		
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(mapSection, BorderLayout.CENTER);
		this.getContentPane().add(rightSection, BorderLayout.EAST);
		
		this.addWindowListener(new ActionFermer());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setResizable(false);
		setVisible(true);
	}
	
	
	
	
	/**
	 * initialisation de la map 
	 */
	
	public void initSectionMap() {
		
		mapSection = new JPanel();
		
		map = new Display(400,400);
		
		mapSection.add(map);
		
		mapSection.setSize(500, 500);
	}
	
	/**
	 * ajout des parties relatives aux personnages + heure 
	 */

	public void initSectionDroite() {
		
		rightSection = new JPanel();
		chronometer = new Chrono();
		particularSection = new JPanel();
		particularSection.setLayout(new FlowLayout());
		rightSection.setLayout(new GridLayout (4, 1));
		initInfos();
		initSectionBesoin();
		
		
		personnage_1 = new JButton("Perso1");
		personnage_2 = new JButton("Perso2");
		personnage_3 = new JButton("Perso3");
		
		/*personnage_1.setSize(100, 30);
		personnage_2.setSize(100, 30);
		personnage_3.setSize(100, 30);
		*/
		initActions();
		
		particularSection.add(personnage_1);
		particularSection.add(personnage_2);
		particularSection.add(personnage_3);
		
		rightSection.add(chronometer, BorderLayout.NORTH);
		rightSection.add(infoSection);
		rightSection.add(tab);
		rightSection.add(particularSection, BorderLayout.CENTER);
		rightSection.setSize(100,500);
	}
	
	protected void initActions() {
		personnage_1.addActionListener(new acessPerso1());
		personnage_2.addActionListener(new acessPerso2());
		personnage_3.addActionListener(new acessPerso3());
	}
	
	/**
	 * 
	 * characters infos
	 */
	
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
	
	/**
	 * afficher les caractéristiques du personnage actuel 
	 */
	public void initSectionBesoin() {
		
		list_need = new JPanel();
		list_actions = new JPanel();
		list_buttonAction = new JPanel();
		action = new JPanel();
		
		
		barenergie = new JProgressBar();
		barsante = new JProgressBar();
		barhum = new JProgressBar();
		barhygiene = new JProgressBar();
		
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
		
		barenergie.setValue(en);
		c.gridx = 1;
		c.gridy = 0;
		list_need.add(barenergie, c);
		
		barsante.setValue(sa);
		c.gridx = 1;
		c.gridy = 1;
		list_need.add(barsante, c);
		
		barhygiene.setValue(hy);
		c.gridx = 1;
		c.gridy = 2;
		list_need.add(barhygiene, c);
		
		barhum.setValue(hu);
		c.gridx = 1;
		c.gridy = 3;
		list_need.add(barhum, c);
		
		
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
	
	/*Permat d'acceder au 1er personnage*/
	
	public class acessPerso1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setFirstname("Pedro");
			setEn(90);
			setHu(50);
			setHy(20);
			setSa(30);	
			
		}
		
	}
	/*Permat d'acceder au 2eme personnage*/
	public class acessPerso2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setFirstname("Jules");
			setEn(70);
			setHu(40);
			setHy(10);
			setSa(20);
			
		}
		
	}
	
	/*Permat d'acceder au 3eme personnage*/
	public class acessPerso3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setFirstname("Laura");
			setEn(50);
			setHu(40);
			setHy(70);
			setSa(50);
			
		}	
	
	}
	
	class ActionFermer implements WindowListener
	{
		public void windowClosing(WindowEvent e)
		{
			int exit = JOptionPane.showConfirmDialog(null,  "Voulez vous quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
			if(exit == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		//Les propriétés qui suivent sont obligatoires (Interface implémentée) mais nous ne les utiliserons pas
		public void windowActivated(WindowEvent e) 
		{			
		}

		public void windowClosed(WindowEvent e) 
		{			
		}

		public void windowDeactivated(WindowEvent e) 
		{			
		}

		public void windowDeiconified(WindowEvent e) 
		{			
		}

		public void windowIconified(WindowEvent e) 
		{			
		}

		public void windowOpened(WindowEvent e) 
		{			
		}
	}
	
	
		//récupère la position du personne permettant de montrer le nombre d'actions possibles dans un lieu particulier
	public void setList(/*Personnage*/) {
		
		/*int position = personnage.position;
		*Place lieuActuel = listeLieux[position];
		*
		*
		*
		*liste.addElement(lieuActuel.actionPossible);*/
		
	}

	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		new Gui_test ("Test d'Interface Graphique");
	}
}
