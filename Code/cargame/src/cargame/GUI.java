package cargame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
  private JButton playPauseButton, stepButton, resetButton;
  private JPanel buttonPanel;
  private GUICars graphicsPanel;
  
  private Track aTrack;
  
  private final int WIDTH = 800, HEIGHT = 800;
  
  private final String STEP = "Step";
  private final String RESET = "Reset";
  private final String PLAY = "Play";
  private final String PAUSE = "Pause";
  
  public GUI(){
    // basic panel set up
    setSize(WIDTH, HEIGHT);
    setLayout(new BorderLayout());
    
    // builds the 2 panels
    buildGraphicsPanel();
    buildButtonPanel();
    
    // adds the 2 panels to the main panel
    add(graphicsPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    
    // make the frame visible
    setVisible(true);
  }
  
  // build the graphics panel that has the track and cars
  private void buildGraphicsPanel(){
    // create a new track -- not sure if we're going to pass parameters to the track
    aTrack = new Track();
    graphicsPanel = new GUICars(aTrack);
  }
  
  // build the button panel that will hold the play/pause, step, and reset buttons
  private void buildButtonPanel(){
    buttonPanel = new JPanel();
    
    // create the buttons with the specified text
    playPauseButton = new JButton(PLAY);
    stepButton = new JButton(STEP);
    resetButton = new JButton(RESET);
    
    // add the corresponding action listener to each button
    playPauseButton.addActionListener(new PauseListener());
    stepButton.addActionListener(new StepListener());
    resetButton.addActionListener(new ResetListener());
    
    // add the buttons to the panel
    buttonPanel.add(playPauseButton);
    buttonPanel.add(stepButton);
    buttonPanel.add(resetButton);
  }
  
  // listener for the reset button
  private class ResetListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      // if the button is clicked, create a brand new graphics panel, which also creates a new track
      remove(graphicsPanel); // remove the graphics panel
      buildGraphicsPanel(); // rebuild it
      add(graphicsPanel, BorderLayout.CENTER); // then readd it to the frame
      
      playPauseButton.setText(PLAY); // set the text to say play
      
      validate(); // validate
      repaint(); // then update it
    }
  }
  
  // listener for the pause/play button
  private class PauseListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      //aTrack.pause(); // pause or resume the game
      
      if (!aTrack.getPaused()){
        //playPauseButton.setText(PAUSE); // if the game is now playing, set the text to say pause
      }
      else{
        //playPauseButton.setText(PLAY); // else, set the text to say play
      }
      
      //while (!aTrack.getPaused()){
      for (int i = 0; i < 10; i++){
        // while the game is not paused, step the timer
        aTrack.play();
        repaint();
      }
    }
  }
  
  private class StepListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if (!aTrack.getPaused()){
        // if the game is not paused, pause it
        // forces the game to be paused whenever the step button is clicked
        aTrack.pause();
        playPauseButton.setText(PLAY); // set the text to say play
      }
      // and step the timer
      aTrack.play();
      repaint();
    }
  }
}