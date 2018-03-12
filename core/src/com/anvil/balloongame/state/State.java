package com.anvil.balloongame.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Template for game states in the Balloon Popper program.
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code sm - StateManager} - The {@code StateManager} that governs this State.</li>
 * </ol>
 * 
 * @author Brent Aureli, modified by Edward Wang and Isaac Wong
 */
public abstract class State {
	protected StateManager sm;

	/**
	 * Initializes with reference to the StateManager used by this GameDriver instance.
	 * 
	 * @param sm
	 *            StateManager to govern this State.
	 */
	protected State (StateManager sm) {
		this.sm = sm;
	}

	/**
	 * Updates gamelogic of this instance.
	 * 
	 * @param delta
	 *            Float representing the time since the last frame.
	 */
	public abstract void update (float delta);

	/**
	 * Renders this instance.
	 * 
	 * @param batch
	 */
	public abstract void render (SpriteBatch batch);

	/**
	 * Called when this object is terminated. It will release system resources used by elements of the game.
	 */
	public abstract void dispose ();
}