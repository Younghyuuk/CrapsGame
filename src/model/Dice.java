/*
 * TCSS 305 Final Assignment - craps
 */
package model;

import java.util.Random;

/**
 * Dice class that creates the dice with random generator
 * in order to have the dice roll.
 * 
 * @author Andrew Chon
 * @version December 13, 2022
 */
public class Dice {
	private int dieValue;
	private Random r;

	/**
	 * Constructor for dice that sets the die value to 1
	 * and instantiates Random r.
	 */
	public Dice() {
		dieValue = 1;
		r = new Random();
	}

	/**
	 * Roll method using Random to generate a number 
	 * from 1 - 6 to simulate dice rolling.
	 * 
	 * @return
	 */
	public int roll() {
		return dieValue = 1 + r.nextInt(6);
	}

	/**
	 * Gets the current value of the die.
	 * 
	 * @return die value
	 */
	public int getValue() {
		return dieValue;
	}

}
