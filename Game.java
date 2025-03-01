import java.util.Deque;
import java.util.Scanner;

public class Game {

    Deque<Player> playerList;
    Board board;

    public Game(Deque<Player> playerList, int rowSize, int colSize) {
        this.board = new Board(rowSize, colSize);
        this.playerList = playerList;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void runGame() {
        boolean shouldContinue = true;
        while (shouldContinue) {

            //Get the player whose turn it is
            Player turn = playerList.pollFirst();

            //Take the input from the player
            Scanner scanner = new Scanner(System.in);
            System.out.println(turn.getName() + " which cell you wanna bet next? E.g. 2,2: ");
            String input = scanner.nextLine();

            //Fetch the cell from input
            String[] parts = input.split(",");
            int row = Integer.parseInt(parts[0].trim());
            int col = Integer.parseInt(parts[1].trim());

            //Put the player's piece on the board
            if (board.addPiece(row, col, turn)) {
                playerList.addLast(turn);
                board.printBoard();

                // Check for victory
                if (board.checkWin(row, col)) {
                    System.out.println(turn.getName() + " wins");
                    shouldContinue = false;
                }
                else if (board.isFilled()) {
                    System.out.println("Its a tie. Start with a new game");
                    shouldContinue = false;
                }
            }
            // Ask for the user input again
            else {
                playerList.addFirst(turn);
                System.out.println("This cell is already occupied. Try again with a different cell");
            }
        }
    }
}
