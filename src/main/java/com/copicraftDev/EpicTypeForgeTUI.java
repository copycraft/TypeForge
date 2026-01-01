package com.copicraftDev;

import java.util.Scanner;

public class EpicTypeForgeTUI {

    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";
    static final String MAGENTA = "\u001B[35m";

    public static void startTypingTest(Scanner scanner) {
        String textToType = "TypeForge is forging your typing skills into epic perfection!";
        int totalChars = textToType.length();
        int correctChars = 0;
        char[] typedChars = new char[totalChars];
        long startTime = System.currentTimeMillis();

        // Print epic box for text
        System.out.println(CYAN + "╔" + "═".repeat(totalChars + 2) + "╗" + RESET);
        System.out.print("║ ");
        for (int i = 0; i < totalChars; i++) System.out.print("_");
        System.out.println(" ║");
        System.out.println("╚" + "═".repeat(totalChars + 2) + "╝" + RESET);

        System.out.println(CYAN + "\nType the text above! Press space/Enter for each character...\n" + RESET);

        for (int i = 0; i < totalChars; i++) {
            char expected = textToType.charAt(i);
            String input = scanner.next();
            char typed = input.charAt(0);
            typedChars[i] = typed;

            if (typed == expected) correctChars++;

            // redraw live
            System.out.print("\r"); // return to start
            System.out.print(CYAN + "║ " + RESET);
            for (int j = 0; j < totalChars; j++) {
                if (typedChars[j] == 0) System.out.print("_");
                else if (typedChars[j] == textToType.charAt(j)) System.out.print(GREEN + typedChars[j] + RESET);
                else System.out.print(RED + typedChars[j] + RESET);
            }
            System.out.print(CYAN + " ║" + RESET);

            // Stats
            long elapsed = System.currentTimeMillis() - startTime;
            double minutes = elapsed / 60000.0;
            int wpm = (int)((correctChars / 5.0) / minutes);
            double accuracy = ((double)correctChars / (i + 1)) * 100;

            System.out.print("  " + YELLOW + "[WPM: " + wpm + " | Accuracy: " + String.format("%.1f", accuracy) + "%]" + RESET);
        }

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("\n\n" + CYAN + "=== Test Complete ===" + RESET);
        System.out.println("Time: " + String.format("%.2f", totalTime / 1000.0) + "s");
        System.out.println("WPM: " + (int)((correctChars / 5.0) / (totalTime / 60000.0)));
        System.out.println("Accuracy: " + ((double)correctChars / totalChars) * 100 + "%");
    }
}
