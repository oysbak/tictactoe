package tictactoe;

public class Main {
    public static void main(String[] args) {
        // write your code here
        GameBoard gameBoard = new GameBoard();
        Human human = new Human(gameBoard, "X");
        Machine machine = new Machine(gameBoard, "O");
        gameBoard.draw();
        boolean isHumanNext = true;
        do {
            if (isHumanNext) {
                human.requestShot("Enter the coordinates: ");
                gameBoard.placeShot(human.getShot());
                isHumanNext = false;
            } else {
                machine.requestShot("Making move level \"easy\"");
                gameBoard.placeShot(machine.getShot());
                isHumanNext = true;
            }
            gameBoard.draw();
        }
        while (!gameBoard.isConcluded());
        System.out.println(gameBoard.getResult());
    }
}
