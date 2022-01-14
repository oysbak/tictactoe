package tictactoe;

public class Cell {
    private String row;
    private String column;
    private int index;
    private String mark;

    public Cell(String row, String column, String mark) {
        this.row = row;
        this.column = column;
        this.mark = mark;
        this.index = GameBoard.getIndex(new String[]{row, column});
    }

    public Cell(int index, String mark) {
        this.index = index;
        this.mark = mark;
        String[] coordinate = GameBoard.getCoordinate(index);
        row = coordinate[0];
        column = coordinate[1];
    }

    public Cell(int index) {
        this(index, GameBoard.FREE);
    }

    public String getMark() {
        return mark;
    }

    public String[] getCoordinate() {
        return new String[]{row, column};
    }
}
