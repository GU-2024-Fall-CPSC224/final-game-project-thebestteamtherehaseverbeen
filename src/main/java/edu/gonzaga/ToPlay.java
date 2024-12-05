package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import org.dyn4j.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToPlay {
    String name;
    String color;
    boolean easyOrHard = true; // true is easy, false is hard, default is easy

    public ToPlay() {
        this.name = "Unidentified User";
        this.color = "Red";
    }

    private JFrame frame = new JFrame(); // the frame that opens when the program is run
    private JFrame gameFrame = new JFrame();
    private JFrame gameOverFrame = new JFrame();

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
    private JButton continueButton = new JButton("Continue");

    JButton red = new JButton();
    JButton orange = new JButton();
    JButton yellow = new JButton();
    JButton green = new JButton();
    JButton blue = new JButton();
    JButton pink = new JButton();
    JButton easy = new JButton("Easy");
    JButton hard = new JButton("Hard");
    // image that also goes in the middle, in panel 4:
    private JLabel tankPicture = new JLabel();
    private JLabel howToPlayFrameIcon = new JLabel();
    private JFrame instructionsFrame = new JFrame();

    JTextField player1NameTextField = new JTextField();
    JTextField player2NameTextField = new JTextField();
    String player1name = "Unidentifiable Player";
    String player2name = "Unidentifiable Player";
    String player1Color = " ";
    String player2Color = " ";
    Tank player1Tank = new Tank();
    Tank player2Tank = new Tank();

    /**
     * This method formats the start screen that has an image of a tank, a title,
     * two buttons, and author names.
     */
    public void formattingIntroScreen() {
        setUpButtonListeners(); // Setup listeners for buttons

        // Frame setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 950);
        frame.setLayout(new BorderLayout());

        // Load image
        JLabel tankPicture = new JLabel();
        ImageIcon tankStartScreenIcon = new ImageIcon("tank_intro_screen.png");
        tankPicture.setIcon(tankStartScreenIcon);
        tankPicture.setSize(1500, 850);
        tankPicture.setHorizontalAlignment(JLabel.CENTER);

        // Add components
        frame.add(tankPicture, BorderLayout.CENTER); // Add image in the center
        frame.add(centerSouthPanel, BorderLayout.SOUTH); // Buttons in the south panel
        centerSouthPanel.setSize(1500, 100);
        centerSouthPanel.setBackground(Color.lightGray);
        start.setBackground(new Color(0x134511));
        howToPlay.setBackground(new Color(0x134511));
        start.setForeground(Color.white);
        howToPlay.setForeground(Color.white);

        centerSouthPanel.add(start);
        centerSouthPanel.add(howToPlay);

        // Make frame visible
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
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
        startingFrame.setLocation(500, 300);
        startingFrame.setVisible(true);
    }

    public void formattingStartScreenPlayerColor(JPanel startingPanelCenter) {
        red.setBackground(Color.red);
        orange.setBackground(Color.orange);
        yellow.setBackground(Color.yellow);
        green.setBackground(Color.green);
        blue.setBackground(Color.blue);
        pink.setBackground(Color.pink);
        easy.setBackground(Color.lightGray);
        hard.setBackground(Color.lightGray);
        JLabel player1Color = new JLabel("Player #1 Color: ");
        JLabel player2Color = new JLabel("Player #2 Color: ");
        JLabel difficultyLabel = new JLabel("Select Difficulty: ");
        JPanel difficultJPanel = new JPanel();
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
        difficultJPanel.add(difficultyLabel);
        difficultJPanel.add(easy);
        difficultJPanel.add(hard);
        startingPanelCenter.add(player1ColorPanel, BorderLayout.WEST);
        startingPanelCenter.add(player2ColorPanel, BorderLayout.EAST);
        startingPanelCenter.add(difficultJPanel, BorderLayout.SOUTH);
    }

    public void gameOverScreen() {
        JLabel gameOverLabelBackground = new JLabel();
        ImageIcon gameOverIcon = new ImageIcon("game_over.png");
        gameOverLabelBackground.setIcon(gameOverIcon);
        gameOverLabelBackground.setSize(1100, 700);
        gameOverLabelBackground.setHorizontalAlignment(JLabel.CENTER);
        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setFont(new Font("Algerian", Font.BOLD, 100));
        JPanel gameOverScreenPanel = new JPanel(new BorderLayout());
        gameOverFrame.setBackground(Color.black);
        gameOverLabel.setForeground(Color.red);
        JLabel winnerLabel = new JLabel("Player 1 wins!"); // this is just a default
        if (player1Tank.getHealth() == 0) {
            winnerLabel.setText(player2name + "wins!");
        } else if (player2Tank.getHealth() == 0) {
            winnerLabel.setText(player2name + "wins!");
        }
        winnerLabel.setForeground(Color.white);
        // gameOverScreenPanel.add(gameOverLabel, BorderLayout.NORTH);
        // gameOverScreenPanel.add(winnerLabel, BorderLayout.CENTER);
        // gameOverScreenPanel.setBackground(Color.black);
        gameOverScreenPanel.add(gameOverLabelBackground, BorderLayout.CENTER);
        gameOverFrame.add(gameOverScreenPanel);
        gameOverFrame.setSize(1200, 800);
        gameOverFrame.setLocation(90, 75);
        gameOverFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameOverFrame.setVisible(true);
    }

    public String getPlayer1Name() { // called from MainGame
        return player1name;
    }

    public void setPlayer1Name(String player1name) { // called from MainGame
        this.player1name = player1name;
    }

    public String getPlayer2Name() { // called from MainGame
        return player2name;
    }

    public void setPlayer2Name(String player2name) { // called from MainGame
        this.player2name = player2name;
    }

    public String getPlayer1Color() { // called from MainGame
        System.out.println(player1Color);
        return player1Color;
    }

    public void setPlayer1Color(String player1Color) { // called from MainGame
        this.player1Color = player1Color;
        System.out.println(player1Color);
    }

    public String getPlayer2Color() { // called from MainGame
        System.out.println(player2Color);
        return player2Color;
    }

    public void setPlayer2Color(String player2Color) { // called from MainGame
        this.player2Color = player2Color;
        System.out.println(player2Color);
    }

    /**
     * This method starts listening to the buttons to notice when they are clicked
     * and take proper action / call methods.
     */
    public void setUpButtonListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == howToPlay) {
                    ImageIcon howToPlayIcon = new ImageIcon("how_to_play.png"); // new icon with instructions
                    howToPlayFrameIcon.setIcon(howToPlayIcon); // set the icon for this label
                    instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    instructionsFrame.setSize(820, 800);
                    instructionsFrame.setLayout(new BorderLayout());
                    instructionsPanel.setLayout(new BorderLayout());
                    instructionsPanel.add(howToPlayFrameIcon, BorderLayout.CENTER); // adding to center
                    instructionsFrame.add(instructionsPanel, BorderLayout.CENTER);
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
                    setPlayer1Name(player1NameTextField.getText());
                    System.out.println(getPlayer1Name());
                } else if (actionEvent.getSource() == player2NameTextField) {
                    setPlayer2Name(player2NameTextField.getText());
                    System.out.println(getPlayer2Name());
                }
            }
        };
        ActionListener colorButtonsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == red) {
                    setPlayer1Color("0xf33d3d, red");
                } else if (actionEvent.getSource() == orange) {
                    setPlayer2Color("0xef8a3d, orange");
                } else if (actionEvent.getSource() == yellow) {
                    setPlayer1Color("0xefd83d, yellow");
                } else if (actionEvent.getSource() == green) {
                    setPlayer2Color("0x2bcc2e, green");
                } else if (actionEvent.getSource() == blue) {
                    setPlayer1Color("0x3b89de, blue");
                } else if (actionEvent.getSource() == pink) {
                    setPlayer2Color("0xed7ef6, pink");
                }
                System.out.println(getPlayer1Name() + "'s color is now set to " +
                        getPlayer1Color());
                System.out.println(getPlayer2Name() + "'s color is now set to " +
                        getPlayer2Color());
                System.out.println("Done with the color action listener method");
            }
        };
        ActionListener difficultyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == easy) {
                    easyOrHard = true;
                } else if (actionEvent.getSource() == hard) {
                    easyOrHard = false;
                }
            }
        };
        ActionListener continueListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == continueButton) {
                    // Create a custom JPanel with a background image
                    JPanel panelWithBackground = new JPanel(new GridLayout(200, 200)) {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            ImageIcon backgroundImage = new ImageIcon("background.png");
                            g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                        }
                    };
                    System.out.println("Difficulty is set to " + easyOrHard);
                    setPlayer1Name(player1NameTextField.getText());
                    System.out.println(getPlayer1Name());
                    setPlayer2Name(player2NameTextField.getText());
                    System.out.println(getPlayer2Name());
                    gameFrame.setIconImage(new ImageIcon("background.png").getImage());
                    gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    gameFrame.setSize(1400, 850);
                    gameFrame.add(panelWithBackground); // Add the custom panel with background
                    gameFrame.setLocation(50, 20);
                    gameFrame.setVisible(true);
                }
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
        continueButton.addActionListener(continueListener);
        easy.addActionListener(difficultyListener);
        hard.addActionListener(difficultyListener);
    }

    // when adding action listener for continue, set the names again in case users
    // do not press 'Enter'

}
