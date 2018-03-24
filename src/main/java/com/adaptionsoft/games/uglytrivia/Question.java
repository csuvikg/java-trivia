package com.adaptionsoft.games.uglytrivia;

public class Question {

    private QuestionType type;

    public Question(QuestionType type) {
        this.type = type;
    }

    public QuestionType getType() {
        return type;
    }
}
