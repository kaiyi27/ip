package com.example.artemis;

import java.util.Scanner;

/**
 * Artemis is a simple task management application.
 * It allows users to add, list, mark as done, and delete tasks.
 */
public class Artemis {
    // File path for storing tasks data
    private static final String FILE_PATH = "./data/artemis.txt";

    // Components of Artemis
    private static final Storage STORAGE = new Storage(FILE_PATH);
    private static final Ui UI = new Ui();
    private TaskList tasks;


    /**
     * Constructor for Artemis class.
     */
    public Artemis() {
        try {
            tasks = new TaskList(STORAGE.load());
        } catch (ArtemisException e) {
            UI.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the Artemis application, handling user input and performing tasks.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);

        UI.showWelcomeMessage();

        while (true) {
            String input = sc.nextLine();
            try {
                // Parse user input and perform corresponding actions
                Parser.parseInput(input, tasks, UI, STORAGE);
            } catch (ArtemisException e) {
                UI.showError("Oops, there might be invalid input..");
            }
            // Check if the user entered "bye" to exit the application
            if (input.contains("bye")) {
                break;
            }
        }
        sc.close();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            // Parse user input and perform corresponding actions
            return Parser.parseInput(input, tasks, UI, STORAGE);
        } catch (ArtemisException e) {
            return UI.showError("Oops, there might be invalid input..");
        }
    }

    /**
     * Main method to start the Artemis application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new Artemis().run();
    }
}
