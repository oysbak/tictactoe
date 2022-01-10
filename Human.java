package tictactoe;

import java.util.Scanner;

public class Human extends Player {
    private final Scanner scanner;
    String[] coordinate;
    private String input;

    public Human(String mark) {
        super(mark);
        scanner = new Scanner(System.in);
    }

    @Override
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

    @Override
    public String[] getCoordinate() {
        return coordinate;
    }
}
