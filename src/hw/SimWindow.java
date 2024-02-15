package hw;

import java.awt.Color;
import java.util.ArrayList;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class SimWindow {
	
	// Some static constants that everyone can use
	//   the represent the window size
	public static int windowWidth = 1050;
	public static int windowHeight = 700;
	
	private TerrainMap tm;
	private ArrayList<Avatar> theAvatars;
	private Draw duDwin;
	
	private boolean paused;
	
	public SimWindow(TerrainMap tm) {
		
		 // Setup the DuDraw window
        duDwin = new Draw("Path DuDraw"); // The OO version of DUDraw
        duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
        duDwin.enableDoubleBuffering(); // Too slow otherwise -- need to use .show() later
        
        // Set the scale of the window
        // Right now it is set to match the pixels
        duDwin.setXscale(0, SimWindow.windowWidth);
		duDwin.setYscale(0, SimWindow.windowHeight);
        
		this.tm = tm;
		
		// Empty list of avatars
		this.theAvatars = new ArrayList<Avatar>();
		
		this.paused = false;
	}
	
	// Add the avatars 1 by 1
	public void addAvatar(Avatar a) {
		//TODO: Add avatar
	}


	public void update() {
		duDwin.clear(Color.white);  // Clear in white
		
		// Draw the board
		tm.draw(duDwin);
		
		// TODO: Draw the avatar
		
		duDwin.show();  // used in double buffering
	}
	
	public void runSimulation() {
		// This is the main game loop
		update(); // Initial positing
		
		while(true) {
			
				if (!paused) {
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// TODO: Avatar movement here
				// update();
			}
		}
		
	}
}