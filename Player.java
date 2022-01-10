package tictactoe;

public abstract class Player {
    protected String mark;

    Player(){}

    public Player(String mark) {
        this.mark = mark;
    }

    public abstract void collectInput(String prompt, GameBoard gameBoard);

    public abstract String[] getCoordinate();
}