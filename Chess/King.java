package Chess;

public class King extends Piece{

    King(boolean isWhite){
        super(isWhite);
    }

    @Override
    boolean canMove(Cell startcell, Cell endCell, Board board) {
        int rowdiff =Math.abs(endCell.getPosition().getRow()-startcell.getPosition().getRow());
        int coldiff =Math.abs(endCell.getPosition().getCol()-startcell.getPosition().getCol());

        return ((rowdiff==1 || coldiff==0) || (coldiff==1 && rowdiff==0) || (rowdiff==1 && coldiff==1));


    }
}
