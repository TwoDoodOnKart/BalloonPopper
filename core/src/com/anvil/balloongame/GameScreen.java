package com.anvil.balloongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The screen on which the main game is played. The user progresses from here to the loss or win screen, which loops to
 * the high scores screen and main menu. The balloons are generated based on the level of difficulty that the user
 * selected in the previous screen.
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code game - GameDriver} - The game that this screen instance is a part of.</li>
 * <li>{@code batch - SpriteBatch} - The OpenGL sprite batch that this screen uses to render.</li>
 * <li>{@code balloons - Balloon[][]} - The balloon objects used in the gameplay.</li>
 * <li>{@code level - int} - The level of difficulty this instance is set to.</li>
 * </ol>
 * 
 * @author Edward Wang, Isaac Wong
 * @version 1 05.12.16
 */
public class GameScreen implements Screen {
	private GameDriver game;
	private SpriteBatch batch;
	private Balloon[][] balloons;
	private int level;

	/**
	 * This object is instantiated with reference to the {@code GameDriver} instance currently running, so that user
	 * interaction will affect the main game. The {@code SpriteBatch} of the entire game is reused in order to save
	 * memory. In addition, the level variable will determine in other methods the difficulty of the generated stage.
	 * 
	 * @param game
	 *            GameDriver instance that this screen will be a part of.
	 * @param batch
	 *            SpriteBatch used by the entire game.
	 * @param level
	 *            Integer determining the level of difficulty in this game.
	 */
	public GameScreen (GameDriver game, SpriteBatch batch, int level) {
		this.game = game;
		this.batch = batch;
		create ();
	}

	/**
	 * Called at the creation of this object. Generates the Balloon objects comprising the stage, in accordance with the
	 * difficulty level set at the instantiation of this object.
	 */
	public void create () {
		// balloons = BalloonPopper.generate1 (6, 6, 3);
	}

	/**
	 * Called at every frame of the program rendering loop. User input on buttons and the balloons is processed.
	 * Animations that correspond to user input are displayed here.
	 * <p>
	 * THE IMPLEMENTATION DOES NOT YET EXIST IN BALLOON.
	 * <p>
	 * Local Variables
	 * <ol>
	 * <li>{@code x - int} - The location of the mouse cursor on the x-axis.</li>
	 * <li>{@code y - int} - The location of the mouse cursor on the y-axis.</li>
	 * <li>{@code r - int} - The rows of the balloon array.</li>
	 * <li>{@code c - int} - The columns of the balloon array.</li>
	 * </ol>
	 * <p>
	 * Loops
	 * <ol>
	 * <li>For loop to traverse the rows of the balloon array.</li>
	 * <li>For loop to traverse the columns of the balloon array.</li>
	 * <li>For loop to traverse the rows of the balloon array, for drawing the array.</li>
	 * <li>For loop to traverse the columns of the balloon array, for drawing the array.</li>
	 * </ol>
	 * <p>
	 * If Statements
	 * <ol>
	 * <li>Determine if the mouse button was clicked.</li>
	 * <li>Determine if the mouse was clicked on a Balloon Sprite.</li>
	 * </ol>
	 * 
	 * @param delta
	 *            Float representing time past since the last frame was rendered.
	 */
	public void render (float delta) {
		// if (Gdx.input.justTouched ()) {
		// inputLoop : {
		// int x = Gdx.input.getX ();
		// int y = Gdx.input.getY ();
		// for (Balloon[] rows : balloons) {
		// for (Balloon b : rows) {
		// if (b.getFirstFrame ().getBoundingRectangle ().contains (x, y) && !b.isPopped ()) {
		// //TODO: IMPLEMENTATION OF DESTRUCTION ANIMATIONS
		// break inputLoop;
		// }
		// }
		// }
		// }
		// }
		// for (int r = 0; r < balloons.length; r++) {
		// for (int c = 0; c < balloons[r].length; c++) {
		// //TODO: IMPLEMENTATION OF GRAPHICS
		// }
		// }
	}

	/**
	 * No implementation of this method is used in this class.
	 * 
	 * @param width
	 *            the new width in pixels.
	 * @param height
	 *            the new height in pixels.
	 */
	public void resize (int width, int height) {

	}

	/**
	 * No implementation of this method is used in this class.
	 */
	public void show () {
	}

	/**
	 * No implementation of this method is used in this class.
	 */
	public void pause () {
	}

	/**
	 * No implementation of this method is used in this class.
	 */
	public void resume () {
	}

	/**
	 * No implementation of this method is used in this class.
	 */
	public void hide () {
	}

	/**
	 * Called when the Screen object is terminated. It will clear the memory of items that are not internal to the
	 * Screen object.
	 */
	public void dispose () {

	}
}
