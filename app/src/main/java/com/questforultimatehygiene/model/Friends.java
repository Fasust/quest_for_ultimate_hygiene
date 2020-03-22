package com.questforultimatehygiene.model;

public class Friends {
    private String name;
    private String title;
    private int score;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }

    public Friends(String name, String title, int score) {
        this.name = name;
        this.title = title;
        this.score = score;
    }
}
