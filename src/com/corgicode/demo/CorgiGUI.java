package com.corgicode.demo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;


// A class that represents a graphical user interface for the corgi simulation
class CorgiGUI extends JFrame implements ActionListener {
    // Components of the GUI
    private JLabel nameLabel; // a label to display the name of the corgi
    private JLabel energyLabel; // a label to display the energy level of the corgi
    private JLabel moodLabel; // a label to display the mood of the corgi
    private JButton barkButton; // a button to make the corgi bark
    private JButton wagTailButton; // a button to make the corgi wag its tail
    private JButton playFetchButton; // a button to make the corgi play fetch
    private JButton doTrickButton; // a button to make the corgi do a trick
    private JComboBox<String> trickComboBox; // a combo box to select a trick
    private JTextArea outputTextArea; // a text area to display the output of the simulation

    // Attributes of the GUI
    private static Corgi corgi; // a corgi object to simulate
    private static Ball ball; // a ball object to play fetch with

    // Constructor of the GUI
    public CorgiGUI(Corgi corgi, Ball ball) {
        this.corgi = corgi;
        this.ball = ball;
        nameLabel = new JLabel("Name: " + corgi.getName());
        energyLabel = new JLabel("Energy: " + corgi.getEnergy());
        moodLabel = new JLabel("Mood: " + corgi.getMood());
        barkButton = new JButton("Bark");
        wagTailButton = new JButton("Wag Tail");
        playFetchButton = new JButton("Play Fetch");
        doTrickButton = new JButton("Do Trick");
        trickComboBox = new JComboBox<String>(new String[]{"sit", "roll over", "shake paw", "speak"});
        outputTextArea = new JTextArea(10, 40);
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(); // a panel for the top part of the GUI
        topPanel.add(nameLabel);
        topPanel.add(energyLabel);
        topPanel.add(moodLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(); // a panel for the center part of the GUI
        centerPanel.add(barkButton);
        centerPanel.add(wagTailButton);
        centerPanel.add(playFetchButton);
        centerPanel.add(doTrickButton);
        centerPanel.add(trickComboBox);
        add(centerPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(outputTextArea); // a scroll pane for the text area
        add(scrollPane, BorderLayout.SOUTH);
        barkButton.addActionListener(this);
        wagTailButton.addActionListener(this);
        playFetchButton.addActionListener(this);
        doTrickButton.addActionListener(this);
        setTitle("Corgi Simulator");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // A method that handles the actions performed on the GUI
    public void actionPerformed(ActionEvent e) {
        Corgi corgiU = this.corgi;
        if (e.getSource() == barkButton) { // if the bark button is clicked
            corgiU.bark(); // make the corgi bark
            updateGUI(corgiU); // update the GUI labels and text area
        }

        if (e.getSource() == wagTailButton) { // if the wag tail button is clicked
            corgi.wagTail(); // make the corgi wag its tail
            updateGUI(corgi); // update the GUI labels and text area
        }

        if (e.getSource() == playFetchButton) { // if the play fetch button is clicked
            corgi.playFetch(ball); // make the corgi play fetch with the ball
            updateGUI(corgi); // update the GUI labels and text area
        }

        if (e.getSource() == doTrickButton) { // if the do trick button is clicked
            String trick = (String) trickComboBox.getSelectedItem(); // get the selected trick from the combo box
            corgi.doTrick(trick); // make the corgi do the trick
            updateGUI(corgi); // update the GUI labels and text area
        }

    }

    public void updateGUI(Corgi corgi) {
        energyLabel.setText("Energy: " + corgi.getEnergy());
        moodLabel.setText("Mood: " + corgi.getMood());
        outputTextArea.append(corgi.getName() + ":" +corgi.toString() + "\n");
        //outputTextArea.append(corgi.getName() + ": " + System.console().readLine() + "\n");
        outputTextArea.setCaretPosition(outputTextArea.getDocument().getLength());
    }
}
