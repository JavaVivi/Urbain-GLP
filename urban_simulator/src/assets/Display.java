package assets;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Display {

	private Canvas canvas;
	
	private int width, height;
	
	public Display( int width, int height){
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	//create a frame to display the images
	
	private void createDisplay(){
		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		add(canvas);
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	
	
	
	
	
}
