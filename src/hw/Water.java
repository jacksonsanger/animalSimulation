package hw;

import java.awt.Color;
import edu.du.dudraw.Draw;

public class Water extends TerrainTile {

	public Water(GridPoint location) {
		super(location);
	}

	// Draw water in a dark blue color
	@Override
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(new Color(0,100,255));
	}
	
	@Override
	public int getVeg() {
		// Water is vegetated
		return 0;
	}

	@Override
	public int getBumpy() {
		// Water is fairly smooth
		return 0;
	}

	@Override
	public int getWet() {
		// Water is very wet
		return 0;
	}
}
