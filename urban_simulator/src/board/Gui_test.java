package board;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

import asset.Display;
import processing.Chrono;

/**
 * @author François-Laurent
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
	
	
	protected JLabel infos_personnage = new JLabel ("Information :");
	protected JLabel name = new JLabel("Nom :");
	protected JLabel needs = new JLabel ("Besoins :");
	protected JLabel energy = new JLabel ("Energie :");
	protected JLabel health = new JLabel ("Santé :");
	protected JLabel hygiene = new JLabel ("Hygiène :");
	protected JLabel humeur = new JLabel ("Humeur");
	protected JLabel bienetre = new JLabel ("Bien-Être");
	
	protected JProgressBar barenergie, barsante, barhygiene, barhum;
	
	private JTabbedPane tab;
	private Display map;
	private Chrono chronometer;
	
	
	
	
	public Gui_test(String titre) {
		
		
		initSectionMap();
		initSectionDroite();
		
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(mapSection, BorderLayout.CENTER);
		this.getContentPane().add(rightSection, BorderLayout.EAST);
		
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
		
		//sectionDroite.add(infos_personnage);
		
		
		personnage_1 = new JButton("Perso1");
		personnage_2 = new JButton("Perso2");
		personnage_3 = new JButton("Perso3");
		
		personnage_1.setSize(100, 30);
		personnage_2.setSize(100, 30);
		personnage_3.setSize(100, 30);
		
		particularSection.add(personnage_1);
		particularSection.add(personnage_2);
		particularSection.add(personnage_3);
		
		rightSection.add(hourSection, BorderLayout.NORTH);
		rightSection.add(infoSection);
		rightSection.add(tab);
		rightSection.add(particularSection, BorderLayout.CENTER);
		rightSection.setSize(100,500);
	}
	
	/**
	 * characters infos
	 */
	
	public void initInfos() {
		
		infoSection = new JPanel();
		infoSection.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		
		b.gridx = 0;
		b.gridy = 0;
		infoSection.add(name, b);
		
		/*b.gridx = 1;
		b.gridy = 0;
		sectionInfos.add(, b);
		*/
		
		
		b.gridx = 0;
		b.gridy = 1;
		infoSection.add(bienetre, b);
		
		/*b.gridx = 1;
		b.gridy = 1;
		sectionInfos.add(, b);
		*/
		
	}
	
	/**
	 * set progressBar with the stats
	 */
	
	public void initSectionBesoin() {
		
		list_need = new JPanel();
		list_actions = new JPanel();
		list_buttonAction = new JPanel();
		action = new JPanel();
		
		int en, hu, hy,sa;
		
		en = 100;
		hu = 70;
		hy = 50;
		sa = 60;
		
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
		
		list_buttonAction.add(addaction);
		list_buttonAction.add(delaction);
		list_actions.add(list_buttonAction);
		
		tab.addTab("Actions", list_actions);
		
		
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
