package Chess;

public class Board {

    private Cell[][] grid;


    Board(){
        this.grid=new Cell[8][8];
    }

    void initializeBoard(){

        setPieces(0,true);
        setPawn(1,true);

        setPieces(7,false);
        setPawn(6,false);
    }


    void setPieces(int row,boolean isWhite){

        grid[row][0]=new Cell(new Position(row,0),PieceFactory.createPiece("Rook",isWhite));
        grid[row][7]=new Cell(new Position(row,7),PieceFactory.createPiece("Rook",isWhite));

        grid[row][1]=new Cell(new Position(row,1),PieceFactory.createPiece("Knight",isWhite));
        grid[row][6]=new Cell(new Position(row,6),PieceFactory.createPiece("Knight",isWhite));

        grid[row][2]=new Cell(new Position(row,2),PieceFactory.createPiece("Bishop",isWhite));
        grid[row][5]=new Cell(new Position(row,5),PieceFactory.createPiece("Bishop",isWhite));

        grid[row][3]=new Cell(new Position(row,3),PieceFactory.createPiece("King",isWhite));


        grid[row][4]=new Cell(new Position(row,4),PieceFactory.createPiece("Queen",isWhite));







    }
    void setPawn(int row,boolean isWhite){

        for(int i=0;i<=7;i++){
            grid[row][i]=new Cell(new Position(row,i),PieceFactory.createPiece("Pawn",isWhite));
        }

        for(int i=2;i<=5;i++){
            for(int j=0;j<=7;j++){
                grid[i][j]=new Cell(new Position(i,j),null);
            }
        }
    }



}
