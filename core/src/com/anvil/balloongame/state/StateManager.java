package com.anvil.balloongame.state;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Controls the program flow by operating on a {@code Stack} of {@code State} objects, which define parts of the game
 * (menu, gameplay, highscores, etc.)
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code states - Stack <State>} - The {@code Stack} of {@code State} objects, used to control program flow.</li>
 * </ol>
 * 
 * @author Edward Wang
 */
public class StateManager {
	protected Stack <State> states;

	/**
	 * Initlializes the {@code Stack}.
	 */
	public StateManager () {
		states = new Stack <State> ();
	}

	/**
	 * Places the parameter {@code State} at the top of the {@code Stack}.
	 * 
	 * @param state
	 *            the state to be pushed.
	 */
	public void push (State state) {
		states.push (state);
	}

	/**
	 * Removes the {@code State} at the top of the {@code Stack}.
	 */
	public void pop () {
		states.pop ();
	}

	/**
	 * Renders the {@code State} at the top of the {@code Stack}.
	 * 
	 * @param batch
	 *            SpriteBatch instance from the main game, used to save memory.
	 */
	public void render (SpriteBatch batch) {
		states.peek ().render (batch);
	}

	/**
	 * Updates game logic of the {@code State} at the top of the {@code Stack}.
	 * 
	 * @param deltaTime
	 *            Float representing the time since the last frame.
	 */
	public void update (float deltaTime) {
		states.peek ().update (deltaTime);
	}
}