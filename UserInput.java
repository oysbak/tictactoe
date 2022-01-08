package tictactoe;

import java.util.Scanner;

public class UserInput {
    String[] cells;
    String[] coordinate;
    private Scanner scanner;
    private String input;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public void collectInput(String prompt) {
        boolean doContinue = true;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (prompt.contains("cells")) {
                cells = input.replace("_", " ").split("");
            } else {
                coordinate = input.split(" ");
            }
            doContinue = true;
        } while (!doContinue);
    }

    public String[] getCells() {
        return cells;
    }

    public String[] getCoordinate() {
        return coordinate;
    }
}
