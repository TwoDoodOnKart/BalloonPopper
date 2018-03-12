package com.anvil.balloongame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.anvil.balloongame.GameDriver;

/**
 * The Driver class for the Balloon Poppers project for the Windows platform.
 * 
 * @author LIBGDX, modified by Edward Wang
 */
public class DesktopLauncher {

	/**
	 * Sets the video configuration of the game and runs it in a Windows environment.
	 * 
	 * @param args
	 *            String command-line arguments, not used.
	 */
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration ();
		config.width = 1200;
		config.height = 800;
		new LwjglApplication (new GameDriver (), config);
	}
}
