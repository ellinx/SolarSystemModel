package ellinx.game.solar;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
	
	
	/**
	 * loading window
	 */
	public void launchFrame() {
		//window size and location
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
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
}
