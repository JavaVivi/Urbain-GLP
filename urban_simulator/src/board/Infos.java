package board;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import player.Player;

public class Infos extends JFrame {

private JPanel infoSection;
private JPanel list_need;
private JPanel list_buttonAction;
private JTabbedPane tab;
private JProgressBar hygienebar;
private JProgressBar humeurbar;
private JProgressBar healthbar;
private JProgressBar energybar;
private int en;
private int sa;
private int hy;
private int hu;
private JList<String> zoneActions;
private DefaultListModel<String> liste;
private JButton addaction;
private JButton delaction;
private JPanel list_actions;
private JPanel action;
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

private Color bn;


public Infos(Player player) {
	this.firstname = player.getName();
	this.en = player.getEnergy();
	this.sa = player.getHealth();
	this.hy = player.getHygiene();
	this.hu = player.getHumour();
	liste = new DefaultListModel<String>();
	setList(player);
	initInfos();
	initBesoin();
	this.getContentPane().add(infoSection);
	this.getContentPane().add(tab);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setResizable(false);
	setVisible(true);
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
	
	public void initBesoin() {
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
		
		zoneActions = new JList<String>(liste);
        zoneActions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        zoneActions.setLayoutOrientation(JList.VERTICAL);
		
		
		list_buttonAction.add(addaction);
		list_buttonAction.add(delaction);
		list_actions.add(list_buttonAction);
		list_actions.add(zoneActions);
		
		tab.addTab("Actions", list_actions);
	}

public void setList(Player player) {
	
	String place = player.getLieu();
	
	if(place == "home") {
		
		liste.addElement("manger/boire");
		liste.addElement("dormir");
		liste.addElement("prendre une douche");
		liste.addElement("dormir");
		liste.addElement("aller au travail");
		liste.addElement("aller au cinéma");
		liste.addElement("aller au concert");
		liste.addElement("aller à la salle de sport");
		liste.addElement("aller au restaurant");
	}
	else { 
		if(place == "work") {
			
		}
		else {
			if(place == "restaurant") {
				
			}
			else {
				if(place == "concert") {
					
				}
				else {
					if(place == "cine") {
						
					}
					else {
						if(place == "salle de sport") {
							
						}
					}
				}
			}
		}
	}
	
		
	}
}
