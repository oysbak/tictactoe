package tictactoe;

import tictactoe.player.Player;

public class Game {
    public Game(GameManager gameManager) {
        GameBoard gameBoard = new GameBoard();
        Player firstPlayer = gameManager.constructFirstPlayer(gameBoard);
        Player secondPlayer = gameManager.constructSecondPlayer(gameBoard);
        gameBoard.draw();
        boolean isFirstPlayerNext = true;
        do {
            if (isFirstPlayerNext) {
                firstPlayer.requestShot();
                gameBoard.placeShot(firstPlayer.getShot());
                isFirstPlayerNext = false;
            } else {
                secondPlayer.requestShot();
                gameBoard.placeShot(secondPlayer.getShot());
                isFirstPlayerNext = true;
            }
            gameBoard.draw();
        }
        while (!gameBoard.isConcluded());
        System.out.println(gameBoard.getResult());
    }
}
