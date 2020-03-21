package com.questforultimatehygiene.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Subclass of Quest
 * Extends the Quest class with a Timer that calls a function after X seconds
 */
public class TimedQuest extends Quest {

    private int reminderTime; // in seconds
    private TimerTask reminderTask;
    private TimerTask activityTask;
    private boolean stopReminder = false;
    private Timer timer;

    public TimedQuest(String name, String description, int experience, int reminderTime) {
        super(name, description, experience);
        this.reminderTime = reminderTime;

        timer = new Timer();
    }

    public TimedQuest(String name, String description, int experience, String mediaPath, int reminderTime) {
        super(name, description, experience, mediaPath);
        this.reminderTime = reminderTime;

        timer = new Timer();
    }

    /**
     * Depricated
     */
    public void startReminder(final TimerTask task){
        final long delay = reminderTime * 1000;

        reminderTask = new TimerTask() {
            @Override
            public void run() {
                //if(!stopReminder)
                    //startActivity(task, true);
            }
        };

        // Task is called once immediately and then every X seconds
        if(reminderTime > 0)
            timer.schedule(reminderTask, delay);
    }

    /**
     * Call this method to start the task immediately and then every "reminderTime" seconds
     * @param initialTask = method with run() component that can be executed
     * @param taskAfter = method with run() component that can be executed
     */
    public void startActivity(TimerTask initialTask, TimerTask taskAfter){
        long delay = reminderTime * 1000; // Delay milliseconds
        timer.schedule(initialTask, 0);

        if(reminderTime > 0){
            stopReminder = false;
            timer.schedule(taskAfter, delay);
        }
    }

    public void StopReminder() {
        stopReminder = true;
    }

}
