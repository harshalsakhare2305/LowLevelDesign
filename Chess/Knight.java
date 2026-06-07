package Chess;

public class Knight extends Piece{

    Knight(boolean isWhite){
        super(isWhite);
    }

    @Override
    boolean canMove(Cell startcell, Cell endCell, Board board) {
        int rowdiff =Math.abs(endCell.getPosition().getRow()-startcell.getPosition().getRow());
        int coldiff =Math.abs(endCell.getPosition().getCol()-startcell.getPosition().getCol());

        return ((rowdiff==2 && coldiff==1) || (coldiff==2 || rowdiff==1));
    }
}
