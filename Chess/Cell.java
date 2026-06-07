package Chess;

public class Cell {

    private Position position;
    private Piece piece;

    Cell(Position position,Piece piece){
        this.position=position;
        this.piece=piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getPosition() {
        return position;
    }
}
