package cargame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Track {

    private ArrayList<Stop> locations;
    private ArrayList<Car> cars;
    private int distance;
    private int delay = 1000;

    //constructor (not sure if needed. based on gui implementation)
    public Track() {
    }
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            updatePosition();
        }
    };

    // I figured that findDistance was supposed to be with the track class not car class
    public int findDistance() {
//        distance = Math.sqrt(Math.abs(lastStop.getX() - nextStop.getX()) ^ 2
//                + Math.abs(lastStop.getY() - nextStop.getY()) ^ 2);
        return distance;
    }

    public void setStops() {
    }

    public void setCars() {
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    public int getDelay() {
        return delay;
    }
    
    public void updatePosition() {
        //update logic here
    }
}