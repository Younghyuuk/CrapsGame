/*
 * TCSS 305 Final Assignment - craps
 */
package model;

/**
 * Bank class that creates money fields and the bet method for Craps game.
 * 
 * @author Andrew Chon
 * @version December 13, 2022
 */
public class Bank {

	/** Money instance field. */
	private int myMoney;

	/** Bet the player inputs. */
	private int myBet;

	/**
	 * Default Bank constructor.
	 */
	public Bank() {

	}

	/**
	 * Get money method that returns money.
	 * 
	 * @return money
	 */
	public int getMoney() {
		return myMoney;
	}

	/**
	 * Set money method that sets the amount of money the player has.
	 * 
	 * @param theMoney how much money they input.
	 */
	public void setMoney(final int theMoney) {
		if (theMoney >= 0) {
			myMoney = theMoney;
		}
	}

	/**
	 * Gets the bet input by the player.
	 * 
	 * @return bet that was input
	 */
	public int getBet() {
		return myBet;
	}

	/**
	 * Sets the amount of money the player wants to bet from their bank money.
	 * 
	 * @param theBet how much they want to bet
	 */
	public void setBet(final int theBet) {
		if (theBet >= 0) {
			myBet = theBet;
		}
	}

}
