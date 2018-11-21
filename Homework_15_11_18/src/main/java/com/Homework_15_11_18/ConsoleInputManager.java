package com.Homework_15_11_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.Homework_15_11_18.App.logger;

public class ConsoleInputManager {
    public static int getKeyFromConsole(BufferedReader bufferedReader){
        System.out.println("Enter ID value:");
        String input = null;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        int result;
        result = Integer.parseInt(input);
        return result;
    }

    public static String getStringKeyFromConsole(BufferedReader bufferedReader ){
        System.out.println("Enter ID value:");
        String input = null;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return input;
    }
}
