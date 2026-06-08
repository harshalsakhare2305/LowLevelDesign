package ChessPractice.Pieces;

import ChessPractice.Board;
import ChessPractice.Cell;
import ChessPractice.Piece;

public class Bishop extends Piece {

    public Bishop(boolean isWhite){
        super(isWhite);
    }

    @Override
    public boolean canMove(Cell StartCell, Cell EndCell, Board board) {
        return false;
    }
}
