package ChessPractice;

import ChessPractice.Pieces.King;

import java.util.Scanner;

public class Chess {

    private Board board;
    private Player white;
    private Player black;
    private  boolean isWhiteTurn;
    private GameStatus status;
    private Scanner sc;


    public Chess(Player white, Player black) {
        this.board = Board.createInstance();
        this.white = white;
        this.black = black;
        this.isWhiteTurn = true;
        this.status =GameStatus.ACTIVE;
        this.sc=new Scanner(System.in);
    }

    void start(){

        while (status!=GameStatus.ACTIVE){

            Cell[][] grid = board.getGrid();

            System.out.println("Enter the Start row and Col ");

            int strow=sc.nextInt();
            int stcol=sc.nextInt();

            System.out.println("Enter the End row and Col ");

            int enrow=sc.nextInt();
            int encol=sc.nextInt();

            Cell StartCell=grid[strow][stcol];
            Cell EndCell =grid[enrow][encol];

            Move move =new Move(StartCell,EndCell);
            if(move.isValid()){
                makeMove(move);
            }else{
                System.out.println("Invalid Position");
            }


        }
    }

    void makeMove(Move move){

        Piece StartPiece =move.getStartCell().getPiece();
        if(StartPiece.canMove(move.getStartCell(),move.getEndCell(),board)){

           if(move.getEndCell()!=null){
               Piece endPiece =move.getEndCell().getPiece();

               if(endPiece instanceof King && isWhiteTurn){
                   status=GameStatus.WHITE_WIN;
               }

               if(endPiece instanceof King && !isWhiteTurn){
                   status=GameStatus.BLACK_WIN;
               }

               endPiece.setIskilled(true);



           }
            move.getEndCell().setPiece(StartPiece);
            move.getStartCell().setPiece(null);


        }else{
            System.out.println("This is not valid move for your piece");
        }

    }
}


