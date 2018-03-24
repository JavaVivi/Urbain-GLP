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

	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public int getHumour() 
	{
		return humour;
	}

	public void setHumeur(int humeur) 
	{
		this.humour = humeur;
	}

	public int getEnergy() 
	{
		return energy;
	}

	public void setEnergy(int energy) 
	{
		this.energy = energy;
	}

	public int getHygiene() 
	{
		return hygiene;
	}

	public void setHygiene(int hygiene) 
	{
		this.hygiene = hygiene;
	}
	
	public void setX(int x) {
		this.x =x;
	}
	public void setY(int y) {
		this.y =y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLieu() {
		return lieu;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public void tick() {
		
	}
	
	public void Deplacement() {
		
		dep.goWork(this);
		
	}
	
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
