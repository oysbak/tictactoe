package tictactoe;

import java.util.Locale;

public class GameBoard {
    String[] cells;
    int[][] rows = new int[][]{
            {0, 1, 2},
            {0, 3, 6},
            {0, 4, 8},
            {1, 4, 7},
            {2, 4, 6},
            {2, 5, 8},
            {3, 4, 5},
            {6, 7, 8}};

    private static int getIndex(String[] coordinate) {
        int row = Integer.parseInt(coordinate[0]);
        int column = Integer.parseInt(coordinate[1]);
        return 3 * (row - 1) + (column - 1);
    }

    private static boolean isValidIndex(String[] coordinate) {
        return "123".contains(coordinate[0]) && "123".contains(coordinate[1]);
    }

    public void initialize(String[] cells) {
        this.cells = cells;
    }

    public void draw() {
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public void enterCoordinate(String[] coordinate) {
        cells[getIndex(coordinate)] = getNextMark();
    }

    private String getNextMark() {
        int x = 0;
        int o = 0;
        for (String cell : cells) {
            switch (cell) {
                case "X":
                    x++;
                    break;
                case "O":
                    o++;
                    break;
            }
        }
        return x > o ? "O" : "X";
    }

    public String isValidPlacement(String[] coordinate) {
        String numbers = "0123456789";
        if (!numbers.contains(coordinate[0]) || !numbers.contains(coordinate[1])) {
            return "You should enter numbers!";
        }
        if (!isValidIndex(coordinate)) {
            return "Coordinates should be from 1 to 3!";
        }
        int index = getIndex(coordinate);
        if (!cells[index].equals(" ")) {
            return "This cell is occupied! Choose another one!";
        }
        return "";
    }

    public boolean isConcluded() {
        return getWinner().length() > 0 || isDraw();
    }

    private boolean areAllEqual(int i, int j, int k) {
        String mark = cells[i];
        if (mark.equals(" ")) {
            return false;
        }
        return mark.equals(cells[j]) && mark.equals(cells[k]);
    }

    public boolean isDraw() {
        for (String cell : cells) {
            if( cell.equals(" ")) {
                return false;
            }
        }
        return true;
    }

    public String getWinner() {
        for (int[] row : rows) {
            if (areAllEqual(row[0], row[1], row[2])) {
                return cells[row[0]].toUpperCase(Locale.ROOT);
            }
        }
        return "";
    }
}
