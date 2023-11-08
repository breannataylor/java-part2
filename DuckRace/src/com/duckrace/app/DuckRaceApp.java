package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    /*
     * Application Controller: Directs the overall flow/sequence of the application, and does all user prompting.
     */
    private final Board board = new Board();
    //the ONLY way to use Scanners when dealing with humans
    private final Scanner scanner = new Scanner(System.in);

    //direct the overall flow of the application.
    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                //be like Marshall
                reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;

            }
        }

        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-19]: ");
            //nextLine will pause until the user presses enter
            //.trim() removes any whitespace before or after what was put in nextLine
            String input = scanner.nextLine().trim();
            //now we must turn the String input into an integer, and have an exception for
            //when they do not input the correct thing.
            //any digit, one to two times
            if (input.matches("\\d{1,2}")) {
                id = Integer.parseInt(input);
                if (1 <= id && id <= 19) {
                    validInput = true; //TODO: don't hardcode the 19.
                }
            }
            else {

            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("");
        System.out.println("Welcome to the DuckRace! - and thank you for playing!");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⣀⣀⣀⠀⠀⠀⢼⣆⢀⡀⠀⣠⠀⠀⢀⣴⡄⠀⠀⢀⣹⣯⣋⠀⠘⣷⢀⠀⠀⠀⠀⠀⠀⠀⢀⡄⠀⠀⣀⣀⡀⠀⢰⣶⠀⠀\n" +
                "⠛⠉⣩⣷⠄⠀⢸⣿⠛⠁⢠⣿⠀⠀⠀⣿⣧⣤⡄⠉⣥⢯⣍⠉⢈⣿⠛⠃⢸⣷⠀⠀⠀⠀⣾⡏⠀⢻⡏⠙⠁⠀⢹⣷⣤⡄\n" +
                "⠀⢰⡿⠂⠀⠀⠈⠛⠀⢰⠾⠛⠻⠖⠀⣿⡗⠀⠀⠀⠛⠾⢏⠀⠐⣛⠁⠀⠈⠻⢦⠶⠾⠀⢸⡇⠀⢿⣤⣤⡄⠀⢼⡿⠀⠀\n" +
                "⠀⠀⠁⢈⣷⠞⣶⡄⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠐⣿⡤⡦⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀\n" +
                "⠀⠀⠀⠀⠿⢦⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⣤⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢀⡀⠀⠀⠀⣠⡾⠋⠉⠉⠉⠉⠻⢿⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣰⡾⠟⠛⠛⠛⠳⣶⣾⡟⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⡆⠀⠀⠀⠀⠀⠀⠀⣰⡾⠟⣶⣆⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠠⣼⡋⠁⠀⠀⠀⠀⠀⠈⠙⢷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠘⢷⡆⠀⠀⠀⠀⠀⢰⡿⡑⠆⡜⣿⠿⠻⢷⣦⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢻⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀⠀⠀⠀⢹⣧⠄⠀⠀⠀⠀⢸⣗⢹⠰⡐⢠⢢⢕⣺⣿⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⣟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡦⠀⠀⠀⠀⠀⠀⠀⠘⣏⣀⠀⠀⠀⠀⠀⢿⣆⣧⣌⣦⣶⡾⠏⠁⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠽⣅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⠷⣦⡀⠀⠈⠁⠉⠁⠉⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠙⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣷⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢰⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣷⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢿⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠰⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣟⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢈⣿⣦⡀⠀⠀⠀⠀⡀⠘⠻⠴⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠓⠒⢲⡀⢀⣼⠏⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⣠⣤⣾⠏⠉⠹⠷⢦⣤⣀⡑⠀⢀⠔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⠀⡀⠀⣡⡾⠟⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣼⠛⣿⡃⠀⠀⠀⠀⠀⠀⠉⠙⠓⠛⠶⠶⢶⢶⣲⠶⡶⠶⣦⡶⢶⢦⣶⠶⠖⠚⠋⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠻⢷⣿⡅⠀⠀⠀⠀⢀⣄⠀⠀⠀⠈⠛⢦⡀⠀⢀⣴⠶⠃⠀⠀⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠙⣿⣄⠀⠀⠀⠀⠙⠚⠶⢦⡤⣦⠾⠃⠀⠘⠿⡤⣤⣤⣶⡟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣖⡄⠀⠀⠀⠀⠀⠀⢀⣀⢀⡀⣀⣀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⣖⣤⣀⣀⣼⠟⠉⠉⠉⠉⠉⠛⠻⠶⠖⠛⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠈⣉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }
}