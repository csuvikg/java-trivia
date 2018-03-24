package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<String> logList = new ArrayList<>();

    public static void log(String text) {
        logList.add(text);

        System.out.println(text);
    }

    public static boolean contains(String text) {
        return logList.contains(text);
    }
}
