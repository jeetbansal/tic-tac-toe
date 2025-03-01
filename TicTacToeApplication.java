import Piece.PieceType;

import java.util.ArrayDeque;
import java.util.Deque;

public class TicTacToeApplication {

    public static void main(String[] args) {

        Deque<Player> playerList = new ArrayDeque<>();
        playerList.addLast(new Player("AMAN", PieceType.O));
        playerList.addLast(new Player("JEET", PieceType.X));
        Game game = new Game(playerList, 3, 3);
        System.out.println("Starting tic-tac-toe game. Get ready to fight");
        game.printBoard();
        game.runGame();
    }
}
