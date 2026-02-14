package com.copicraftDev;

import java.util.Scanner;

public class EpicTypeForgeTUI {

    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";

    public static void startTypingTest(Scanner scanner) {
        // Default typing test text (pangram)
        String textToType = "the quick brown fox jumps over the lazy dog";

        // Print the text in a box
        int length = textToType.length();
        System.out.println(CYAN + "╔" + "═".repeat(length + 2) + "╗" + RESET);
        System.out.println(CYAN + "║ " + textToType + " ║" + RESET);
        System.out.println(CYAN + "╚" + "═".repeat(length + 2) + "╝" + RESET);

        System.out.println(CYAN + "\nType the text above and press Enter when done..." + RESET);

        long startTime = System.currentTimeMillis();
        String userInput = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        int correctChars = 0;
        int minLength = Math.min(userInput.length(), textToType.length());
        StringBuilder coloredOutput = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (userInput.charAt(i) == textToType.charAt(i)) {
                coloredOutput.append(GREEN).append(userInput.charAt(i)).append(RESET);
                correctChars++;
            } else {
                coloredOutput.append(RED).append(userInput.charAt(i)).append(RESET);
            }
        }

        // Add extra incorrect chars if user typed too much
        for (int i = minLength; i < userInput.length(); i++) {
            coloredOutput.append(RED).append(userInput.charAt(i)).append(RESET);
        }

        // Show colored result
        System.out.println("\n" + CYAN + "=== Your Result ===" + RESET);
        System.out.println(coloredOutput);

        // Stats
        double elapsedMinutes = (endTime - startTime) / 60000.0;
        int wpm = (int)((correctChars / 5.0) / elapsedMinutes);
        double accuracy = ((double) correctChars / textToType.length()) * 100;

        System.out.println(YELLOW + "WPM: " + wpm + " | Accuracy: " + String.format("%.1f", accuracy) + "%" + RESET);
        System.out.println("Time: " + String.format("%.2f", (endTime - startTime)/1000.0) + "s");
    }
}
