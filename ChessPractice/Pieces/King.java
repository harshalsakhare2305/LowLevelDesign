package ChessPractice.Pieces;

import ChessPractice.Board;
import ChessPractice.Cell;
import ChessPractice.Piece;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Cell StartCell, Cell EndCell, Board board) {

        // We write logic
        return false;
    }
}
