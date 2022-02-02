package tictactoe;

public class Line {
    private final Cell[] cells;

    public Line(Cell[] cells) {
        this.cells = cells;
    }

    public int countEquals(String mark) {
        int count = 0;
        for (Cell cell : cells) {
            if (cell.getMark().equals(mark)) {
                count++;
            }
        }
        return count;
    }

    public Cell getFirstFreeCell() {
        for (Cell cell : cells) {
            if (cell.getMark().equals(Mark.FREE)) {
                return cell;
            }
        }
        return null;
    }

    public boolean hasFreeCell() {
        for (Cell cell : cells) {
            if (cell.getMark().equals(Mark.FREE)) {
                return true;
            }
        }
        return false;
    }
}
