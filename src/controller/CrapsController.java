/*
 * TCSS 305 Final Assignment - craps
 */
package controller;

import javax.swing.JPanel;

import view.CrapsView;

/**
 * Craps controller that calls the GUI of the craps game.
 * 
 * @author Andrew Chon
 * @version December 13, 2022
 */
public class CrapsController extends JPanel {

	/**
	 * A generated serial version UID for object Serialization.
	 * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
	 */
    private static final long serialVersionUID = 1L;

    /**
     * Base constructor
     */
    public CrapsController() {
      //  super();
    }

    /**
     * Main method that calls the CrapsView createGui method.
     * 
     * @param theArgs
     */
    public static void main(String[] theArgs) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CrapsView.createGui();
            }
        });

    }

}
