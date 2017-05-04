package ellinx.game.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {
	
	Image img = GameUtil.getImage("images/teddybear0.png");
	
	public void launchFrame() {
		//window size and location
		setSize(500, 500);
		setLocation(100, 100);
		
		//default is invisible
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	private double x=100,y=100;
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		
		Font f = new Font("Big",Font.BOLD,50);
		g.setFont(f);
		g.drawString("HaHa!", 200, 200);
		
		g.fillRect(100, 100, 20, 20);
		
		Color original = g.getColor();
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(original);
		
		g.drawImage(img, (int)x, (int)y, null);
		
		x += 3;
	}

	/**
	 * repaint window thread, it's an inner class
	 * @author lxu
	 *
	 */
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
}
