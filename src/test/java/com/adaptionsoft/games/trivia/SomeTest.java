package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;

public class SomeTest {

	@Test
	public void true_is_true() {
		assertTrue(true);
	}

	@Test
	public void testGame() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("testdata/testoutput"));
        System.setOut(out);

		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

        BufferedReader reader = new BufferedReader(new FileReader("testdata/input"));

        boolean notAWinner;
        do {
			int firstRoll = Integer.parseInt(reader.readLine());
			aGame.roll(firstRoll);

			int secondRoll = Integer.parseInt(reader.readLine());

			if (secondRoll == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
		} while (notAWinner);

        String expected = FileUtils.readFileToString(new File("testdata/output"), "utf-8");
        String actual = FileUtils.readFileToString(new File("testdata/testoutput"), "utf-8");
        assertEquals(expected, actual);
	}
}
