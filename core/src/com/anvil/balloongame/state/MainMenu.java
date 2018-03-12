package com.anvil.balloongame.state;

import com.anvil.balloongame.GameDriver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * The {@code State} that contains the main menu of the Balloon Popper game. From here, the user can choose to play the
 * game, view the instructions, view the high scores, and exit.
 * 
 * @author Edward Wang, Isaac Wong
 */
public class MainMenu extends State {
	private Texture bg;
	private OrthographicCamera cam;
	private Skin skin;
	private Stage stage;

	/**
	 * Initializes the menu. Sets the background image, button images, and adds Listeners for the menu items (see
	 * below). The menu items and their skins are contained within a {@code State} object. 
	 * <p>
	 * The Play button will call on the StateManager to progress to the Difficulty Selection Screen.
	 * <p>
	 * The Exit button will terminate the game.
	 * 
	 * @param sm
	 *            StateManager instance that controls program flow.
	 * @param batch
	 *            SpriteBatch instance from the main game, passed to save memory.
	 */
	public MainMenu (final StateManager sm, final SpriteBatch batch) {
		super (sm);
		// Initialize the viewport.
		cam = new OrthographicCamera ();
		cam.setToOrtho (false, GameDriver.WIDTH, GameDriver.HEIGHT);
		FitViewport vp = new FitViewport (GameDriver.WIDTH, GameDriver.HEIGHT);

		// Initialize the Stage on which interactive elements are placed.
		stage = new Stage (vp, batch);
		Gdx.input.setInputProcessor (stage);

		// Background Texture
		bg = new Texture ("data/BG.jpg");

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
		play.setPosition (0, 280);
		play.setWidth (250f);
		play.setHeight (114f);
		stage.addActor (play);
		play.addCaptureListener (new ChangeListener () {
			public void changed (ChangeEvent event, Actor actor) {
				dispose ();
				sm.pop ();
				sm.push (new GamePlay (sm, batch));
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

	@Override
	public void update (float delta) {

	}

	/**
	 * Renders the background image and the menu items.
	 * 
	 * @param batch
	 *            SpriteBatch instance from the main game, passed to save memory.
	 */
	@Override
	public void render (SpriteBatch batch) {
		batch.setProjectionMatrix (cam.combined);
		batch.begin ();
		batch.draw (bg, 0, 0, GameDriver.WIDTH, GameDriver.HEIGHT);
		batch.end ();
		stage.act ();
		stage.draw ();
	}

	/**
	 * Called when this object is terminated. It will release system resources used by elements of the game.
	 */
	@Override
	public void dispose () {
		bg.dispose ();
		stage.dispose ();
		skin.dispose ();
	}
}