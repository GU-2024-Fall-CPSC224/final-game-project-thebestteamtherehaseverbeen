/*
 * Final project main driver class
 * 
 * 
 * Project Description: Tanks is a two player game that uses physics to aim and fire at the
 * opponent until health completely runs out for a player. 
 * 
 * 
 * Contributors: Abby Fewel, Ayden Humphries, Christian Carrington
 * 
 *  
 * Copyright: 2023
 */
package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Main program class for launching your team's program. */
public class MainGame {
    private JFrame frame = new JFrame(); // the frame that opens when the program is run
    // panels in the border layout:
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel centerNorthPanel = new JPanel();
    private JPanel centerSouthPanel = new JPanel();
    private JPanel instructionsPanel = new JPanel();
    // the label that goes at the bottom:
    private JLabel title = new JLabel("TANKS");
    private JLabel names = new JLabel("By Christain Carrington, Abby Fewel, and Ayden Humphries");
    // buttons that go in the middle, in panel 5:
    private JButton start = new JButton("Start");
    private JButton howToPlay = new JButton("How to Play");
    JButton red = new JButton();
    JButton orange = new JButton();
    JButton yellow = new JButton();
    JButton green = new JButton();
    JButton blue = new JButton();
    JButton pink = new JButton();
    // image that also goes in the middle, in panel 4:
    private JLabel tankPicture = new JLabel();
    private JLabel howToPlayFrameIcon = new JLabel();
    private JFrame instructionsFrame = new JFrame();

    JTextField player1NameTextField = new JTextField();
    JTextField player2NameTextField = new JTextField();
    // Player player1 = new Player();
    // Player player2 = new Player();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainGame game = new MainGame();
                System.out.println("Tanks");
                game.formattingIntroScreen();
            }
        });
    }

    /**
     * This method formats the start screen that has an image of a tank, a title,
     * two buttons, and author names.
     */
    public void formattingIntroScreen() {
        setUpButtonListeners(); // to make Start and How to Play buttons listen
        // formats the frame:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // defaults settings
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        northPanel.setBackground(Color.GREEN); // colors
        centerPanel.setBackground(Color.lightGray);
        southPanel.setBackground(Color.white);
        northPanel.setPreferredSize(new Dimension(100, 70)); // dimensions of panels
        centerPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 50));
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        title.setFont(new Font("Algerian", Font.BOLD, 50));
        northPanel.add(title);
        southPanel.add(names);
        centerPanel.add(centerNorthPanel, BorderLayout.NORTH); // putting border layout in center panel
        centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
        ImageIcon tankStartScreenIcon = new ImageIcon("tank_intro_screen.jpg");
        tankPicture.setIcon(tankStartScreenIcon);
        centerNorthPanel.add(tankPicture);
        // centerNorthPanel.setIconImage(tankPicture.getImage()); // STILL WORKING ON
        // GETTING THIS PICTURE TO UPLOAD RIGHT :)
        centerSouthPanel.add(start);
        centerSouthPanel.add(howToPlay);
    }

    public void formattingStartScreenPlayerText(JPanel startingPanelCenter) {
        // frame settings
        JFrame startingFrame = new JFrame();
        startingFrame.setLayout(new BorderLayout());
        startingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // making panels
        JPanel startingPanelNorth = new JPanel();
        JPanel startingPanelSouth = new JPanel();
        JPanel playerPanel = new JPanel();
        // making labels and text fields
        JLabel startLabel = new JLabel("Player Settings");
        JLabel player1NameLabel = new JLabel("Player #1 Name: ");
        JLabel enterNameInstructionsLabel = new JLabel("Enter names and press 'Enter'.");
        JLabel player2NameLabel = new JLabel("Player #2 Name: ");
        player1NameTextField.setText("Player 1       ");
        player2NameTextField.setText("Player 2       ");
        startLabel.setFont(new Font("Algerian", Font.BOLD, 50));
        startingPanelNorth.add(startLabel); // add the label to the north panel
        startingFrame.add(startingPanelNorth, BorderLayout.NORTH);
        startingFrame.add(startingPanelSouth, BorderLayout.SOUTH);
        JButton continueButton = new JButton("Continue");
        startingPanelSouth.add(continueButton);
        // set up the border layout in the center panel
        startingPanelCenter.setLayout(new BorderLayout());
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        enterNameInstructionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel nameInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameInputPanel.add(player1NameLabel);
        nameInputPanel.add(player1NameTextField);
        nameInputPanel.add(player2NameLabel);
        nameInputPanel.add(player2NameTextField);
        playerPanel.add(enterNameInstructionsLabel);
        playerPanel.add(nameInputPanel);
        startingPanelCenter.add(playerPanel, BorderLayout.NORTH);
        // now set up the panel!
        startingFrame.setSize(500, 280);
        startingFrame.add(startingPanelCenter, BorderLayout.CENTER);
        startingFrame.add(startingPanelSouth, BorderLayout.SOUTH);
        startingFrame.setVisible(true);
    }

    public void formattingStartScreenPlayerColor(JPanel startingPanelCenter) {
        red.setBackground(Color.red);
        orange.setBackground(Color.orange);
        yellow.setBackground(Color.yellow);
        green.setBackground(Color.green);
        blue.setBackground(Color.blue);
        pink.setBackground(Color.pink);
        JLabel player1Color = new JLabel("Player #1 Color: ");
        JLabel player2Color = new JLabel("Player #2 Color: ");
        JPanel player1ColorPanel = new JPanel();
        JPanel player2ColorPanel = new JPanel();
        player1ColorPanel.add(player1Color);
        player1ColorPanel.add(red);
        player1ColorPanel.add(yellow);
        player1ColorPanel.add(blue);
        player2ColorPanel.add(player2Color);
        player2ColorPanel.add(orange);
        player2ColorPanel.add(green);
        player2ColorPanel.add(pink);
        startingPanelCenter.add(player1ColorPanel, BorderLayout.WEST);
        startingPanelCenter.add(player2ColorPanel, BorderLayout.EAST);
    }

    /**
     * This method starts listening to the buttons to notice when they are clicked
     * and take proper action / call methods.
     */
    public void setUpButtonListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == howToPlay) { // STILL WORKING ON THIS
                    // this will open a frame that will have a file that has all of the instructions
                    // written out
                    ImageIcon howToPlayIcon = new ImageIcon("how_to_play.png"); // new icon with instructions
                    howToPlayFrameIcon.setIcon(howToPlayIcon); // set the icon for this label
                    instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    instructionsFrame.setSize(820, 800);
                    instructionsFrame.setLayout(new BorderLayout()); // Use a simple layout
                    instructionsPanel.setLayout(new BorderLayout()); // Let the image fill the panel
                    instructionsPanel.add(howToPlayFrameIcon, BorderLayout.CENTER); // Add the icon to the center
                    instructionsFrame.add(instructionsPanel, BorderLayout.CENTER); // Add the panel to the frame
                    instructionsFrame.setVisible(true);
                } else if (actionEvent.getSource() == start) {
                    JPanel startingPanelCenter = new JPanel();
                    formattingStartScreenPlayerText(startingPanelCenter);
                    formattingStartScreenPlayerColor(startingPanelCenter);
                }
            }
        };
        ActionListener textListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == player1NameTextField) {
                    // player1.setName(player1NameTextField.getText());
                    // System.out.println(player1.getName());
                } else if (actionEvent.getSource() == player2NameTextField) {
                    // player2.setName(player2NameTextField.getText());
                    // System.out.println(player2.getName());
                }
            }
        };
        ActionListener colorButtonsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == red) {
                    // player1.setColor("0xf33d3d, red");
                } else if (actionEvent.getSource() == orange) {
                    // player2.setColor("0xef8a3d, orange");
                } else if (actionEvent.getSource() == yellow) {
                    // player1.setColor("0xefd83d, yellow");
                } else if (actionEvent.getSource() == green) {
                    // player2.setColor("0x2bcc2e, green");
                } else if (actionEvent.getSource() == blue) {
                    // player1.setColor("0x3b89de, blue");
                } else if (actionEvent.getSource() == pink) {
                    // player2.setColor("0xed7ef6, pink");
                }
                // System.out.println(player1.getName() + "'s color has been set to " +
                // player1.getColor());
                // System.out.println(player2.getName() + "'s color has been set to " +
                // player2.getColor());
                System.out.println("Done with the color action listener method");
            }
        };
        start.addActionListener(buttonListener);
        howToPlay.addActionListener(buttonListener);
        player1NameTextField.addActionListener(textListener);
        player2NameTextField.addActionListener(textListener);
        red.addActionListener(colorButtonsListener);
        orange.addActionListener(colorButtonsListener);
        yellow.addActionListener(colorButtonsListener);
        green.addActionListener(colorButtonsListener);
        blue.addActionListener(colorButtonsListener);
        pink.addActionListener(colorButtonsListener);
    }

    // when adding action listener for continue, set the names again in case users
    // do not press 'Enter'

}
