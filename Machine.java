package tictactoe;

import java.util.Random;

public class Machine extends Player {
    private String[] coordinate;

    public Machine(String mark) {
        super(mark);
    }

    @Override
    public void collectInput(String prompt, GameBoard gameBoard) {
        boolean isOccupied = false;
        do {
            int index = new Random().nextInt(8);
            coordinate = new String[]{"", ""};
        } while (isOccupied);
    }

    @Override
    public String[] getCoordinate() {
        return this.coordinate;
    }
}
