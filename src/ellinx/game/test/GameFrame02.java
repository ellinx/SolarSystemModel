package ellinx.game.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * move up and down
 * @author lxu
 *
 */
public class GameFrame02 extends Frame {
	
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
	private boolean left;
	private boolean up;
	
	@Override
	public void paint(Graphics g) {
		
		
		g.drawImage(img, (int)x, (int)y, null);
		
		/*if (left) {
			x -= 5;
		} else {
			x += 5;
		}
		if (x>500-15) {
			left = true;
		} 
		if (x<0){
			left = false;
		}*/
		
		
		if (up) {
			y -= 5;
		} else {
			y += 5;
		}
		if (y>500-15) {
			up = true;
		} 
		if (y<20){
			up = false;
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
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
	
}
