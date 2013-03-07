package cargame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUICars extends JPanel{
  // constants for image file names
  private final String CAR = "car_";
  private final String STOP = "stop_";
  private final String IMAGE_DIRECTORY = "images\\";
  private final String IMAGE_EXTENSION = ".png";
  
  private Track aTrack;
  
  // the cars and stops will be displayed as jlabels with image icons
  private ArrayList<JLabel> carJLabels;
  private ArrayList<JLabel> stopJLabels;
  
  public GUICars(Track aTrack){
    this.aTrack = aTrack;
    buildTrack();
    buildCars();
  }
  
  // draw the track
  public void buildTrack(){
    JLabel stopLabel; // temporary JLabel to store each stop icon in, so it can be operated on, then added to the array
    ImageIcon stopIcon; // temporary ImageIcon so the stop icon can be operated on, then added to the jlabel
    ArrayList<Stop> stops = aTrack.getStops(); // temporarily store list of stops
    
    stopJLabels = new ArrayList<JLabel>(); // initialize the stops array list
    
    // loop the the array list of stops in the track object
    for (int i = 0; i < stops.size(); i++){ // loop through the list of stops
      stopIcon = new ImageIcon(IMAGE_DIRECTORY + STOP + i + IMAGE_EXTENSION); // create an image icon based on the constants and the index value
      stopLabel = new JLabel(stopIcon); // add the icon to the label
      
      // stopLabel.setBorder(stopIcon.getIconWidth(), stopIcon.getIconHeight()); // set the label's border to match the image icon's
      stopLabel.setLocation(stops.get(i).getX(), stops.get(i).getY()); // place the label at a specific location
      
      stopJLabels.add(stopLabel); // add it to the array of stop labels
      add(stopLabel); // add the stop image to the actual panel
    }
  }
  
  // draw the cars
  public void buildCars(){
    JLabel carLabel; // temprary JLabel to store each car in, so it can be operated on, then added to the array
    ImageIcon carIcon; // temporary ImageIcon so the cars can be operated on, then added to the jlabel
    ArrayList<Car> cars = aTrack.getCars(); // temporariliy store list of cars
    Stop carDeparture; // temporarily store car's departure location
    
    carJLabels = new ArrayList<JLabel>(); // initialize the car array list
    
    
    for (int i = 0; i < cars.size(); i++){ // loops through the list of cars
      carIcon = new ImageIcon(IMAGE_DIRECTORY + CAR + i + IMAGE_EXTENSION); // create an image icon based on the constants and the index value
      carLabel = new JLabel(carIcon); // add the icon to the label
      
      carDeparture = cars.get(i).getLastStop(); // store car's departure location
      
      carLabel.setLocation(carDeparture.getX(), carDeparture.getY()); // place the car label at a specific location
      carJLabels.add(carLabel); // add it to the array of car labels
      add(carLabel); // add the car image to the actual panel
    }
  }
  
  // method for repaint() calls
  public void paintComponent(Graphics g){
    Car aCar; // temporary car for operating on
    
    super.paintComponent(g);
    for (int i = 0; i < carJLabels.size(); i++){ // loop through list of car jlabels
      aCar = aTrack.getCars().get(i); // set the temporary car to the car at index 'i' of the track
      carJLabels.get(i).setLocation(calculateX(aCar, calculatePercentage(aCar)), calculateY(aCar, calculatePercentage(aCar)));
    }    
  }
  
  // calculates what percentage of the stop-to-stop the car has completed
  private double calculatePercentage(Car aCar){
    return aCar.getDistance() / aCar.getTotalDistance(); // divide distance left by total distance and return the value
  }
  
  // calculate the new x position of the car
  private int calculateX(Car aCar, double percentage){
    double originalX = aCar.getLastStop().getX(); // gets the original x position
    return (int)(percentage * (aCar.getNextStop().getX() - originalX) + originalX); // return the new x position
  }
  
  // calculate the new y position of the car
  private int calculateY(Car aCar, double percentage){
    double originalY = aCar.getLastStop().getY(); // gets the original y position
    return (int)(percentage * (aCar.getNextStop().getY() - originalY) + originalY); // return the new y position
  } 
}