package data;

import assets.Assets;
import processing.Point;
import processing.Trajectory;

public class Place {

	private String name;
	private Point uL, uR, dL, dR;//points des angles
	private Trajectory paths = new Trajectory();
	private Assets image;//surement inutile
	protected String[] actionPossible;
	private int nbAction = 0;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Point getH1() {
		return uL;
	}
	
	public void setH1(Point h1) {
		this.uL = h1;
	}
	
	public Point getH2() {
		return uR;
	}
	
	public void setH2(Point h2) {
		this.uR = h2;
	}
	
	public Point getB1() {
		return dL;
	}
	
	public void setB1(Point b1) {
		this.dL = b1;
	}
	
	public Point getB2() {
		return dR;
	}
	
	public void setB2(Point b2) {
		this.dR = b2;
	}
	
	public Trajectory getPaths() {
		return paths;
	}
	
	public void setPaths(Trajectory paths) {
		this.paths = paths;
	}

	public void addAction(String action) {
		if (nbAction != actionPossible.length) {
			actionPossible[nbAction] = action;
			nbAction++;
		}
	}
}

