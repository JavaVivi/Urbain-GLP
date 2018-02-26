package assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display;
import Assets;

public class Sprite {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Sprite(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	//create a new frame and set the assets
	
	private void init(){
		display = new Display(title, width, height);
		Assets.init();
	}
	
	private void tick(){
		
	}
	//create the canvas, you call the sprite part you want to display
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		g.drawImage(Assets.sprite_name ( ex : face1 ), 10 ( size for width ), 10 ( size for height ), null);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	//run the frame
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
		}
		
		stop();
		
	}
	//open the frame's window
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	//close the frame's window
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
