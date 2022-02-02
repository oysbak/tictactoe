package tictactoe.player;

import tictactoe.GameBoard;
import tictactoe.Line;
import tictactoe.MiniMaxAlgorithm;
import tictactoe.Shot;

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
            coordinate = getCoordinate();
            isOccupied = gameBoard.isOccupiedCell(coordinate);
        } while (isOccupied);
        shot = new Shot(coordinate, mark);
    }

    private String[] getCoordinate() {
        int row;
        int column;
        switch (skill) {
            case "easy":
                return GameBoard.getRandomCoordinate();
            case "medium":
                return getBestCoordinate();
            case "hard":
                return getMiniMaxCoordinate();
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
        // Can I prevent opponent?
        String opponentMark = getOpponentsMark();
        for (Line line : gameBoard.getLines()) {
            if (line.countEquals(opponentMark) == 2 && line.hasFreeCell()) {
                return line.getFirstFreeCell().getCoordinate();
            }
        }
        // Standard random placement
        return GameBoard.getRandomCoordinate();
    }

    private String[] getMiniMaxCoordinate() {
        MiniMaxAlgorithm miniMaxAlgorithm = new MiniMaxAlgorithm(getOpponentsMark(), mark, gameBoard.getCells());
        return miniMaxAlgorithm.getCoordinate();
    }

    private String getOpponentsMark() {
        return this.mark.equals("O") ? "X" : "O";
    }
}
