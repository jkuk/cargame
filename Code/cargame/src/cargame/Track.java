package cargame;

import java.util.ArrayList;
import java.util.Random;

public class Track {

    private ArrayList<Stop> locations;
    private ArrayList<Car> cars;
    private int distance;
    //private int delay = 1000;
    private boolean paused = false;

    //constructor (not sure if needed. based on gui implementation)
    public Track() {
    }
    

    public    getStops() {
        // return a set of valid stops based on a starting position
    }

    public void setCars(int numbOfCars) {
        Random r = new Random(System.currentTimeMillis());
        int index;
        
        while(numbOfCars > 0){
            //randomised starting positon 1 - 4
            index = (r.nextInt(4)+1);
            //random set of valid stops based on starting position
            //instasiate new car with valid stops
            //
            
        }
    }
    
//    public void setDelay(int delay) {
//        this.delay = delay;
//    }
//    
//    public int getDelay() {
//        return delay;
//    }
    
    public boolean getPaused(){
        //Have a return for if pause is active or not 
        // true if paused
        // false otherwise
        return paused;
        
    }
    public boolean pause(){
        paused = true;
        return paused;
    }
    
    public void play(){
        paused = false;
        //loops infinitely based on pause status
        while(getPaused() == false){
            updatePosition();
            if(getPaused()){
                break;
            }
        }
    }
    public void updatePosition() {
        // update new position of all cars by one step
        
    }
    
    
}