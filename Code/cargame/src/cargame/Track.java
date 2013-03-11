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

        while (numbOfCars > 0) {
            cars.add(new Car(locations));
            numbOfCars -= 1; //incraments 
        }
        
//        Random r = new Random(System.currentTimeMillis());
//        int index;
//
//        //temporarily keeps track of valid locations
//        ArrayList<Stop> locations2;
//        locations2 = new ArrayList<Stop>();
//
//        int[] indexArray;
//        indexArray = new int[locations.size()];
//
//        boolean contains = false;
//
//        
//        for (int i = 0; i <= numbOfCars; i++) { // loop for all cars
//            for (int x = 0; x < locations.size(); x++) { // loop for starting positions
//                //randomised starting positon 1 - 4
//                index = (r.nextInt(4));
//                //random set of valid stops based on starting position
//
//                int y = 0;
//                while (contains == false) { // loop for not having multiples of the same position
//
//                    if (indexArray[y] == index) {
//                        contains = true;
//                        indexArray[x] = index;
//                        locations2.add(locations.get(index));
//                    }
//                    y++;
//                }
//            }
//            //instasiate new car with valid stops
//            cars.add(new Car(locations));
//            
//
//
//        }
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

        /* I designed the GUI to loop indefinitely until you hit the pause button.
         * We need to decide whether it's the GUI or the Track that loops indefinitely.
         * We can't have both doing it, which is what's going on right now.
         * I feel it makes more sense for the GUI to handle the infinite loop,
         * 'cause either way, the Track needs a method to simply step the timer
         * by 1 increment at a time, or else the "step" button won't be able to function
         * unless I make it something pauses the timer and then let's it run for a very short period of time. 
         * 
         * The way I have the GUI written right now, this only has to updatePosition() once.
         * 
         //loops infinitely based on pause status
         while(!paused){ //** made it just reference the variable directly instead of calling a method
         updatePosition();
         //** this seems redundant to me
         //if(getPaused()){
         //  break;
         //}
         }
         */


        /*
         * Based on that notion I will simply set up the play function to be a wrapper of updatePosition()
         * Technically speaking you dont need to have play() at all but for simplicity sake we can leave it
         */

        updatePosition(); //snoop dogg wrapper function call :P
    }

    public void updatePosition() {
        // update new position of all cars by one step
        for(int x = 0; x < cars.size(); x++){
            cars.get(x).drive();
        }
    }
}