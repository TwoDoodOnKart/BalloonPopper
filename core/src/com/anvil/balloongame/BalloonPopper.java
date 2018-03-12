package com.anvil.balloongame;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The BalloonPopper class is the main processing class for the game. Depending on which level (difficulty) was selected
 * by the user, a 2D array of 36 (6 by 6 in easy/medium mode) or 64 (8 by 8 in hard mode) balloons is created. Each
 * balloon is assigned a primary color. If hard mode was selected, the balloons can also be a secondary color. This
 * class will also take user input and determine which balloon in the 2D array was selected based on position. If the
 * user selected an appropriately colored balloon that had not been previously selected, that balloon is set as selected
 * and can no longer be selected again in the round.
 * 
 * <p>
 * <b> Instance Variables </b>
 * <p>
 * <b> level </b> int variable that stores the difficulty level selected by the user.
 * <p>
 * <b> color </b> int variable that stores a randomly generated number that represents the color of balloon the user
 * should select.
 * <p>
 * <b> balloons [][] </b> 2D array of Balloon objects.
 * <p>
 * <b> totalx </b> int value that stores the length of the 2nd dimension in balloons [][].
 * <p>
 * <b> totaly </b> int value that stores the length of the 1st dimension in balloons [][].
 * 
 * @author I Wong and E Wang
 * @version 1 05.12.16
 */
public class BalloonPopper {
	int level = 0;
	int color = 0;
	Balloon[][] balloons;
	private int totalx = 6;
	private int totaly = 6;

	// screen is 1200 by 800 (col x row) balloon area is 720 by 720
	// level 1 and 2: 6 by 120 pixel col / 6 by 120 pixel row
	// level 3: 8 x 90 pixel col / 8 by 90 pixel row

	/**
	 * The BalloonPopper constructor is accessed when an instance of the class is instantiated. The constructor assigns
	 * a value to level, and will assign a value to totaly and totalx if level is 3. The balloons[][] 2D array is
	 * instantiated with dimensions totaly by totalx.
	 * 
	 * @param level
	 *            | int value that stores the difficulty level selected by the user.
	 * 
	 *            <p>
	 *            <b> Conditional Statement </b>
	 *            <p>
	 *            <b> 1st Statement </b> If level is 3, the 2D array will have the dimensions 8 by 8.
	 */
	public BalloonPopper (int level) {
		this.level = level;
		if (level == 3) {
			totaly = 8;
			totalx = 8;

		}
		balloons = new Balloon[totaly][totalx];
	}

	/**
	 * The generate () method is used to instantiate new Balloon objects in the 2D balloons [][] array. Each Balloon
	 * object is given a size, color, and selected state. An int array colors is created to store the number of times
	 * each color is used. A nested forloop is used to traverse the 2D array.
	 * 
	 * <p>
	 * <b> Local Variables </b>
	 * <p>
	 * <b> numColor </b> stores the number of different colors possible.
	 * <p>
	 * <b> tempColor </b> stores a temporary random value which is made permanent if the conditions are met.
	 * <p>
	 * <b> colors[] </b> an int array that stores the number of times each color occurs.
	 * 
	 * <p>
	 * <b> Conditional Statement </b>
	 * <p>
	 * <b> 1st Statement </b> If level is 3, the number of possible colors is set to 6.
	 * <p>
	 * <b> 2nd Statement </b> If the color does not occur more than 12 times, the balloon object at that index in the 2D
	 * array is set to that color.
	 * 
	 */
	public static Balloon[][] generate (int level) {
		int tempColor = 0;

		// IF DIF = EZPZ MODE
		int numColor = 3;
		int totaly = 6;
		int totalx = 6;

		// IF DIF = TRIHARD
		if (level == 3) {
			numColor = 6;
			totaly = 8;
			totalx = 8;
		}

		Balloon[][] balloons = new Balloon[totaly][totalx];

		int[] colors = new int[numColor]; // (blue,red,yellow,green,purple,orange)
		for (int col = 0; col < totalx; col++) {
			for (int row = 0; row < totaly; row++) {
				while (true) {
					tempColor = (int) (Math.random () * (numColor) + 1);
					if (colors[tempColor - 1] < 12) {
						balloons[row][col] = new Balloon (tempColor, 10 + col * 80, 700 - row * 110);
						colors[tempColor - 1]++;
						break;
					}
				}
			}
		}
		
		return balloons;
	}

	// /**
	// * Method detectUI() is used to determine where the user clicked (to be implemented later) and which balloon
	// object
	// * corresponds with that area. Assuming the 2D array is printed on the screen, a forloop goes through each
	// * row/column and compares the location value of the row/column with the user input. The loop ends when there is a
	// * match and the row/column is returned. The color of the Balloon object at that row/column in the 2D array is
	// * compared with the randomly generated color value. If that Balloon object had not been previously selected and
	// it
	// * is a match, that Balloon object is set to selected.
	// * <p>
	// * <b> Local Variables </b>
	// * <p>
	// * <b> increment </b> stores the difference in size when the difficulty is easy/medium versus hard. The size of
	// the
	// * image is 30 pixels smaller (in length and width) in hard mode.
	// * <p>
	// * <b> xVal </b> stores the x-coordinate of the mouse click (to be implemented).
	// * <p>
	// * <b> yVal </b> stores the y-coordinate of the mouse click (to be implemented).
	// * <p>
	// * <b> tempX </b> stores the value of the column being compared to. Incremented to go to next column.
	// * <p>
	// * <b> tempY </b> stores the value of the row being compared to. Incremented to go to next row.
	// *
	// * <p>
	// * <b> Conditional Statements </b>
	// * <p>
	// * <b> 1st Statement </b> If level is 3, set the value of increment to 30.
	// * <p>
	// * <b> 2nd Statement </b> If the current range being checked is smaller than the mouse click's x-value, increment
	// * tempX by 1.
	// * <p>
	// * <b> 3rd Statement </b> If the current range being checked is smaller than the mouse click's y-value, increment
	// * tempY by 1.
	// * <p>
	// * <b> 4th Statement </b> If the current range being checked is greater than the mouse click's x and y values,
	// exit
	// * the loop.
	// * <p>
	// * <b> 5th Statement </b> If the color value of the balloon object (at row tempY and column tempX) matches the
	// * randomly generated color value and that balloon had not been previously selected, set the selected value of the
	// * balloon to true.
	// *
	// */
	//
	// public void detectUI () {
	// int increment = 0;
	// int tempX = 0;
	// int tempY = 0;
	// if (level == 3) {
	// increment = 30;
	// }
	// int xVal = 250; // to be implemented later with GUI
	// int yVal = 220; // to be implemented later with GUI
	// for (int range = 120 - increment; range <= 720; range += 120 - increment) {
	// if (range < xVal) {
	// tempX++;
	// }
	// if (range < yVal) {
	// tempY++;
	// }
	// if (range > xVal && range > yVal) {
	// break;
	// }
	// }
	// if (balloons[tempY][tempX].getColor () == color && !balloons[tempY][tempX].getSelected ()) {
	// balloons[tempY][tempX].setSelected (true);
	// }
	// System.out.println ("TempX: " + tempX + " TempY: " + tempY);
	// System.out.println (balloons[tempY][tempX].getSelected ());
	// System.out.println (balloons[tempY][tempX].getColor ());
	// }

	/**
	 * Method randomColor () is used to generate a random number that determines the color of balloon the user should
	 * pop.
	 * 
	 * <p>
	 * <b> Conditional Statement </b>
	 * <p>
	 * <b> 1st Statement </b> If level is 3, the number of possible colors is set to 6.
	 */
	public void randomColor () {
		int temp = 3;
		if (level == 3) {
			temp = 6;
		}
		color = (int) (Math.random () * (temp) + 1);
	}

	// /**
	// * Description of main(String [] args) The main method instantiates the BalloonPopper class and calls methods
	// * generate (), print(), and detectUI ().
	// *
	// * @param args
	// * [ ] String array that allows command line parameters to be used when executing the program.
	// */
	// public static void main (String[] args) {
	// BalloonPopper bp = new BalloonPopper (3);
	// bp.generate ();
	// bp.detectUI ();
	// }
}