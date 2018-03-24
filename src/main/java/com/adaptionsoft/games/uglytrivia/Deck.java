package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private List<Card> cardList;

    public Deck(int numberOfCardsByCategory) {
        this.cardList = new ArrayList<>();
        createCards(numberOfCardsByCategory);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card getCardByType(QuestionType questionType) {

        Card cardToReturn = cardList.stream().filter(card -> card.getQuestionType() == questionType).findFirst().get();

        cardList.remove(cardToReturn);

        return cardToReturn;
    }

    private void createCards(int numberOfCardsByCategory) {

        Arrays.stream(QuestionType.values()).forEach(type -> {
            for (int i = 0; i < numberOfCardsByCategory; i++) {
                cardList.add(new Card(i, type));
            }
        });
    }
}
