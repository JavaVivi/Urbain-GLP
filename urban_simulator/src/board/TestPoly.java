package board;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPoly extends JPanel {
	
	Color brown =new Color(135,89,26);
	Color beige =new Color(255,222,117);
	Color violet =new Color(128,0,128);
	Color mauve =new Color(212,115,121);
	Color orange  =new Color(222,152,22);
	Color rose =new Color(252,93,93);
	Color beton =new Color(90,94,107);
	Color herbe =new Color(130,196,108);
	
	private boolean debug = false;
	public void paint (Graphics g) {
		g.setColor(herbe);
		g.fillRect(0,0, 600, 600);
		if (debug==true) {
			g.setColor(Color.BLACK);
			for (int i = 40; i <= 600; i += 40) {
				g.drawLine(i, 1, i, 600);
			}

			for (int i = 40; i <= 600; i += 40) {
				g.drawLine(1, i, 600, i);
			}
		}
		g.setColor(brown);
		g.fillRect(0, 0, 120,160 );
		g.fillRect(480, 400, 120, 120);
		g.setColor(beige);
		g.fillRect(360, 0, 120, 160);
		g.setColor(violet);
		g.fillRect(480, 0, 120, 160);
		g.setColor(rose);
		g.fillRect(440,240, 160, 160);
		g.setColor(orange);
		g.fillRect(160, 40, 160, 120);
		g.setColor(beton);
		g.fillRect(120, 280, 200, 200);
		g.setColor(Color.GRAY);
		g.fillRect(40, 160, 40, 400);
		g.fillRect(40, 520, 560, 40);
		g.fillRect(40, 200, 560, 40);
		g.fillRect(360, 240, 40, 360);
		g.fillRect(240, 160, 40, 40);
		g.fillRect(400, 160, 40, 40);
		g.fillRect(520, 160, 40, 40);
		g.fillRect(400, 320, 40, 40);
		g.fillRect(200, 480, 40, 40);
		g.dispose();
		
	}

	public void setDebug(int i) {
		if (i==0) {
		debug=true;	
		}
	}
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.add(new TestPoly());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(40, 40, 800, 640);
		frame.setVisible(true);
		
	}
}
