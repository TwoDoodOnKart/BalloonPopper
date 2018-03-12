package com.anvil.balloongame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * The Balloon class is a helper class that contains all the attributes of a balloon. An array of Balloon objects is
 * created in the BalloonPopper class. The balloon's size, color, and selected state is stored/set in this class.
 * <p>
 * <b> Instance Variables </b>
 * <p>
 * <b> blue </b> static int that stores our value for blue.
 * <p>
 * <b> red </b> static int that stores our value for red.
 * <p>
 * <b> yellow </b> static int that stores our value for yellow.
 * <p>
 * <b> green </b> static int that stores our value for green.
 * <p>
 * <b> purple </b> static int that stores our value for purple.
 * <p>
 * <b> orange </b> static int that stores our value for orange.
 * <p>
 * <b> size </b> int that stores the size of the balloon.
 * <p>
 * <b> color </b> int that stores the color value of the balloon.
 * <p>
 * <b> selected </b> boolean that stores if the balloon has been selected.
 *
 * @author I Wong and E Wang
 * @version 1 05.12.16
 */
public class Balloon {
	final static Texture DESTROYED = new Texture ("data/BalloonDestroyed.png");

	final static Texture REDT = new Texture ("data/Balloon1.png");
	final static Texture BLUET = new Texture ("data/Balloon1.png");
	final static Texture YELLOWT = new Texture ("data/Balloon1.png");
	final static Texture GREENT = new Texture ("data/Balloon1.png");
	final static Texture PURPLET = new Texture ("data/Balloon1.png");
	final static Texture ORANGET = new Texture ("data/Balloon1.png");

	final static int BLUE = 0;
	final static int RED = 1;
	final static int YELLOW = 2;
	final static int GREEN = 3;
	final static int PURPLE = 4;
	final static int ORANGE = 5;

	private boolean destroyed;
	private int color;
	private Sprite displayed;

	/**
	 * The Balloon class constructor is accessed when the Balloon class is instantiated. Values are assigned to
	 * variables size, color, and selected.
	 * 
	 * @param size
	 *            int value determining the size of the balloon.
	 * @param color
	 *            int value determining the color of the balloon.
	 * @param selected
	 *            boolean value determining the state of the balloon.
	 */
	public Balloon (int color, int x, int y) {
		this.color = color;
		switch (color) {
		case BLUE: {
			displayed = new Sprite (BLUET);
			break;
		}
		case RED: {
			displayed = new Sprite (REDT);
			break;
		}
		case YELLOW: {
			displayed = new Sprite (YELLOWT);
			break;
		}
		case GREEN: {
			displayed = new Sprite (GREENT);
			break;
		}
		case PURPLE: {
			displayed = new Sprite (PURPLET);
			break;
		}
		default: {
			displayed = new Sprite (ORANGET);
		}
		}
		displayed.setPosition (x, y);
		displayed.setSize (72f, 105f);
	}

	/**
	 * Destroy this Balloon instance, called on user input.
	 */
	public void destroy () {
		System.out.println ("Destroyed");
		destroyed = true;
		float tempX = displayed.getX ();
		float tempY = displayed.getY ();
		displayed = new Sprite (DESTROYED);
		displayed.setPosition (tempX, tempY);
		displayed.setSize (72f, 105f);
	}

	/**
	 * Accessor for the Sprite displayed.
	 * 
	 * @return the Sprite of this Balloon.
	 */
	public Sprite getSpr () {
		return displayed;
	}

	/**
	 * Accessor, determine if the Balloon is destroyed.
	 * 
	 * @return
	 */
	public boolean isDestroyed () {
		return destroyed;
	}

	/**
	 * Access method getColor () returns the value of color.
	 *
	 * @return color | Returns the value of color.
	 * 
	 */
	public int getColor () {
		return color;
	}

	/**
	 * Mutator method setColor (int color) is used to set the value of color.
	 * 
	 * @param color
	 *            | Integer value assigned to color.
	 */
	public void setColor (int color) {
		this.color = color;
	}
}