package tictactoe;

import tictactoe.player.Human;
import tictactoe.player.Machine;
import tictactoe.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {
    List<String> input;

    public GameManager(String userInput) {
        input = new ArrayList<>(Arrays.asList(userInput.split("\\s+")));
        while (input.size() < 3) {
            input.add("");
        }
    }

    public boolean doExit() {
        return input.get(0).equalsIgnoreCase("exit");
    }

    public boolean doStart() {
        return input.get(0).equalsIgnoreCase("start");
    }

    public Player constructFirstPlayer(GameBoard gameBoard) {
        return constructPlayer(1, "X", gameBoard);
    }

    public Player constructSecondPlayer(GameBoard gameBoard) {
        return constructPlayer(2, "O", gameBoard);
    }

    private Player constructPlayer(int index, String mark, GameBoard gameBoard) {
        if (input.get(index).equalsIgnoreCase("user")) {
            return new Human(gameBoard, mark);
        } else {
            return new Machine(gameBoard, mark);
        }
    }

    public boolean isValidParameterSetup() {
        return doExit() || (doStart() && isValidPlayerType(1) && isValidPlayerType(2));
    }

    private boolean isValidPlayerType(int index) {
        return input.get(index).equalsIgnoreCase("user")
                || input.get(index).equalsIgnoreCase("easy");
    }
}
