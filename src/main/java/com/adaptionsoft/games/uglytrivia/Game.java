package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class Game {
    private int currentPlayerIndex = 0;
    private boolean isGameWon = false;
    private List<Player> players;
    private Deck deck;
    private Board board;

    public Game() {
        this.deck = new Deck(50);
        this.board = new Board(12);
        this.players = new ArrayList();
    }

    public void play(int[] rolls) {
        if (!isPlayable()) {
            Logger.log("Not enough players to play the game!");

            return;
        }

        Iterator<Integer> rollIterator = Arrays.stream(rolls).iterator();

        while(!isGameWon) {
            int firstRoll = rollIterator.next();
            roll(firstRoll);

            int secondRoll = rollIterator.next();
            if (secondRoll == 7) {
                wrongAnswer();
            } else {
                wasCorrectlyAnswered();
            }

            currentPlayerIndex++;
            if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
        };
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));

        Logger.log(playerName + " was added");
        Logger.log("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        Player currentPlayer = players.get(currentPlayerIndex);

        Logger.log(currentPlayer.getName() + " is the current player");
        Logger.log("They have rolled a " + roll);

        if (currentPlayer.isInPenalty()) {
            if (roll % 2 != 0) {
                currentPlayer.setInPenalty(false);

                Logger.log(currentPlayer.getName() + " is getting out of the penalty box");
            } else {
                Logger.log(players.get(currentPlayerIndex) + " is not getting out of the penalty box");
            }
        }

        if (!currentPlayer.isInPenalty()) {
            Field nextField = board.getField(currentPlayer.getCurrentField() + roll);
            currentPlayer.setCurrentField(nextField.getNumber());

            Logger.log(currentPlayer.getName()
                    + "'s new location is "
                    + currentPlayer.getCurrentField());
            Logger.log("The category is " + nextField.getQuestionType());

            askQuestion(nextField.getQuestionType());
        }

    }

    private void askQuestion(QuestionType questionType) {
        Card question = this.deck.getCardByType(questionType);

        Logger.log(question.getQuestionType().getTitle());
    }

    public void wasCorrectlyAnswered() {
        Player currentPlayer = players.get(currentPlayerIndex);

        if (!currentPlayer.isInPenalty()) {
            Logger.log("Answer was corrent!!!!");
            currentPlayer.setPoints(currentPlayer.getPoints() + 1);
            Logger.log(players.get(currentPlayerIndex)
                    + " now has "
                    + currentPlayer.getPoints()
                    + " Gold Coins.");

            if(currentPlayer.getPoints() == 6) {
                this.isGameWon = true;
            }
        }
    }

    public void wrongAnswer() {
        Player currentPlayer = players.get(currentPlayerIndex);

        Logger.log("Question was incorrectly answered");
        currentPlayer.setInPenalty(true);
        Logger.log(currentPlayer.getName() + " was sent to the penalty box");
    }
}
