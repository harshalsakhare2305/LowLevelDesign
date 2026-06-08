package ChessPractice;

public class Board {
    private static Board board;
    private Cell[][] grid;

    private Board(){
        this.grid=new Cell[8][8];
        intializeboard();
    }

    public static Board createInstance(){
        if(board!=null)return board;
        return new Board();
    }

    void intializeboard(){

        setPiece(0,true);
        setPawn(1,true);


        setPiece(7,false);
        setPawn(6,false);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    private void setPiece(int row, boolean isWhite){

        grid[row][0]=new Cell(new Position(row,0),PieceFactory.createPiece("rook",isWhite));
        grid[row][7]=new Cell(new Position(row,7),PieceFactory.createPiece("rook",isWhite));

        //Similary We will place al the pieces

    }

   private void setPawn(int row,boolean isWhite){

    }

}
