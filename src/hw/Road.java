package hw;

import java.awt.Color;
import edu.du.dudraw.Draw;

public class Road extends TerrainTile {
	
	public Road(GridPoint location) {
		super(location);
	}

	@Override
	public void setColor(Draw duDwin) {
		// Roads are drawn in yellow
		duDwin.setPenColor(Color.yellow);
	}

	@Override
	public int getVeg() {
		// TODO:// Roads have very little vegetation 
		return 0;
	}

	@Override
	public int getBumpy() {
		// // TODO:Roads are smooth
		return 0;
	}

	@Override
	public int getWet() {
		// // TODO: Roads aren't wet
		return 0;
	}
}
