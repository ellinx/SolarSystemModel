package ellinx.game.solar;

import java.awt.Graphics;
import java.awt.Image;

public class SolarFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/teddybear0.png",300,300);
	Planet earth = new Planet(sun, "images/teddybear0.png", 120, 80, 0.1);
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		
		sun.draw(g);
		earth.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
