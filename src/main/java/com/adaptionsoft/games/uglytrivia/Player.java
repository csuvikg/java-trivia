package com.adaptionsoft.games.uglytrivia;

public class Player {
    private String name;
    private int points;
    private int currentField;
    private boolean isInPenalty;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.currentField = 0;
        this.isInPenalty = false;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCurrentField() {
        return currentField;
    }

    public void setCurrentField(int currentField) {
        this.currentField = currentField;
    }

    public boolean isInPenalty() {
        return isInPenalty;
    }

    public void setInPenalty(boolean inPenalty) {
        isInPenalty = inPenalty;
    }
}
