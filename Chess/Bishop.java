package Chess;

public class Bishop extends Piece{

    Bishop(boolean isWhite){
        super(isWhite);
    }

    @Override
    boolean canMove(Cell startcell, Cell endCell, Board board) {
        int rowdiff =Math.abs(endCell.getPosition().getRow()-startcell.getPosition().getRow());
        int coldiff =Math.abs(endCell.getPosition().getCol()-startcell.getPosition().getCol());

        return (rowdiff==coldiff);
    }
}
