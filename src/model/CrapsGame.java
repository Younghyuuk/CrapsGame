/*
 * TCSS 305 Final Assignment - craps
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * CrapsGame class that starts the game and has the roll of the dice with all
 * the logic and data within it.
 * 
 * @author Andrew Chon
 * @version December 13, 2022
 */
public class CrapsGame {

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private int myPoints;
    private int myPlayerWins;
    private int myHouseWins;
    private int myTotal;
    private boolean myGameActive;
    private boolean myGameWon;
    private int myDie1Value;
    private int myDie2Value;
    private static CrapsGame myInstance = new CrapsGame();
    

    /**
     * Private constructor class that start the game.
     */
    private CrapsGame() {
        startGame();
    }

    /**
     * Static craps game instance.
     * 
     * @return myInstance
     */
    public static CrapsGame getCrapsInstance() {
        return myInstance;
    }

    /**
     * Start game method that sets all the values to zero so the player can start
     * fresh.
     */
    public void startGame() {
        setGameActive(true);
        setGameWon(false);
        setPoint(0);
        setPlayerWin(0);
        setHouseWin(0);
    }

    /**
     * Play again method that has it so players can keep playing the game resetting
     * the point but not wins.
     */
    public void playAgain() {
        setGameActive(true);
        setPoint(0);
        setDiceValues(0, 0);
        setTotal(0);
    }

    /**
     * Roll dice method that gives the win, loss, and roll dice again conditions so
     * the craps game functions.
     */
    public void rollDice() {

        if (myGameActive) {
            Dice die1 = new Dice();
            Dice die2 = new Dice();

            myDie1Value = die1.roll();
            myDie2Value = die2.roll();

            setTotal(myDie1Value + myDie2Value);

            if (myPoints == 0) {
                if (myTotal == 2 || myTotal == 3 || myTotal == 12) {
                    setGameWon(false);
                    setGameActive(false);
                    myHouseWins++;
                } else if (myTotal == 7 || myTotal == 11) {
                    setGameWon(true);
                    setGameActive(false);
                    myPlayerWins++;
                } else {
                    setPoint(myTotal);
                }
            } else {
                if (myTotal == myPoints) {
                    setGameWon(true);
                    setGameActive(false);            
                    myPlayerWins++;
                } else if (myTotal == 7) {
                    setGameWon(false);
                    setGameActive(false);
                    myHouseWins++;

                }

            }
        }

    }

    /**
     * Sets the dice values for the player.
     * 
     * @param theDie1Value the value for die 1
     * @param theDie2Value the value for die 2
     */
    public void setDiceValues(final int theDie1Value, final int theDie2Value) {
        myDie1Value = theDie1Value;
        myDie2Value = theDie2Value;
    }

    /**
     * Set the state of the game whether it is active or not.
     * 
     * @param theGameActive game state of true or false
     */
    public void setGameActive(final boolean theGameActive) {
        myGameActive = theGameActive;
        if (!myGameActive) {
            changes.firePropertyChange("active", null, false);
        }
    }

    /**
     * Sets if you won in the game true or false.
     * 
     * @param theGameWon boolean game win or lose
     */
    public void setGameWon(final boolean theGameWon) {
        myGameWon = theGameWon;
    }

    /**
     * Sets how many wins the player has.
     * 
     * @param thePlayerWins amount of wins the player has
     */
    public void setPlayerWin(final int thePlayerWins) {
        myPlayerWins = thePlayerWins;
    }

    /**
     * Sets the amount of wins the house has.
     * 
     * @param theHouseWins amount of wins for the house
     */
    public void setHouseWin(final int theHouseWins) {
        myHouseWins = theHouseWins;
    }

    /**
     * Sets the points for the dice game when the player has to do a consecutive
     * roll to the first total.
     * 
     * @param thePoints point the player has to get
     */
    public void setPoint(final int thePoints) {
        myPoints = thePoints;
    }

    /**
     * Sets the total of the dice roll.
     * 
     * @param theTotal total the dice equals
     */
    public void setTotal(final int theTotal) {
        myTotal = theTotal;
    }

    /**
     * Gets whether the game is active or not.
     * 
     * @return the game active state
     */
    public boolean getGameActive() {
        return myGameActive;
    }

    /**
     * Gets whether the game was won or not.
     * 
     * @return game won
     */
    public boolean getGameWon() {
        return myGameWon;
    }

    /**
     * Gets the amount of times the player has won.
     * 
     * @return player wins
     */
    public int getPlayerWins() {
        return myPlayerWins;
    }

    /**
     * Gets the amount of times the house wins.
     * 
     * @return house wins
     */
    public int getHouseWins() {
        return myHouseWins;
    }

    /**
     * Gets the points after first roll.
     * 
     * @return points
     */
    public int getPoints() {
        return myPoints;
    }

    /**
     * Gets the value of the first die.
     * 
     * @return first die value
     */
    public int getDie1Value() {
        return myDie1Value;
    }

    /**
     * Gets the value of the second die.
     * 
     * @return second die value
     */
    public int getDie2Value() {
        return myDie2Value;
    }

    /**
     * Gets the total of both dice.
     * 
     * @return total dice sum
     */
    public int getMyTotal() {
        return myTotal;
    }

    /**
     * Adds a property change listener.
     * 
     * @param l property change to add
     */
    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    /**
     * Removes a property change listener.
     * 
     * @param l property change to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
}
