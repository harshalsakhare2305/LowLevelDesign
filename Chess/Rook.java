package Chess;

public class Rook extends Piece{

    Rook(boolean isWhite){
        super(isWhite);
    }

    @Override
    boolean canMove(Cell startcell, Cell endCell, Board board) {
        int rowdiff =Math.abs(endCell.getPosition().getRow()-startcell.getPosition().getRow());
        int coldiff =Math.abs(endCell.getPosition().getCol()-startcell.getPosition().getCol());

        return (rowdiff==0  || coldiff==0);
    }
}
