package ellinx.game.solar;

import java.awt.Graphics;
import java.awt.Image;

public class SolarFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/Sun.jpg",600,500);
	
	Planet mercury = new Planet(sun, "images/Mercury.jpg", 100, 80, 0.15);
	Planet venus = new Planet(sun, "images/Venus.jpg", 150, 100, 0.12);
	Planet earth = new Planet(sun, "images/Earth.jpg", 200, 120, 0.1);
	Planet mars = new Planet(sun, "images/Mars.jpg", 240, 160, 0.09);
	Planet jupiter = new Planet(sun, "images/Jupiter.jpg", 300, 240, 0.05);
	Planet saturn = new Planet(sun, "images/Saturn.jpg", 400, 320, 0.01);
	Planet uranus = new Planet(sun, "images/Uranus.jpg", 120, 80, 0.1);
	Planet neptune = new Planet(sun, "images/Neptune.jpg", 120, 80, 0.1);
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		
		sun.draw(g);
		
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
