package ellinx.game.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Planet extends Star {
	
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;
	
	public void draw(Graphics g) {
		super.draw(g);
		drawTrace(g);
		move();
	}
	
	public void move() {
		x = center.x + center.width/2 + longAxis*Math.cos(degree);
		y = center.y + center.height/2 + shortAxis*Math.sin(degree);
		
		degree += speed;

	}
	
	public void drawTrace(Graphics g) {
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = center.x + center.width/2 - longAxis;
		ovalY = center.y + center.height/2 - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.black);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		
		g.setColor(c);
	}
	
	public Planet(Star center, String imgPath, double longAxis, double shortAxis, double speed) {
		
		super();
		this.center = center;
		this.img = GameUtil.getImage(imgPath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = center.x + longAxis;
		this.y  = center.y;
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
	}

	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
	}
}
