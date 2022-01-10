package tictactoe;

import java.util.Scanner;

public class UserInput {
    String[] cells;
    String[] coordinate;
    private final Scanner scanner;
    private String input;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public void collectSetup(String prompt) {
        System.out.print(prompt);
        input = scanner.nextLine();
        cells = input.replace("_", " ").split("");
    }

    public void collectInput(String prompt, GameBoard gameBoard) {
        boolean doContinue;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            coordinate = input.split(" ");
            String feedback = gameBoard.isValidPlacement(coordinate);
            doContinue = feedback.length() == 0;
            if (!doContinue) {
                System.out.println(feedback);
            }
        } while (!doContinue);
    }

    public String[] getCells() {
        return cells;
    }

    public String[] getCoordinate() {
        return coordinate;
    }
}
