package cargame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

public class Track {

    private ArrayList<Stop> locations;
    private ArrayList<Car> cars;
    private int distance;
    private int delay = 1000;
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            updatePosition();
        }
    };

    //constructor (not sure if needed. based on gui implementation)
    public Track() {
        cars.add();
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
         new Timer(delay, taskPerformer).start();
    }
}