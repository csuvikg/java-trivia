package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SomeTest {

	@Test
	public void true_is_true() {
		assertTrue(true);
	}

	@Test
	public void testGame() throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("testdata/testoutput"));
        System.setOut(out);

        BufferedReader reader = new BufferedReader(new FileReader("testdata/input"));

        for (int i = 0; i < 100; i++) {
            Game aGame = new Game();

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            int[] rolls = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            aGame.play(rolls);
        }

        out.close();

        String expected = FileUtils.readFileToString(new File("testdata/output"), "utf-8");
        String actual = FileUtils.readFileToString(new File("testdata/testoutput"), "utf-8");

        assertEquals(expected, actual);
	}
}
