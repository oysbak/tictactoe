package tictactoe;

import java.util.Locale;

public class GameBoard {
    public static final String FREE = " ";
    String[] cells;
    int[][] lines;

    public GameBoard() {
        cells = new String[]{FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE};
        lines = new int[][]{
                {0, 1, 2}, {0, 3, 6}, {0, 4, 8},
                {1, 4, 7}, {2, 4, 6}, {2, 5, 8},
                {3, 4, 5}, {6, 7, 8}
        };
    }

    public static int getIndex(String[] coordinate) {
        int row = Integer.parseInt(coordinate[0]);
        int column = Integer.parseInt(coordinate[1]);
        return 3 * (row - 1) + (column - 1);
    }

    public static String[] getCoordinate(int index) {
        String row;
        String column;
        switch (index) {
            case 0:
                row = "1";
                column = "1";
                break;
            case 1:
                row = "1";
                column = "2";
                break;
            case 2:
                row = "1";
                column = "3";
                break;
            case 3:
                row = "2";
                column = "1";
                break;
            case 4:
                row = "2";
                column = "2";
                break;
            case 5:
                row = "2";
                column = "3";
                break;
            case 6:
                row = "3";
                column = "1";
                break;
            case 7:
                row = "3";
                column = "2";
                break;
            case 8:
                row = "3";
                column = "3";
                break;
            default:
                row = "0";
                column = "0";
        }
        return new String[]{row, column};
    }

    private static boolean isValidIndex(String[] coordinate) {
        return "123".contains(coordinate[0]) && "123".contains(coordinate[1]);
    }

    public void draw() {
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public void placeShot(Shot shot) {
        cells[getIndex(shot.coordinate)] = shot.mark;
    }

    public boolean isValidCell(String[] coordinate) {
        return isValidIndex(coordinate);
    }

    public boolean isOccupiedCell(String[] coordinate) {
        int index = getIndex(coordinate);
        return !cells[index].equals(GameBoard.FREE);
    }

    public boolean isConcluded() {
        return getWinner().length() > 0 || isDraw();
    }

    private boolean areAllEqual(int i, int j, int k) {
        return cells[i].equals(cells[j]) && cells[i].equals(cells[k]);
    }

    private boolean isDraw() {
        for (String cell : cells) {
            if (cell.equals(GameBoard.FREE)) {
                return false;
            }
        }
        return true;
    }

    private String getWinner() {
        for (int[] row : lines) {
            if (areAllEqual(row[0], row[1], row[2]) && !cells[row[0]].equals(GameBoard.FREE)) {
                return cells[row[0]].toUpperCase(Locale.ROOT);
            }
        }
        return "";
    }

    public String getResult() {
        return isDraw() ? "Draw" : getWinner() + " wins";
    }

    public int countMarks(String[] cells, String mark) {
        int count = 0;
        for (String cell : cells) {
            if (cell.equals(mark)) {
                count++;
            }
        }
        return count;
    }

    public Line[] getLines() {
        return new Line[]{
                new Line(new Cell[]{new Cell(0, cells[0]), new Cell(1, cells[1]), new Cell(2, cells[2])}),
                new Line(new Cell[]{new Cell(3, cells[3]), new Cell(4, cells[4]), new Cell(5, cells[5])}),
                new Line(new Cell[]{new Cell(6, cells[6]), new Cell(7, cells[7]), new Cell(8, cells[8])}),
                new Line(new Cell[]{new Cell(0, cells[0]), new Cell(3, cells[3]), new Cell(6, cells[6])}),
                new Line(new Cell[]{new Cell(1, cells[1]), new Cell(4, cells[4]), new Cell(7, cells[7])}),
                new Line(new Cell[]{new Cell(2, cells[2]), new Cell(5, cells[5]), new Cell(8, cells[8])}),
                new Line(new Cell[]{new Cell(0, cells[0]), new Cell(4, cells[4]), new Cell(8, cells[8])}),
                new Line(new Cell[]{new Cell(2, cells[2]), new Cell(4, cells[4]), new Cell(6, cells[6])})
        };
    }
}