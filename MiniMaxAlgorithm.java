package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MiniMaxAlgorithm {
    private final String huPlayer;
    private final String aiPlayer;
    private final String[] origBoard;

    public MiniMaxAlgorithm(String humanMark, String machineMark, String[] currentGameBoard) {
        // Human
        huPlayer = humanMark;
        // AI-player
        aiPlayer = machineMark;
        // Construct origBoard
        this.origBoard = Arrays.copyOf(currentGameBoard, currentGameBoard.length);
        for (int i = 0; i < 9; i++) {
            if (Objects.equals(origBoard[i], " ")) {
                origBoard[i] = Integer.toString(i);
            }
        }
    }

    public String[] getCoordinate() {
        // Finding the ultimate play on the game that favors the computer
        Move bestMove = minimax(origBoard, aiPlayer);
        return GameBoard.getCoordinate(bestMove.index);
    }

    // Main minimax function
    private Move minimax(String[] gameBoard, String playerMark) {
        // Available spots
        int[] freeSpots = emptyIndexes(gameBoard);

        // Checks for the terminal states such as win, lose, and tie and returning a value accordingly
        if (winning(gameBoard, huPlayer)) {
            return new Move(-1, -10);
        } else if (winning(gameBoard, aiPlayer)) {
            return new Move(-1, 10);
        } else if (freeSpots.length == 0) {
            return new Move(-1, 0);
        }

        // An array to collect all the objects
        List<Move> moves = new ArrayList<>();

        // Loop through available spots
        for (int spot : freeSpots) {
            // Create an object for each and store the index of that spot that
            // was stored as a number in the object's index key
            int freeSpot = Integer.parseInt(gameBoard[spot]);
            Move move = new Move(freeSpot, 0);

            // Set the empty spot to the current player
            gameBoard[freeSpot] = playerMark;

            // If collect the score resulted from calling minimax
            // on the opponent of the current player
            if (playerMark.equals(aiPlayer)) {
                move.score = minimax(gameBoard, huPlayer).score;
            } else {
                move.score = minimax(gameBoard, aiPlayer).score;
            }

            // Reset the spot to empty
            gameBoard[freeSpot] = String.valueOf(move.index);

            // Push the object to the array
            moves.add(move);
        }

        // If it is the computer's turn loop over the moves
        // and choose the move with the highest score
        int bestMoveIndex = -1;
        if (playerMark.equals(aiPlayer)) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMoveIndex = i;
                }
            }
        } else {
            // else loop over the moves and choose the move with the lowest score
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMoveIndex = i;
                }
            }
        }

        // Return the chosen move (object) from the array to the higher depth
        return moves.get(bestMoveIndex);
    }

    // Winning combinations using the board indexes,
    // for instance the first win could be 3 x's in a row
    private boolean winning(String[] board, String mark) {
        return (board[0].equals(mark) && board[1].equals(mark) && board[2].equals(mark)) ||
                (board[3].equals(mark) && board[4].equals(mark) && board[5].equals(mark)) ||
                (board[6].equals(mark) && board[7].equals(mark) && board[8].equals(mark)) ||
                (board[0].equals(mark) && board[3].equals(mark) && board[6].equals(mark)) ||
                (board[1].equals(mark) && board[4].equals(mark) && board[7].equals(mark)) ||
                (board[2].equals(mark) && board[5].equals(mark) && board[8].equals(mark)) ||
                (board[0].equals(mark) && board[4].equals(mark) && board[8].equals(mark)) ||
                (board[2].equals(mark) && board[4].equals(mark) && board[6].equals(mark));
    }

    // Returns the available spots on the board
    private int[] emptyIndexes(String[] board) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(String.valueOf(i))) {
                indexes.add(i);
            }
        }
        return indexes.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public String toString() {
        return "MiniMaxAlgorithm{" +
                "origBoard=" + Arrays.toString(origBoard) +
                ", huPlayer='" + huPlayer + '\'' +
                ", aiPlayer='" + aiPlayer + '\'' +
                '}';
    }

    static class Move {
        public int index;
        public int score;

        Move(int index, int score) {
            this.index = index;
            this.score = score;
        }

    }
}
