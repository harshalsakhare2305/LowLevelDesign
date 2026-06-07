package Chess;

public abstract class Piece {
    private boolean isWhite;
    private boolean isKilled =false;

    Piece(boolean isWhite){
        this.isWhite=isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    abstract boolean canMove(Cell startcell, Cell endCell, Board board);
}
