/*
 * TCSS 305 Final Assignment - craps
 */
package view;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.Bank;
import model.CrapsGame;

/**
 * Craps view that creates the gui and actionListeners of the craps game.
 * 
 * @author Andrew Chon
 * @version December 13, 2022
 */
public class CrapsView extends JPanel implements PropertyChangeListener {

	/**
	 * A generated serial version UID for object Serialization.
	 * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
	 */
	private static final long serialVersionUID = -3848956360104076221L;

	/** MyStart JMenuItem that starts the game. */
	private JMenuItem myStart;

	/** MyRoll JButton that rolls the dice. */
	private JButton myRoll;

	/** MyDie1 JLabel to see value of die 1. */
	private JLabel myDie1;

	/** MyDie2 JLabel to see the roll of die 2. */
	private JLabel myDie2;

	/** MyTotal JLabel to see the total of both dice. */
	private JLabel myTotal;

	/** MyPoint JLabel to see the point the player needs to win. */
	private JLabel myPoint;

	/** MyPlayerWin JLabel to see how many wins the player has. */
	private JLabel myPlayerWin;

	/** MyHouseWin JLabel to see the wins of the house. */
	private JLabel myHouseWin;

	/** MyBank JLabel to see Bank. */
	private JLabel myBank;

	/** MyBankText JTextField to have the player set bank amount. */
	private JTextField myBankText;

	/** MyBet JLabel to see Bet. */
	private JLabel myBet;

	/** MyBetText JTextField to type in their bet. */
	private JTextField myBetText;

	/** MySetBank JButton to set the amount they typed in the field. */
	private JButton mySetBank;

	/** MyPlayAgain JButton to have players play again. */
	private JButton myPlayAgain;

	/** MyGame JMenu to have a game Menu with sub items. */
	private JMenu myGame;

	/** myGameBar JMenuBar to add the sub items. */
	private JMenuBar myGameBar;

	/** myHelpBar JMenuBar to add the sub items. */
	private JMenuBar myHelpBar;

	/** MyHelp JMenu to have a help Menu with sub items. */
	private JMenu myHelp;

	/** MyExit JMenuItem so the player can exit the game. */
	private JMenuItem myExit;

	/** MyReset JMenuItem so the player can reset the game completely. */
	private JMenuItem myReset;

	/** MyAbout JMenuItem gives author, version, etc of the game. */
	private JMenuItem myAbout;

	/** MyRules JMenuItem gives the rules of the game. */
	private JMenuItem myRules;

	/** MyShortCuts JMenuItem gives the different shortcuts. */
	private JMenuItem myShortCuts;

	/** New JPanel to have all our other items to then add to frame. */
	private JPanel myPanel = new JPanel();

	/** Bank object in order to set and bet money in craps game. */
	private Bank bank = new Bank();

	/**
	 * Craps constructor that creates the panel and layout of the sub components has
	 * buttons, text, and labels adding them all into a panel and adds interaction
	 * here.
	 * 
	 */
	public CrapsView() {
		GridLayout theLayout = new GridLayout(2, 3, 100, 100);
		myPanel.setLayout(theLayout);
		myPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		myPanel.setSize(50, 50);
		myPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		myRoll = new JButton("Roll Dice");
		myRoll.setMnemonic(KeyEvent.VK_T);
		myRoll.setEnabled(false);

		myDie1 = new JLabel("Die 1: ");
		myDie2 = new JLabel("Die 2:");
		myTotal = new JLabel("Total: ");
		myPoint = new JLabel("Points: ");
		myPlayAgain = new JButton("Play Again");
		myPlayAgain.setMnemonic(KeyEvent.VK_P);
		myPlayAgain.setEnabled(false);

		myPlayerWin = new JLabel("Player Win Total: ");
		myHouseWin = new JLabel("House Win Total: ");
		myBank = new JLabel("Bank: ");
		myBankText = new JTextField();
		myBankText.setEnabled(false);

		myBet = new JLabel("Bet: ");
		myBetText = new JTextField();
		myBetText.setEnabled(false);
		mySetBank = new JButton("Set Bank");
		mySetBank.setMnemonic(KeyEvent.VK_S);
		mySetBank.setEnabled(false);

		add(myPanel);
		myPanel.add(myRoll);
		myPanel.add(myDie1);
		myPanel.add(myDie2);
		myPanel.add(myTotal);
		myPanel.add(myPoint);
		myPanel.add(myPlayerWin);
		myPanel.add(myHouseWin);
		myPanel.add(myPlayAgain);
		myPanel.add(myBank);

		myPanel.add(myBankText);

		myPanel.add(mySetBank);
		myPanel.add(myBet);
		myPanel.add(myBetText);

		addListeners();

	}

	/**
	 * Creates the game menu and has the menu items in there including Start, Reset,
	 * and Exit. Also implements shortcuts into each of the menu and menu items. and
	 * adds them into a JMenubar Also implements action listeners to start game.
	 * 
	 * @return game bar a JMenu bar
	 */
	private JMenuBar gameMenu() {

		myGameBar = new JMenuBar();
		myGame = new JMenu("Game");
		myGameBar.add(myGame);

		myStart = new JMenuItem("Start Game");
		KeyStroke keyStrokeToStart = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		myStart.setAccelerator(keyStrokeToStart);

		myReset = new JMenuItem("Reset");

		KeyStroke keyStrokeToReset = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
		myReset.setAccelerator(keyStrokeToReset);

		myReset.setEnabled(false);
		myExit = new JMenuItem("Exit");
		KeyStroke keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
		myExit.setAccelerator(keyStrokeToExit);

		myGame.add(myStart);
		myGame.add(myReset);
		myGame.add(myExit);

		myGame.setMnemonic(KeyEvent.VK_G);

		myGameBar.add(myGame);

		myStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				model.CrapsGame.getCrapsInstance().startGame();
				JOptionPane.showMessageDialog(null, "Please set the bank and bet amount before playing.");
				myDie1.setText("Die 1: ");
				myDie2.setText("Die 2: ");
				myTotal.setText("Total: ");
				myPoint.setText("Points: ");
				myPlayerWin.setText("Player Win Total: ");
				myHouseWin.setText("House Win Total: ");

				myBankText.setEnabled(true);
				myStart.setEnabled(false);
			}
		});

		return myGameBar;

	}

	/**
	 * Help menu  that puts in the menu and menu items all into 
	 * one JMenuBar with all the keyboard shortcuts set for help,
	 * about, rules, and shortcuts. Also adds in all the
	 * action listeners for each of the items.
	 * 
	 * @return help bar JMenubar
	 */
	private JMenuBar helpMenu() {

		myHelpBar = new JMenuBar();
		myHelp = new JMenu("Help");
		myHelp.setMnemonic(KeyEvent.VK_H);

		myHelpBar.add(myHelp);

		myAbout = new JMenuItem("About");
		KeyStroke keyStrokeAbout = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
		myAbout.setAccelerator(keyStrokeAbout);

		myRules = new JMenuItem("Rules");
		KeyStroke keyStrokeRule = KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
		myRules.setAccelerator(keyStrokeRule);

		myShortCuts = new JMenuItem("Shortcuts");
		KeyStroke keyStrokeShortCuts = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0);
		myShortCuts.setAccelerator(keyStrokeShortCuts);

		myHelp.add(myAbout);
		myHelp.add(myRules);
		myHelp.add(myShortCuts);
		myHelpBar.add(myHelp);

		return myHelpBar;

	}

	/**
	 * Adds in the gameMenu and helpMenu into a single JMenuBar
	 * while adding in all the action listeners to those components.
	 * Like exit, about, rules, reset etc.
	 * 
	 * @param theFrame inputs a JFrame that sets it
	 * @return menu MenuBar
	 */
	private JMenuBar menu(JFrame theFrame) {
		JMenuBar menu = new JMenuBar();
		menu.add(gameMenu());
		myExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
						"Exit Program Message Box", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});

		myReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				model.CrapsGame.getCrapsInstance().startGame();
				myDie1.setText("Die 1: ");
				myDie2.setText("Die 2: ");
				myTotal.setText("Total: ");
				myPoint.setText("Points: ");
				myPlayerWin.setText("Player Win Total: ");
				myHouseWin.setText("House Win Total: ");
				bank.setMoney(0);
				bank.setBet(0);
				myBank.setText("Bank: " + bank.getMoney());
				myBet.setText("Bet: " + bank.getBet());
				myBankText.setEnabled(true);
				JOptionPane.showMessageDialog(null, "Set a new bank amount.");

			}
		});

		menu.add(helpMenu());

		myAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "Author: Andrew Chon\nVersion: 1.0" + "\nJava Version: 6.3");

			}
		});

		myShortCuts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "Game Menu: ALT+G\nStart : CTRL+S\n"
						+ "Reset: CTRL+R\nExit: CTRL+E\nHelp Menu: ALT+H\nAbout: CTRL+A\n"
						+ "Rules: CTRL+M\nShortCuts: S\nRoll Dice: ALT+T\nPlay Again: ALT+P\n" + "Set Bank: ALT+S");

			}
		});

		myRules.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null,
						"A player rolls two dice where each die has six faces in the usual way (values 1 through 6).\r\n"
								+ "After the dice have come to rest the sum of the two upward faces is calculated.\r\n"
								+ "The first roll/throw\r\n"
								+ "If the sum is 7 or 11 on the first throw the roller/player wins.\r\n"
								+ "If the sum is 2, 3 or 12 the roller/player loses, that is the house wins.\r\n"
								+ "If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the roller/player's 'point'.\r\n"
								+ "Continue rolling given the player's point\r\n"
								+ "Now the player must roll the 'point' total before rolling a 7 in order to win.\r\n"
								+ "If they roll a 7 before rolling the point value they got on the first roll the roller/player loses (the 'house' wins).");

			}
		});

		return menu;

	}

	/**
	 * Adds all the action listeners that are not on the Menu
	 * all the panels sub components like roll dice, bank, bet
	 * play again, etc.
	 * 
	 */
	private void addListeners() {

		myRoll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				CrapsGame craps = model.CrapsGame.getCrapsInstance();
				if (craps.getGameActive()) {

					craps.rollDice();

					myDie1.setText("Die 1: " + craps.getDie1Value());
					myDie2.setText("Die 2: " + craps.getDie2Value());
					myTotal.setText("Total: " + craps.getMyTotal());
					myPlayerWin.setText("Player Win Total: " + craps.getPlayerWins());
					myHouseWin.setText("House Win Total: " + craps.getHouseWins());
					if (craps.getPoints() != 0) {
						myPoint.setText("Points: " + craps.getPoints());
					} else {
						myPoint.setText("Points: ");
					}
					if (!craps.getGameActive()) {
						JOptionPane.showMessageDialog(null, "Winner: " + craps.getGameWon());
						myPlayAgain.setEnabled(true);

						// this increments the bank statement
						if (craps.getGameWon()) {
							bank.setMoney(bank.getMoney() + (bank.getBet() * 2));
						} else {
							bank.setMoney(bank.getMoney() - bank.getBet());
						}
						myBank.setText("Bank: " + bank.getMoney());

						// session ending when bank goes to zero
						if (bank.getMoney() <= 0) {
							JOptionPane.showMessageDialog(null, "Game terminated no money");
							System.exit(0);
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Game not active");
					myBank.setText("Bank: " + bank.getMoney());

				}

			}
		});

		myPlayAgain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.CrapsGame.getCrapsInstance().playAgain();
				CrapsGame craps = model.CrapsGame.getCrapsInstance();
				myBetText.setEnabled(true);
				JOptionPane.showMessageDialog(null, "Set another bet.");
				myDie1.setText("Die 1: " + craps.getDie1Value());
				myDie2.setText("Die 2: " + craps.getDie2Value());
				myTotal.setText("Total: " + craps.getMyTotal());
				myPoint.setText("Points: " + craps.getPoints());
				bank.setBet(0);
				myBet.setText("Bet: " + bank.getBet());
				if (craps.getGameActive()) {
					myPlayAgain.setEnabled(false);
				}

			}

		});

		mySetBank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				myBankText.setEnabled(false);
				mySetBank.setEnabled(false);
				myBetText.setEnabled(true);
				myReset.setEnabled(true);
				JOptionPane.showMessageDialog(null, "Please set the bet amount.");

			}
		});

		myBankText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				int num = Integer.parseInt(myBankText.getText().toString());

				// input value valid
				if (num <= 0) {
					JOptionPane.showMessageDialog(null, "Not valid bank amount.");
					mySetBank.setEnabled(false);
				} else {
					bank.setMoney(num);
					mySetBank.setEnabled(true);
					myBank.setText("Bank: " + bank.getMoney());
				}
			}
		});

		myBetText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				int num = Integer.parseInt(myBetText.getText().toString());
				if (num > bank.getMoney() || num < 0) {
					JOptionPane.showMessageDialog(null,
							"Not a valid bet must be greater than 0 and less than or equal to" + " total in bank.");
				} else {
					bank.setBet(num);
					myBet.setText("Bet: " + bank.getBet());
					myRoll.setEnabled(true);
					myBetText.setEnabled(false);
				}

			}
		});

	}

	/**
	 * Creates the GUI for the craps game by having a JFrame
	 * that creates a panel to implement into the frame adding
	 * in all the components.
	 * 
	 */
	public static void createGui() {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final CrapsView mainPanel = new CrapsView();

				CrapsGame.getCrapsInstance().addPropertyChangeListener(mainPanel);
				final JFrame window = new JFrame("Game of Craps");

				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setJMenuBar(mainPanel.menu(window));
				window.setContentPane(mainPanel);

				window.pack();
				window.setVisible(true);
			}
		});

	}

	/**
	 * Property change listener to get the value and if its false
	 * turns off roll dice button and game is not active.
	 * 
	 */
	@Override
	public void propertyChange(PropertyChangeEvent theEvt) {

		if ((boolean) theEvt.getNewValue() == false) {
			myRoll.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Game not active!");
		}

	}
}
