package com.copicraftDev;

import java.util.Scanner;

public class Main {
    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) throws InterruptedException {
        printBanner();

        Scanner scanner = new Scanner(System.in);

        System.out.println(CYAN + "Welcome to " + GREEN + "TypeForge" + CYAN + "!" + RESET);
        System.out.println(CYAN + "Your typing skills are about to be forged..." + RESET);

        System.out.print(YELLOW + "\nPress Enter when you are ready to start the forging..." + RESET);
        scanner.nextLine(); // wait for Enter

        // Show "The Forger" epic intro
        printForgerAnimation();

        // Call the live epic typing TUI
        EpicTypeForgeTUI.startTypingTest(scanner);
    }

    static void printBanner() {
        String[] banner = {
                " _______ _                 ______                  _             ",
                "|__   __| |               |  ____|                | |            ",
                "   | |  | |__   ___       | |__ ___  _ __ ___  ___| |_ ___  _ __ ",
                "   | |  | '_ \\ / _ \\      |  __/ _ \\| '__/ _ \\/ __| __/ _ \\| '__|",
                "   | |  | | | |  __/      | | | (_) | | |  __/ (__| || (_) | |   ",
                "   |_|  |_| |_|\\___|      |_|  \\___/|_|  \\___|\\___|\\__\\___/|_|   ",
                "                                                                   "
        };

        for (String line : banner) {
            System.out.println(CYAN + line + RESET);
        }
        System.out.println();
    }

    static void printForgerAnimation() throws InterruptedException {
        String[] forgerFrames = {
                "   .      .      .",
                "    \\    |    /",
                "     .  .^.  .",
                "      \\ | | /",
                "       `---`",
                "Forging your typing..."
        };

        for (String frame : forgerFrames) {
            System.out.println(GREEN + frame + RESET);
            Thread.sleep(400);
        }

        System.out.println("\n" + CYAN + "=== TypeForge Typing Challenge Incoming ===\n" + RESET);
    }
}
