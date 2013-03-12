package cargame;

import java.util.ArrayList;

public class Track {
  
  private ArrayList<Stop> locations;
  private ArrayList<Car> cars;
  private ArrayList<Car> carsFinished;
  private int distance;
  private boolean paused;
  
  public Track() {
    paused = true;
    locations = new ArrayList<Stop>();
    cars = new ArrayList<Car>();
    carsFinished = new ArrayList<Car>();
    locations.add(Stop.A);
    locations.add(Stop.B);
    locations.add(Stop.C);
    locations.add(Stop.D);
    
    setCars(4);
  }
  
  public ArrayList<Stop> getStops() {
    return locations;
    // return a set of valid stops based on a starting position
  }
  
  public ArrayList<Car> getCars() {
    return cars;
  }
  
  public void setCars(int numbOfCars) {
    for (int i = 0; i < numbOfCars; i++) {
      cars.add(new Car(locations));
    }
  } // should end up with an array list of cars with random starting positions and valid stops
  
  public boolean getPaused() {
    //Have a return for if pause is active or not
    // true if paused
    // false otherwise
    return paused;
  }
  
  public ArrayList<Car> getCarsFinished() {
    return carsFinished;
  }
  
  public void pause() {
    paused = !paused;
  }
  
  public void play() {
    // update new position of all cars by one step
    for (int x = 0; x < cars.size(); x++) {
      cars.get(x).drive();
      if (!carsFinished.contains(cars.get(x))
            && cars.get(x).getRaceFinished()) {
        carsFinished.add(cars.get(x));
      }
    }
  }
}