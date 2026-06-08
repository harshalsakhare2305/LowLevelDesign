package ChessPractice.Pieces;

import ChessPractice.Board;
import ChessPractice.Cell;
import ChessPractice.Piece;

public class Rook extends Piece {
    public Rook(boolean isWhite){
        super(isWhite);
    }

    @Override
    public boolean canMove(Cell StartCell, Cell EndCell, Board board) {
        return false;
    }
}
