package ch.epfl.cs107.play.game.arpg.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.arpg.ARPGBehavior;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

abstract public class ARPGArea extends Area {
	private Window window;
	private float CAMERA_SCALE_FACTOR = 13f;
	private ARPGBehavior behavior;
	/**
	 * Create the area by adding all its actors
	 * called by the begin method, when the area starts to play
	 */
	protected abstract void createArea();

	@Override
	public boolean begin(Window window, FileSystem fileSystem) {
		this.window = window;
		if (super.begin(window, fileSystem)) {
			// Set the behavior map
			behavior = new ARPGBehavior(window , getTitle ());
			setBehavior(behavior);
			createArea();
			return true;
		}
		return false;
	}


	@Override
	public float getCameraScaleFactor(){
		return CAMERA_SCALE_FACTOR ;
	}

	//public ARPGCellType getType(int x, int y) { return behavior.getType(x,y);}

}