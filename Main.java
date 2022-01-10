package tictactoe;

public class Main {
    public static void main(String[] args) {
        // write your code here
        GameBoard gameBoard = new GameBoard();
        UserInput userInput = new UserInput();
        userInput.collectSetup("Enter the cells: ");
        gameBoard.initialize(userInput.getCells());
        gameBoard.draw();
        do {
            userInput.collectInput("Enter the coordinates: ", gameBoard);
            gameBoard.enterCoordinate(userInput.getCoordinate());
            gameBoard.draw();
            String winner = gameBoard.getWinner();
            if (winner.length() > 0) {
                System.out.println(winner + " wins");
            } else if (gameBoard.isDraw()) {
                System.out.println("Draw");
            } else {
                System.out.println("Game not finished");
            }
        }
        while (!gameBoard.isConcluded());
    }
}
