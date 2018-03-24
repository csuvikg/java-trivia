package com.adaptionsoft.games.uglytrivia;

import java.io.*;
import java.util.*;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;


    private List<Player> playerss;
    private Deck deck;
    private Board board;

    public  Game(){
        this.deck = new Deck(50);
        this.board = new Board();
        this.playerss = new ArrayList();
    }

    public void play(int[] rolls) throws IOException {
        isPlayable();

        Iterator<Integer> rollIterator = Arrays.stream(rolls).iterator();

        boolean notAWinner;
        do {
			int firstRoll = rollIterator.next();
            roll(firstRoll);

            int secondRoll = rollIterator.next();

            if (secondRoll == 7) {
                notAWinner = wrongAnswer();
            } else {
                notAWinner = wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }


	public String createQuestion(QuestionType type, int index){
		return type.getTitle() + " Question " + index;
	}

	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {


	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

	    Printer.print(playerName + " was added");
	    Printer.print("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		Printer.print(players.get(currentPlayer) + " is the current player");
		Printer.print("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				Printer.print(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

				Printer.print(players.get(currentPlayer)
						+ "'s new location is "
						+ places[currentPlayer]);
				Printer.print("The category is " + currentCategory());
				askQuestion();
			} else {
				Printer.print(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

			Printer.print(players.get(currentPlayer)
					+ "'s new location is "
					+ places[currentPlayer]);
			Printer.print("The category is " + currentCategory());
			askQuestion();
		}

	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			Printer.print(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			Printer.print(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			Printer.print(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			Printer.print(rockQuestions.removeFirst());
	}


	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if (places[currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				Printer.print("Answer was correct!!!!");
				purses[currentPlayer]++;
				Printer.print(players.get(currentPlayer)
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");

				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;

				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}



		} else {

			Printer.print("Answer was corrent!!!!");
			purses[currentPlayer]++;
			Printer.print(players.get(currentPlayer)
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");

			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;

			return winner;
		}
	}

	public boolean wrongAnswer(){
		Printer.print("Question was incorrectly answered");
		Printer.print(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
