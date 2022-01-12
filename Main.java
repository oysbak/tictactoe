package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager;
        do {
            System.out.print("Input command: ");
            gameManager = new GameManager(scanner.nextLine());
            if (gameManager.doStart()) {
                if (gameManager.isValidParameterSetup()) {
                    new Game(gameManager);
                } else {
                    System.out.println("Bad parameters!");
                }
            }
        } while (!gameManager.doExit());
    }
}
