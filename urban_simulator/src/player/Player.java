package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import assets.ImageLoader;
import processing.Point;
import processing.Route;
/**
 * 
 * @author François-Laurent, Ryan
 *
 */
public class Player {

	private int health = 100;
	private int humour = 100;
	private int energy = 100;
	private int hygiene = 100;
	private int x;
	private int y;
	private String name;
	private String lieu;
	private String acte;
	private Action action;
	private Deplacement dep;
	private Graphics g;
	
	public Player(int x, int y, String name) 
	{
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public void update()
	{
		render (g);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(x, y,20,20);
		g.dispose();
	}
	/*retourne la valeur de santé*/
	public int getHealth() 
	{
		return health;
	}
	/*initialise la valeur de santé */
	public void setHealth(int health) 
	{
		this.health = health;
	}
	/*retourne la valeur de l'humeur*/
	public int getHumour() 
	{
		return humour;
	}
	/*initialise la valeur de l'humeur*/
	public void setHumeur(int humeur) 
	{
		this.humour = humeur;
	}
	/*retourne la valeur de l'énergie*/
	public int getEnergy() 
	{
		return energy;
	}
	/*initialise l'énergie*/
	public void setEnergy(int energy) 
	{
		this.energy = energy;
	}
	/*retourne la valeur de l'hygiene*/
	public int getHygiene() 
	{
		return hygiene;
	}
	/*initialise l'hygiene*/
	public void setHygiene(int hygiene) 
	{
		this.hygiene = hygiene;
	}
	/*initialise la valeur de la position horizontale*/
	public void setX(int x) {
		this.x =x;
	}
	/*initialise la valeur de la position verticale*/
	public void setY(int y) {
		this.y =y;
	}
	/*initialise le nom*/
	public void setName(String name) {
		this.name = name;
	}
	/*initialise le lieu de position*/
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	/*retourne la position horizontale*/
	public int getX() {
		return x;
	}
	/*retourne la position verticale*/
	public int getY() {
		return y;
	}
	/*retourne le nom*/
	public String getName() {
		return name;
	}
	/*retourne le lieu de la position*/
	public String getLieu() {
		return lieu;
	}
	/* initialise la position*/
	public void setAction(Action action) {
		this.action = action;
	}
	/*initialise le parcours pour une action*/
	public void setAct(String deplacement) {
		this.acte = deplacement;
	}
	/*Permet de déplacement*/
	public void Deplacement() {
		if (acte == "work") {
			dep.goWork(this);
		}
		if (acte == "sport") {
			dep.goSport(this);
		}
		if (acte == "home") {
			dep.goHome(this);
		}
		if (acte == "cine") {
			dep.goCine(this);
		}
		if (acte == "concert") {
			dep.goConcert(this);
		}
	}
	/*permet d'automatiser des actions au personnage*/
	public void Action () {
		
		if (energy<=10) {
			
			action.dormir(this);
			
		}
		
		if (health<=10) {
		
			action.manger(this);
		}
		
		if (humour<=10) {
		
			
		}
		if ((hygiene<=10)&&(lieu == "home")) {
		
			action.douche(this);
		}
	}
	
	
}
