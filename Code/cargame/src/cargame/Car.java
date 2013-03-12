package cargame;

import java.util.*;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.*;
import java.lang.Math;

public class Car
{
  private double speed;
  private double mpg;
  private double tankSize;
  private double fuel;
  private double totalDistance;
  private double distance;
  private Stop lastStop;
  private Stop nextStop;
  private ArrayList<Stop> stopList;
  private boolean raceFinished;
  
  public Car(ArrayList<Stop> s)
  {
    Random r = new Random();
    
    speed = (double)(r.nextInt(30) + 20);
    mpg = (double)(r.nextInt(20) + 10);
    tankSize = (double)(r.nextInt(10) + 10);
    
    fuel = tankSize;
    raceFinished = false;
    stopList = new ArrayList<Stop>();
    shuffleStops(s);
    nextStop = stopList.get(0);
    setStop();
  }
  public void shuffleStops(ArrayList<Stop> s)
  {
    ArrayList<Stop> temp = new ArrayList<Stop>(s);
    Random r = new Random();
    int index;
    while(!temp.isEmpty())
    {
      index = r.nextInt(temp.size());
      stopList.add(temp.get(index));
      temp.remove(index);
    }
  }
  public void setSpeed(double s)
  {
    speed = s;
  }
  public void setMPG(double m)
  {
    mpg = m;
  }
  public void setTankSize(double t)
  {
    tankSize = t;
  }
  public void setFuel(double f)
  {
    fuel = f;
  }
  public void setRaceFinished(boolean b)
  {
    raceFinished = b;
  }
  public double getSpeed()
  {
    return speed;
  }
  public double getMPG()
  {
    return mpg;
  }
  public double getTankSize()
  {
    return tankSize;
  }
  public double getFuel()
  {
    return fuel;
  }
  public double getDistance()
  {
    return distance;
  }
  public double getTotalDistance()
  {
    return totalDistance;
  }
  public boolean getRaceFinished()
  {
    return raceFinished;
  }
  public Stop getLastStop(){
    return lastStop;
  }
  public Stop getNextStop(){
    return nextStop;
  }
  public void setStop()
  {
    lastStop = nextStop;
    stopList.remove(lastStop);
    
    if(stopList.isEmpty()){
      
      this.setRaceFinished(true);
      nextStop = null;
      distance = 0;
    }
    else{
      nextStop = stopList.get(0);
      findDistance();
      distance = totalDistance;
    }
  }
  
  public void findDistance()
  {
    double tempX = lastStop.getX() - nextStop.getX();
    double tempY = lastStop.getY() - nextStop.getY();
    tempX *= tempX;
    tempY *= tempY;
    
    totalDistance = Math.sqrt(tempX + tempY);
  }
  public void refuel()
  {
    this.setFuel(tankSize);
  }
  public void drive() {
    if (raceFinished){
    }
    else{
      if(fuel > 0)
      {
        distance -= speed;
        fuel -= speed / mpg;
      }
      else{
        refuel();
      }
      if (distance <= 0){
        setStop();
      }
    }
  }
}