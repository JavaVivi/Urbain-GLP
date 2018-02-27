package processing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Chrono extends JPanel implements Runnable{

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static Font fontButton = new Font(Font.MONOSPACED, Font.PLAIN, 5);
	private static final int CHRONO_SPEED = 1000;
	private static Dimension DimButton = new Dimension(50,50);

	private static final long serialVersionUID = 1L;

	/**
	 * The core functional part : the chronometer.
	 */
	private Chronometer chronometer = new Chronometer();

	
	private JButton v3Button = new JButton(" >>> ");
	private JButton v2Button = new JButton(" >> ");
	private JButton v1Button = new JButton(" > ");
	private JButton v0Button = new JButton(" || ");
	
	private JLabel hourLabel = new JLabel(":");

	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");

	private JPanel control = new JPanel();
	private JPanel vitesse = new JPanel();

	/**
	 * This instance is used in the inner classes for different action listeners.
	 */
	
	private Chrono instance = this;

	/**
	 * Initial status of for the start button.
	 */
	private boolean stop = true;

	
	public Chrono() {
		updateValues();

		setLayout(new BorderLayout());

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		vitesse.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		hourValue.setFont(font);
		control.add(hourValue);
		hourLabel.setFont(font);
		control.add(hourLabel);
		minuteValue.setFont(font);
		control.add(minuteValue);

		v0Button.setPreferredSize(DimButton);
		v0Button.setFont(fontButton);
		v0Button.addActionListener(new PauseAction());
		vitesse.add(v0Button);
		
		v1Button.setPreferredSize(DimButton);
		v1Button.setFont(fontButton);
		v1Button.addActionListener(new Vitesse1Action());
		vitesse.add(v1Button);
		
		v2Button.setPreferredSize(DimButton);
		v2Button.setFont(fontButton);
		v2Button.addActionListener(new Vitesse2Action());
		vitesse.add(v2Button);
		
		v3Button.setPreferredSize(DimButton);
		v3Button.setFont(fontButton);
		v3Button.addActionListener(new Vitesse3Action());
		vitesse.add(v3Button);
		
		

		add(BorderLayout.CENTER, control);
		add(BorderLayout.SOUTH, vitesse);

	}

	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");


		
	}

	

	/**
	 * Defines what to do for each time unit (by default 1 second) : it increments the chronometer
	 */
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			updateValues();
		}
	}

	private class PauseAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
		}

	}

	
	private class Vitesse1Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = false;
			updateValues();
			Thread chronoThread = new Thread(instance);
			chronoThread.start();
			
		}

	}


	private class Vitesse2Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = false;
			updateValues();
			Thread chronoThread = new Thread(instance);
			chronoThread.start();
		}

	}

	private class Vitesse3Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = false;
			updateValues();
			Thread chronoThread = new Thread(instance);
			chronoThread.start();
		}

	}

	
	public void speed (int sp) {
		
		int fps;
		fps= 60;
		double timePerTick = 1000000000*sp / fps;
		double delta =0;
		long now;
		long lastTime = System.nanoTime();
		
		now = System.nanoTime();
		  delta += (now - lastTime) / timePerTick;
		  lastTime = now;
		  
		
	}
	
	
	
}
