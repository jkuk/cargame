package cargame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class GUICars extends JPanel{
  // constants for image file names
  private final File baseLoc = new File("images");
  private final String CAR = "car_";
  private final String STOP = "stop_";
  private final String IMAGE_EXTENSION = ".png";
  
  private Track aTrack;
  
  private ArrayList<ImageIcon> carImageIcons;
  private ArrayList<ImageIcon> stopImageIcons;
  
  public GUICars(Track aTrack){
    this.aTrack = aTrack;
    buildTrack();
    buildCars();
  }
  
  // draw the track
  private void buildTrack(){
    ImageIcon stopIcon; // temporary ImageIcon so the stop icon can be operated on, then added to the jlabel
    ArrayList<Stop> stops = aTrack.getStops(); // temporarily store list of stops  
    
    stopImageIcons = new ArrayList<ImageIcon>(); // initialize the stops array list
    
    File stopImage;
    String stopImageString;
    
    // loop the the array list of stops in the track object
    for (int i = 0; i < stops.size(); i++){ // loop through the list of stops
      stopImageString = STOP + i + IMAGE_EXTENSION;
      stopImage = new File(baseLoc, stopImageString);
      stopIcon = new ImageIcon(stopImage.toString()); // create an image icon based on the constants and the index value
      stopImageIcons.add(stopIcon);
    }
  }
  
  // draw the cars
  private void buildCars(){
    ImageIcon carIcon; // temporary ImageIcon so the cars can be operated on, then added to the jlabel
    ArrayList<Car> cars = aTrack.getCars(); // temporariliy store list of cars
    //Stop carDeparture; // temporarily store car's departure location
    
    carImageIcons = new ArrayList<ImageIcon>(); // initialize the car array list
    
    File carImage;
    String carImageString;
    
    for (int i = 0; i < cars.size(); i++){ // loops through the list of cars     
      carImageString = CAR + i + IMAGE_EXTENSION;
      carImage = new File(baseLoc, carImageString);
      carIcon = new ImageIcon(carImage.toString());
      carImageIcons.add(carIcon);
      //carDeparture = cars.get(i).getLastStop(); // store car's departure location
    }
  }
  
  // method for repaint() calls
  public void paintComponent(Graphics g){
    Car aCar; // temporary car for operating on
    Stop aStop;
    
    super.paintComponent(g);
    for (int i = 0; i < carImageIcons.size(); i++){ // loop through list of car jlabels
      aCar = aTrack.getCars().get(i); // set the temporary car to the car object at index 'i' of the track
      
      if (aCar.getRaceFinished()){ // if the race for the car in question is finished
        carImageIcons.get(i).paintIcon(this, g, aCar.getLastStop().getX(), aCar.getLastStop().getY()); // set image icon to final stop
      }
      else{ // set image icon to current location
        carImageIcons.get(i).paintIcon(this, g, calculateX(aCar, calculatePercentage(aCar)), calculateY(aCar, calculatePercentage(aCar)));
      }
    }
    
    if (!aTrack.getCarsFinished().isEmpty()){
      String winner = "";
      for (int i = 0; i < aTrack.getCars().size(); i++){
        if (aTrack.getCars().get(i) == aTrack.getCarsFinished().get(0)){
          winner += i;
        }
      }
      g.drawString("Car " + winner + " is the winner!", 250, 250);
    }
    
    for (int i = 0; i < stopImageIcons.size(); i ++){
      aStop = aTrack.getStops().get(i);
      stopImageIcons.get(i).paintIcon(this, g, aStop.getX(), aStop.getY());
    }
  }
  
  // calculates what percentage of the stop-to-stop the car has completed
  private double calculatePercentage(Car aCar){
    return (double)(1 - aCar.getDistance() / aCar.getTotalDistance()); // divide distance left by total distance and return the value
  }
  
  // calculate the new x position of the car
  private int calculateX(Car aCar, double percentage){
    double originalX = aCar.getLastStop().getX(); // gets the original x position
    double additionalX = percentage * (aCar.getNextStop().getX() - originalX); // calculate the additional x position
    return (int)(originalX + additionalX); // return the new x position
  }
  
  // calculate the new y position of the car
  private int calculateY(Car aCar, double percentage){
    double originalY = aCar.getLastStop().getY(); // gets the original y position
    double additionalY = percentage * (aCar.getNextStop().getY() - originalY); // calculate the additional y position
    return (int)(originalY + additionalY); // return the new y position
  }
}