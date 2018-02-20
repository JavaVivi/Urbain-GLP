package board;

import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;


/**
 * @author François-Laurent
 *
 */

public class Gui_test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel sectionGauche;
	protected JPanel sectionMap;
	protected JPanel sectionDroite;
	protected JPanel sectionHeure;
	protected JPanel sectionPersonnage;
	protected JPanel sectionInfos;
	protected JPanel liste_besoins;
	protected JPanel liste_actions;
	
	protected JButton personnage_1;
	protected JButton personnage_2;
	protected JButton personnage_3;
	
	protected JLabel chronometre = new JLabel("Heure : ");
	protected JLabel map = new JLabel("Map :");
	protected JLabel infos_personnage = new JLabel ("Information :");
	protected JLabel name = new JLabel("Nom :");
	protected JLabel besoins = new JLabel ("Besoins :");
	protected JLabel energie = new JLabel ("Energie :");
	protected JLabel sante = new JLabel ("Santé :");
	protected JLabel hygiene = new JLabel ("Hygiène :");
	protected JLabel humeur = new JLabel ("Humeur");
	protected JLabel bienetre = new JLabel ("Bien-Être");
	
	protected JProgressBar barenergie, barsante, barhygiene, barhum;
	
	private JTabbedPane tab;
	
	
	
	
	public Gui_test(String titre) {
		
		
		initSectionGauche();
		initSectionMap();
		initSectionDroite();
		
		this.setLayout(new GridLayout(1,3));
		
		this.getContentPane().add(sectionGauche);
		this.getContentPane().add(sectionMap);
		this.getContentPane().add(sectionDroite);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setResizable(false);
		setVisible(true);
		
		
	}
	
	
	public void initSectionGauche () {
		
		sectionGauche = new JPanel();
		sectionHeure = new JPanel();
		sectionPersonnage = new JPanel();
		
		sectionGauche.setLayout(new GridLayout(2,1));
		sectionPersonnage.setLayout(new GridLayout(3,1));
		
		sectionHeure.setSize(100, 100);
		sectionPersonnage.setSize(100, 100);
		
		personnage_1 = new JButton("Perso1");
		personnage_2 = new JButton("Perso2");
		personnage_3 = new JButton("Perso3");
		
		sectionHeure.add(chronometre);
		
		sectionPersonnage.add(personnage_1);
		sectionPersonnage.add(personnage_2);
		sectionPersonnage.add(personnage_3);
		
		sectionGauche.add(sectionHeure);
		sectionGauche.add(sectionPersonnage);
		sectionGauche.setSize(100, 500);

	}
	
	
	public void initSectionMap() {
		
		sectionMap = new JPanel();
		//sectionMap.add(map);
		sectionMap.setBackground(Color.BLACK);
		sectionMap.setSize(500, 500);
	}
	

	public void initSectionDroite() {
		
		sectionDroite = new JPanel();
		
		sectionDroite.setLayout(new GridLayout (3, 1));
		initInfos();
		initSectionBesoin();
		
		//sectionDroite.add(infos_personnage);
		sectionDroite.add(sectionInfos);
		sectionDroite.add(tab);
		sectionDroite.setSize(100,500);
		
	}
	
	public void initInfos() {
		
		sectionInfos = new JPanel();
		sectionInfos.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		
		b.gridx = 0;
		b.gridy = 0;
		sectionInfos.add(name, b);
		
		/*b.gridx = 1;
		b.gridy = 0;
		sectionInfos.add(, b);
		*/
		
		
		b.gridx = 0;
		b.gridy = 1;
		sectionInfos.add(bienetre, b);
		
		/*b.gridx = 1;
		b.gridy = 1;
		sectionInfos.add(, b);
		*/
		
	}
	
	
	public void initSectionBesoin() {
		
		liste_besoins = new JPanel();
		liste_actions = new JPanel();
		
		int en, hu, hy,sa;
		
		en = 90;
		hu = 70;
		hy = 50;
		sa = 60;
		
		barenergie = new JProgressBar();
		barsante = new JProgressBar();
		barhum = new JProgressBar();
		barhygiene = new JProgressBar();
		
		tab = new JTabbedPane();

		liste_besoins.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		liste_besoins.add(energie, c);
		
		c.gridx = 0;
		c.gridy = 1;
		liste_besoins.add(sante, c);
		
		c.gridx = 0;
		c.gridy = 2;
		liste_besoins.add(hygiene, c);
		
		c.gridx = 0;
		c.gridy = 3;
		liste_besoins.add(humeur, c);
		
		//ajout des barres
		
		barenergie.setValue(en);
		c.gridx = 1;
		c.gridy = 0;
		liste_besoins.add(barenergie, c);
		
		barsante.setValue(sa);
		c.gridx = 1;
		c.gridy = 1;
		liste_besoins.add(barsante, c);
		
		barhygiene.setValue(hy);
		c.gridx = 1;
		c.gridy = 2;
		liste_besoins.add(barhygiene, c);
		
		barhum.setValue(hu);
		c.gridx = 1;
		c.gridy = 3;
		liste_besoins.add(barhum, c);
		
		
		tab.addTab("Besoin", liste_besoins);
		tab.addTab("Actions", liste_actions);
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) 
	{
		new Gui_test ("Test d'Interface Graphique");
	}
}
