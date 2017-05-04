package ellinx.game.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * move to any direction
 * @author lxu
 *
 */
public class GameFrame03 extends Frame {
	
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
	private double degree=3.14/3; //[0,2pi]
	private double speed = 10;
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		
		if (speed>0) {
			speed -= 0.1;
		} else {
			speed = 0;
		}
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (y>500-15 || y<20) {
			degree = -degree;
		}
		if (x<0 || x>500-15) {
			degree = Math.PI-degree;
		}
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
		GameFrame03 gf = new GameFrame03();
		gf.launchFrame();
	}
	
}
