package ellinx.game.solar;

import java.awt.Graphics;
import java.awt.Image;

public class Star {
	Image img;
	double x,y;
	
	double width,height; //width and height of the picture itself
	
	public Star() {
		
	}
	
	public Star(Image img) {
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
		
		
	}
	
	public Star(String imgPath, double x, double y) {
		this(GameUtil.getImage(imgPath), x, y);
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
}
