package com.adaptionsoft.games.uglytrivia;

public class Card {
    private QuestionType questionType;

    public Card(QuestionType questionType) {
        this.questionType = questionType;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
