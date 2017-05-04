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
public class GameFrame05 extends MyFrame {
	
	Image img = GameUtil.getImage("images/teddybear0.png");
	

	private double x=100,y=100; //center position
	private double degree=0; //[0,2pi]
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		
		
		x = 300 + 200*Math.cos(degree);
		y = 300 + 150*Math.sin(degree);
		
		degree += 0.1;
	}



	public static void main(String[] args) {
		GameFrame05 gf = new GameFrame05();
		gf.launchFrame();
	}
	
}
