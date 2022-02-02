package tictactoe;

public class Cell {
    private final String row;
    private final String column;
    private final String mark;

    public Cell(int index, String mark) {
        this.mark = mark;
        String[] coordinate = GameBoard.getCoordinate(index);
        row = coordinate[0];
        column = coordinate[1];
    }

    public String getMark() {
        return mark;
    }

    public String[] getCoordinate() {
        return new String[]{row, column};
    }
}
