package com.anvil.balloongame.state;

import com.anvil.balloongame.Balloon;
import com.anvil.balloongame.BalloonPopper;
import com.anvil.balloongame.GameDriver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Screen containing the gameplay elements of Balloon Popper.
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code stage - Stage} - Container for menu items.</li>
 * <li>{@code cam - OrthographicCamera} - The viewport of the game.</li>
 * <li>{@code bg - Texture} - The background texture.</li>
 * <li>{@code balloons - Balloon[][]} - The balloon objects used in the gameplay.</li>
 * </ol>
 * 
 * @author Edward Wang, Isaac Wong
 */
public class GamePlay extends State {
	private Stage stage;
	private OrthographicCamera cam;
	private Texture bg;
	private Balloon[][] balloons;

	/**
	 * Initializes the game to the starting state - an array of intact balloons, the size of which is based on the
	 * difficulty, and a countdown timer whose time is based on the difficulty.
	 * 
	 * @param sm
	 *            StateManager instance that controls program flow.
	 * @param batch
	 *            SpriteBatch instance from the main game, passed to save memory.
	 */
	public GamePlay (StateManager sm, SpriteBatch batch) {
		super (sm);
		cam = new OrthographicCamera ();
		cam.setToOrtho (false, GameDriver.WIDTH, GameDriver.HEIGHT);
		FitViewport vp = new FitViewport (GameDriver.WIDTH, GameDriver.HEIGHT);

		stage = new Stage (vp, batch);
		Gdx.input.setInputProcessor (stage);

		balloons = BalloonPopper.generate (0);
		bg = new Texture ("data/bg.jpg");
	}

	@Override
	public void update (float delta) {

	}

	/**
	 * Override of the method found in the State class. Called at every frame of the program rendering loop.
	 * 
	 * @param batch
	 *            SpriteBatch instance from the main game, passed to save memory.
	 */
	@Override
	public void render (SpriteBatch batch) {
		batch.setProjectionMatrix (cam.combined);
		batch.begin ();
		batch.draw (bg, 0, 0, GameDriver.WIDTH, GameDriver.HEIGHT);

		// BALLOON POP TESTING
		if (Gdx.input.justTouched ()) {
			inputLoop : {
				// Unproject the input coordinates from the mouse click.
				Vector3 input = new Vector3 (Gdx.input.getX (), Gdx.input.getY (), 0);
				cam.unproject (input);
				// Test each balloon to test which has been clicked.
				for (Balloon[] rows : balloons) {
					for (Balloon b : rows) {
						if (b.getSpr ().getBoundingRectangle ().contains (input.x, input.y) && !b.isDestroyed ()) {
							b.destroy ();
							break inputLoop;
						}
					}
				}
			}
		}

		// DRAW THE ARRAY OF BALLOONS
		Sprite temp;
		for (int r = 0; r < balloons.length; r++) {
			for (int c = 0; c < balloons[0].length; c++) {
				temp = balloons[r][c].getSpr ();
				temp.draw (batch);
			}
		}

		batch.end ();
	}

	/**
	 * Called when this object is terminated. It will release system resources used by elements of the game.
	 */
	@Override
	public void dispose () {

	}
}
