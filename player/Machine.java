package tictactoe.player;

import tictactoe.GameBoard;
import tictactoe.Shot;

import java.util.Random;

public class Machine extends Player {

    public Machine(GameBoard gameBoard, String mark) {
        super(gameBoard, mark);
    }

    @Override
    public void requestShot() {
        System.out.println("Making move level \"easy\"");
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
        String row = String.valueOf(random.nextInt(3) + 1);
        String column = String.valueOf(random.nextInt(3) + 1);
        return new String[]{row, column};
    }
}
