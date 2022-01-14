package tictactoe;

public enum Mark {
    X("X"), O("O"), FREE(GameBoard.FREE);

    private final String displayAs;

    Mark(String displayAs) {
        this.displayAs = displayAs;
    }

    @Override
    public String toString() {
        return String.valueOf(displayAs);
    }
}
