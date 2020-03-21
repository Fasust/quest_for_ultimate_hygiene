package com.questforultimatehygiene.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Subclass of Quest
 * Extends the Quest class with a Timer that is called after X seconds
 */
public class TimedQuest extends Quest {

    private int time; // in seconds
    private Timer timer;

    public TimedQuest(String name, String description, int experience, int time) {
        super(name, description, experience);
        this.time = time;
        timer = new Timer();
    }

    public TimedQuest(String name, String description, int experience, int time, String mediaPath) {
        super(name, description, experience, mediaPath);
        this.time = time;
        timer = new Timer();
    }

    /**
     * Method that calls the run() function provided in the TimeTask after X seconds
     * The seconds are stored in the "time" class parameter
     * @param task with run() function that is called after X seconds
     */
    public void startTimer(TimerTask task){
        long delay = time * 1000; // time in seconds, delay in milliseconds
        timer.schedule(task, delay);
    }

    /**
     * @param time in seconds
     */
    public void setTime(int time){
        this.time = time;
    }

    /**
     * @return time in seconds
     */
    public int getTime() {
        return time;
    }
}
