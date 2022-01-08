package tictactoe;

public class Main {
    public static void main(String[] args) {
        // write your code here
        GameBoard gameBoard;
        UserInput userInput = new UserInput();
        userInput.collectInput("Enter the cells: ");
        gameBoard = new GameBoard(userInput.getCells());
        gameBoard.draw();
        userInput.collectInput("Enter the coordinates: ");
        gameBoard.enterCoordinate(userInput.getCoordinate());
        gameBoard.draw();
        System.out.println("X wins");
    }
}
