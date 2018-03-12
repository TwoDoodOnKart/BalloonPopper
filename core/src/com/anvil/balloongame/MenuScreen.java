package com.anvil.balloongame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * The Screen which is dedicated to displaying and processing the main menu. The user can choose to PLAY or QUIT the
 * program.
 * <p>
 * Instance Variables
 * <ol>
 * <li>{@code game - GameDriver - }The game that this menu instance is a part of.</li>
 * <li>{@code stage - Stage - }The Stage that contains menu items.</li>
 * <li>{@code skin - Skin - }The Skin containing the formatting of the menu.</li>
 * </ol>
 * 
 * @author Edward Wang, Isaac Wong
 * @version 1 05.12.16
 */
public class MenuScreen implements Screen {
	private GameDriver game;
	private Stage stage;
	private Skin skin;

	/**
	 * This object is instantiated with reference to the {@code GameDriver} instance currently running, so that menu
	 * items will affect the state of the game.
	 * 
	 * @param game
	 *            GameDriver instance that this screen will be a part of.
	 */
	public MenuScreen (GameDriver game) {
		this.game = game;
		create ();
	}

	/**
	 * Called at the creation of this object. Instantiates the Stage, which will contain the interactive items. Loads
	 * the menu items and the background into Style and Skin objects. Instantiates the menu items, and creates the
	 * Listeners that capture action from the items.
	 * <p>
	 * The play button will start the game by transferring control from the menu screen to the game screen, as defined
	 * in the {@code GameDriver} class. DOES NOT DO ANYTHING YET AS GAME SCREEN IS NOT COMPLETE.
	 * <p>
	 * The exit button will end the execution of the game.
	 * <p>
	 * Local Variables
	 * <ol>
	 * <li>{@code bg - Image - }The background image.</li>
	 * <li>{@code playStyle - TextButtonStyle - }The skin used for the PLAY button.</li>
	 * <li>{@code exitstyle - TextButtonStyle - }The skin used for the EXIT button.</li>
	 * <li>{@code play - TextButton - }The PLAY button.</li>
	 * <li>{@code exit - TextButton - }The QUIT button.</li>
	 * </ol>
	 */
	private void create () {
		stage = new Stage ();
		Gdx.input.setInputProcessor (stage);

		Image bg = new Image (new Texture ("data/BG.jpg"));
		bg.setWidth (1200);
		bg.setHeight (800);
		stage.addActor (bg);

		skin = new Skin ();

		skin.add ("default", new BitmapFont ());

		skin.add ("pbup", new Texture ("data/Button_play_up.png"));
		skin.add ("pbover", new Texture ("data/Button_play_over.png"));
		skin.add ("pbdown", new Texture ("data/Button_play_down.png"));

		skin.add ("ebdown", new Texture ("data/Button_exit_down.png"));
		skin.add ("ebover", new Texture ("data/Button_exit_over.png"));
		skin.add ("ebup", new Texture ("data/Button_exit_up.png"));

		TextButtonStyle playstyle = new TextButtonStyle ();
		playstyle.up = skin.newDrawable ("pbup");
		playstyle.down = skin.newDrawable ("pbdown");
		playstyle.over = skin.newDrawable ("pbover");
		playstyle.font = skin.getFont ("default");

		TextButtonStyle exitstyle = new TextButtonStyle ();
		exitstyle.up = skin.newDrawable ("ebup");
		exitstyle.down = skin.newDrawable ("ebdown");
		exitstyle.over = skin.newDrawable ("ebover");
		exitstyle.font = skin.getFont ("default");

		final TextButton play = new TextButton ("", playstyle);
		final TextButton exit = new TextButton ("", exitstyle);

		play.setPosition (0, 240);
		play.setWidth (250f);
		play.setHeight (114f);
		stage.addActor (play);
		play.addCaptureListener (new ChangeListener () {
			public void changed (ChangeEvent event, Actor actor) {
			}
		});

		exit.setPosition (0, 160);
		exit.setWidth (250f);
		exit.setHeight (114f);
		stage.addActor (exit);
		exit.addCaptureListener (new ChangeListener () {
			public void changed (ChangeEvent event, Actor actor) {
				dispose ();
				System.exit (0);
			}
		});
	}

	/**
	 * Called at every frame of the program rendering loop. The screen is refreshed, and the Stage on which the menu
	 * items are placed is checked for any changes, then rerendered as necessary.
	 * 
	 * @param delta
	 *            Float representing time past since the last frame was rendered.
	 */
	public void render (float delta) {
		Gdx.gl.glClearColor (1,1,1,1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		stage.act ();
		stage.draw ();
	}

	/**
	 * No implementation of this method is used in this class.
	 * 
	 * @param width
	 *            Integer representing the new width in pixels.
	 * @param height
	 *            Integer representing the new height in pixels.
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
		stage.dispose ();
		skin.dispose ();
	}
}
