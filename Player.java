package tictactoe;

public abstract class Player {
    public final String mark;
    public final GameBoard gameBoard;
    protected Shot shot;

    public Player(GameBoard gameBoard, String mark) {
        this.mark = mark;
        this.gameBoard = gameBoard;
    }

    public abstract void requestShot(String prompt);

    public Shot getShot() {
        return shot;
    }
}