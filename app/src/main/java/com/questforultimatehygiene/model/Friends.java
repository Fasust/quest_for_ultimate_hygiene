package com.questforultimatehygiene.model;

public class Friends {
    private String name;
    private String title;
    private int score;
    private int avatar;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }

    public int getAvatar() {
        return avatar;
    }

    public Friends(String name, String title, int score, int avatar) {
        this.name = name;
        this.title = title;
        this.score = score;
        this.avatar = avatar;
    }
}
