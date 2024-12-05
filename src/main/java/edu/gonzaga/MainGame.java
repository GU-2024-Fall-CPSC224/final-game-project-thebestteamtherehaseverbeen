/**
 * Final project main driver class
 * 
 * 
 * Project Description: Tanks is a two player game that uses physics to aim and fire at the
 * opponent until health completely runs out for a player. 
 * 
 * Contributors: Abby Fewel, Ayden Humphries, Christian Carrington
 * 
 *  
 * Copyright: 2023
 */
package edu.gonzaga;

/** Main program class for launching your team's program. */
public class MainGame {
    public static void main(String[] args) {
        ToPlay playing = new ToPlay();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Tanks");
                playing.formattingIntroScreen();
            }
        });
    }
}
