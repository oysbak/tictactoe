package tictactoe.player;

import tictactoe.GameBoard;
import tictactoe.Shot;

import java.util.Scanner;

public class Human extends Player {
    private final Scanner scanner;

    public Human(GameBoard gameBoard, String mark) {
        super(gameBoard, mark);
        scanner = new Scanner(System.in);
    }

    @Override
    public void requestShot() {
        boolean doContinue;
        do {
            doContinue = true;
            System.out.print("Enter the coordinates: ");
            String[] coordinate = scanner.nextLine().split("\\s+");
            if (!Shot.isValidCoordinate(coordinate)) {
                System.out.println("You should enter numbers!");
                doContinue = false;
            }
            if (doContinue && !gameBoard.isValidCell(coordinate)) {
                System.out.println("Coordinates should be from 1 to 3!");
                doContinue = false;
            }
            if (doContinue && gameBoard.isOccupiedCell(coordinate)) {
                System.out.println("This cell is occupied! Choose another one!");
                doContinue = false;
            }
            shot = new Shot(coordinate, mark);
        } while (!doContinue);
    }
}
