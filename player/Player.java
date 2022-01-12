package tictactoe.player;

import tictactoe.GameBoard;
import tictactoe.Shot;

public abstract class Player {
    public final String mark;
    public final GameBoard gameBoard;
    protected Shot shot;

    public Player(GameBoard gameBoard, String mark) {
        this.mark = mark;
        this.gameBoard = gameBoard;
    }

    public abstract void requestShot();

    public Shot getShot() {
        return shot;
    }
}