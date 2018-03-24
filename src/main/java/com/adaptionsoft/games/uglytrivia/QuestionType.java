package com.adaptionsoft.games.uglytrivia;

public enum QuestionType {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private String title;

    QuestionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
