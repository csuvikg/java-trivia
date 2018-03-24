
package com.adaptionsoft.games.trivia.runner;
import java.io.IOException;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	public static void main(String[] args) throws IOException {
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		Random rand = new Random();

		int[] rolls = {1};
//		int firstRoll = rand.nextInt(6) + 1;
//		int secondRoll = rand.nextInt(9);

		aGame.play(rolls);



	}
}
