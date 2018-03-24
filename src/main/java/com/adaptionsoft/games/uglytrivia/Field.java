package com.adaptionsoft.games.uglytrivia;

public class Field {
    private int number;
    private QuestionType questionType;

    public Field(int number, QuestionType questionType) {
        this.number = number;
        this.questionType = questionType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
