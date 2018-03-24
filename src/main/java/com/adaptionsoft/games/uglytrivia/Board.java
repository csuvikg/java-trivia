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

        for (int i = 0; i < boardSize; i+= numberOfQuestionTypes) {
            for (int j = 0; j < numberOfQuestionTypes || j < boardSize; j++) {
                fields.put(i + j, new Field(i + j, QuestionType.values()[j]));
            }
        }
    }
}
