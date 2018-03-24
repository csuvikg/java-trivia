package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;

public class Board {
    private HashMap<Integer, Field> fields;

    public Board(int boardSize) {
        this.fields = new HashMap<>();
        addFields(boardSize);

    }

    private void addFields(int boardSize) {

        int numberOfQuestionTypes = QuestionType.values().length;

        for (int i = 0; i < boardSize; i += numberOfQuestionTypes) {
            for (int j = 0; i + j < boardSize && j < numberOfQuestionTypes; j++) {
                fields.put(i + j, new Field(i + j, QuestionType.values()[j]));
            }
        }
    }

    public Field getField(int index) {
        Field nextField;

        if (index < this.fields.size()) nextField = this.fields.get(index);
        else nextField = this.fields.get(index - this.fields.size());

        return nextField;
    }
}
