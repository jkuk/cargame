package cargame;

import java.util.ArrayList;

public class Track {

    private ArrayList<Stop> locations;
    private ArrayList<Car> cars;
    private int distance;
    //private int delay = 1000;
    private boolean paused; //** set this value in the constructor instead

    //constructor (not sure if needed. based on gui implementation)
    public Track() { //** I think we'll probably need to pass parameters such as number of stops, and number of cars
        paused = true; //** i said the default value should be true -- i feel like it makes more sense to not start running until you hit play
        //** plus, I have the GUI set to create a new Track() when you hit the reset, and I feel like the game should start paused for that
        locations = new ArrayList<Stop>(); //** have to create the array list object first
        cars = new ArrayList<Car>();

        /* example on how to use the array list. if you want to add an element to it, do this:
* locations.add(Stop.A);
* cars.add(new Car());
*
* to access a specific element, use the get() method:
*
* locations.get(0); -- retrieves the object stored at index 0
* cars.get(1); -- retrieves the object stored at index 1 - which wouldn't exist right now so this would cause an error
*
* to find how many elements are in an array list, use the .size() method:
*
* locations.size();
**/

        //super helpful comments btw julian. thanks.

        locations.add(Stop.A);
        locations.add(Stop.B);
        locations.add(Stop.C);
        locations.add(Stop.D);
        
        setCars(4); // added this

    }

    public ArrayList<Stop> getStops() { //** I filled in the return type here
        return locations;
        // return a set of valid stops based on a starting position
    }

    //** made a little method for returning the cars array list
    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(int numbOfCars) {

        for (int i = 0; i < numbOfCars; i++){
            cars.add(new Car(locations));
          }
        
// Random r = new Random(System.currentTimeMillis());
// int index;
//
// //temporarily keeps track of valid locations
// ArrayList<Stop> locations2;
// locations2 = new ArrayList<Stop>();
//
// int[] indexArray;
// indexArray = new int[locations.size()];
//
// boolean contains = false;
//
//
// for (int i = 0; i <= numbOfCars; i++) { // loop for all cars
// for (int x = 0; x < locations.size(); x++) { // loop for starting positions
// //randomised starting positon 1 - 4
// index = (r.nextInt(4));
// //random set of valid stops based on starting position
//
// int y = 0;
// while (contains == false) { // loop for not having multiples of the same position
//
// if (indexArray[y] == index) {
// contains = true;
// indexArray[x] = index;
// locations2.add(locations.get(index));
// }
// y++;
// }
// }
// //instasiate new car with valid stops
// cars.add(new Car(locations));
//
//
//
// }
    } // should end up with an array list of cars with random starting positions and valid stops

    public boolean getPaused() {
        //Have a return for if pause is active or not
        // true if paused
        // false otherwise
        return paused;

    }

    public void pause() {
        //** I changed this to just toggle the boolean value from true / false -- why did this need a return value??
        paused = !paused;
    }

    public void play() {
        // update new position of all cars by one step
        for(int x = 0; x < cars.size(); x++){
            cars.get(x).drive();
        }
    }
}