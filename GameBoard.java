package tictactoe;

public class GameBoard {
    String[] cells;

    public GameBoard(String[] cells) {
        this.cells = cells;
    }

    public void draw() {
        int row = 0;
        int column = 0;
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public void enterCoordinate(String[] coordinate) {
        int row = Integer.parseInt(coordinate[0]);
        int column = Integer.parseInt(coordinate[1]);
        int index = row - 1 + column - 1;
        cells[index] = "X";
    }
}
