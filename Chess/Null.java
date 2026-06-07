package Chess;

public class Null extends Piece{
    Null(boolean isWhite){
        super(isWhite);
    }

    @Override
    boolean canMove(Cell startcell, Cell endCell, Board board) {
        return false;
    }
}
