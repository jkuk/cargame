<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
>>>>>>> upstream/master
import java.lang.Math;

public class Car
{
<<<<<<< HEAD
  private double speed;
  private double mpg;
  private double tankSize;
  private double fuel;
  private double totalDistance;
  private double distance;
=======
  private int speed;
  private int mpg;
  private int tankSize;
  private int fuel;
  private int distance;
>>>>>>> upstream/master
  private ArrayList<Stop> stopList;
  private Stop lastStop;
  private Stop nextStop;
  private boolean raceFinished;
  
  public Car(ArrayList<Stop> s)
  {
    Random r = new Random();
    
    speed = (double)(r.nextInt(30) + 20);
    mpg = (double)(r.nextInt(20) + 10);
    tankSize = (double)(r.nextInt(10) + 10);
    fuel = tankSize;
    distance = 0;
    raceFinished = false;
    stopList = new ArrayList<Stop>();
    this.shuffleStops(s);
    nextStop = stopList.get(0);
    this.setStop();
    this.findDistance();
  }
  public void shuffleStops(ArrayList<Stop> s)
  {
    Random r = new Random();
    int index;
    while(!s.isEmpty())
    {
      index = r.nextInt(s.size());
      stopList.add(s.get(index));
      s.remove(index);
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
  public void setStop()
  {
<<<<<<< HEAD
    lastStop = nextStop;
    stopList.remove(lastStop);
=======
    stopList.remove(lastStop);
    lastStop = nextStop;
>>>>>>> upstream/master
    if(stopList.isEmpty())
      this.setRaceFinished(true);
    else
      nextStop = stopList.get(0);
  }
<<<<<<< HEAD
  public void findDistance()
  {
    totalDistance = Math.sqrt((lastStop.getX()-nextStop.getX())^2
                        +(lastStop.getY()-nextStop.getY())^2);
=======
  public int findDistance()
  {
    distance = Math.sqrt(Math.abs(lastStop.getX()-nextStop.getX())^2
                        +Math.abs(lastStop.getY()-nextStop.getY())^2);
>>>>>>> upstream/master
  }
  public void refuel()
  {
    this.setFuel(tankSize);
  }
  public void drive()
  {
    for(int i = 1; i <= speed; i++)
    {
      if(fuel == 0)
        break;
      else
      {
        distance -= speed;
        fuel -= speed / mpg;
      }
    }
  }
}