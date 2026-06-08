package ChessPractice;


import ChessPractice.Chess;
import ChessPractice.Player;

public class Main {
    public static void main(String[] args) {
        Player white =new Player(true);
        Player black =new Player(false);

        Chess chess =new Chess(white,black);
        chess.start();
    }
}

