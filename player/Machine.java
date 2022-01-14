package tictactoe.player;

import tictactoe.GameBoard;
import tictactoe.Line;
import tictactoe.Shot;

import java.util.Random;

public class Machine extends Player {
    private final String skill;

    public Machine(GameBoard gameBoard, String skill, String mark) {
        super(gameBoard, mark);
        this.skill = skill;
    }

    @Override
    public void requestShot() {
        System.out.println("Making move level \"" + skill + "\"");
        String[] coordinate;
        boolean isOccupied;
        do {
            coordinate = getRandomCoordinate();
            isOccupied = gameBoard.isOccupiedCell(coordinate);
        } while (isOccupied);
        shot = new Shot(coordinate, mark);
    }

    private String[] getRandomCoordinate() {
        Random random = new Random();
        int row;
        int column;
        switch (skill) {
            case "easy":
                row = random.nextInt(3) + 1;
                column = random.nextInt(3) + 1;
                break;
            case "medium":
                return getBestCoordinate();
            default:
                row = 0;
                column = 0;
        }
        return new String[]{String.valueOf(row), String.valueOf(column)};
    }

    private String[] getBestCoordinate() {
        // Can I win?
        for (Line line : gameBoard.getLines()) {
            if (line.countEquals(this.mark) == 2 && line.hasFreeCell()) {
                return line.getFirstFreeCell().getCoordinate();
            }
        }
        // Prevent opponent?
        String opponentMark = mark.equals("X") ? "O" : "X";
        for (Line line : gameBoard.getLines()) {
            if (line.countEquals(opponentMark) == 2 && line.hasFreeCell()) {
                return line.getFirstFreeCell().getCoordinate();
            }
        }
        // Standard random placement
        Random random = new Random();
        int row = random.nextInt(3) + 1;
        int column = random.nextInt(3) + 1;
        return new String[]{String.valueOf(row), String.valueOf(column)};
    }
}
