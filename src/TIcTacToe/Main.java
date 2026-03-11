package TIcTacToe;

public class Main {
    public static void main(String[] args) {
        Board b =new Board(3);
        PlayerStrategy p1=new HumanPlayerStrategy(b);
        PlayerStrategy p2=new HumanPlayerStrategy(b);
          TicTacToeGame tictactoe =new TicTacToeGame(b,p1,p2);

          tictactoe.play();
    }
}
