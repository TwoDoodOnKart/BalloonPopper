package com.anvil.balloongame;

import com.anvil.balloongame.state.MainMenu;
import com.anvil.balloongame.state.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Controls the program execution. Creates the program window and
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code batch - SpriteBatch} - The OpenGL texture batch that the game uses.</li>
 * <li>{@code sm - StateManager} - The StateManager that controsl program flow.</li>
 * </ol>
 * 
 * @author Edward Wang, Isaac Wong
 * @version 1 05.12.16
 */
public class GameDriver extends ApplicationAdapter {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

	private SpriteBatch batch;
	private StateManager sm;

	/**
	 * Called at the creation of this object. Instantiates the texture batch to be used for rendering, and immediately
	 * starts the main menu. The custom cursor for the game is instantiated.
	 * <p>
	 * Local Variables
	 * <ol>
	 * <li>{@code c - Pixmap} - Pixel map representing the custom cursor.</li>
	 * </ol>
	 */
	public void create () {
		// Custom Cursor
		Pixmap c = new Pixmap (Gdx.files.internal ("data/Cursor.png"));
		System.out.println (c.getFormat () == Format.RGBA8888);
		Gdx.graphics.setCursor (Gdx.graphics.newCursor (c, 0, 0));
		c.dispose ();

		Gdx.gl.glClearColor (1, 1, 1, 1);
		sm = new StateManager ();
		batch = new SpriteBatch ();

		sm.push (new MainMenu (sm, batch));
	}

	/**
	 * Called at every frame of the program rendering loop. Clears the game window, then calls on the
	 * {@code StateManager} to render the current {@code State}.
	 */
	public void render () {
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		sm.update (Gdx.graphics.getDeltaTime ());
		sm.render (batch);
	}

	/**
	 * Called when this object is terminated. It will release system resources used by elements of the game.
	 */
	public void dispose () {
		batch.dispose ();
	}
}
