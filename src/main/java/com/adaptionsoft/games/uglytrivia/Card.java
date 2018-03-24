package com.adaptionsoft.games.uglytrivia;

public class Card {
    private int index;
    private QuestionType questionType;

    public Card(int index, QuestionType questionType) {
        this.index = index;
        this.questionType = questionType;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    @Override
    public String toString() {
        return questionType + " Question " + index;
    }
}
