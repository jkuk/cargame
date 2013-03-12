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
        locations = new ArrayList<Stop>(); //** have to create the array list object first
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

    //** made a little method for returning the cars array list
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
        //** I changed this to just toggle the boolean value from true / false -- why did this need a return value??
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


        /*
         * Based on that notion I will simply set up the play function to be a wrapper of updatePosition()
         * Technically speaking you dont need to have play() at all but for simplicity sake we can leave it
         */



    }

    public void updatePosition() {
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