package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;

import java.io.*;
import java.util.Random;

public class TestUtils {

    public static void main(String[] args) throws IOException {
        File file = new File("testdata/randominput");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream out = new PrintStream(new FileOutputStream("testdata/randomoutput"));
        System.setOut(out);

        for (int i = 0; i < 100; i++) {
            Game aGame = new Game();

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            Random rand = new Random();

            boolean notAWinner;
            do {
                int firstRoll = rand.nextInt(6) + 1;
                writer.append(Integer.toString(firstRoll));
                aGame.roll(firstRoll);

                int secondRoll = rand.nextInt(9);
                writer.append(Integer.toString(secondRoll));

                if (secondRoll == 7) {
                    notAWinner = aGame.wrongAnswer();
                } else {
                    notAWinner = aGame.wasCorrectlyAnswered();
                }
            } while (notAWinner);

            writer.append("\n");
        }

        writer.close();
        out.close();
    }
}
