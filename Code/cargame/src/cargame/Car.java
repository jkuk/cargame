
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
    lastStop = nextStop;
    stopList.remove(lastStop);
    if(stopList.isEmpty())
      this.setRaceFinished(true);
    else
      nextStop = stopList.get(0);
  }

  public void findDistance()
  {
    totalDistance = Math.sqrt((lastStop.getX()-nextStop.getX())^2
                        +(lastStop.getY()-nextStop.getY())^2);

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