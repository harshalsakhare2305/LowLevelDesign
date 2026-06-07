package Chess;

public class Move {

    private Cell staetCell;
    private Cell endCell;

    Move(Cell st,Cell end){
        this.staetCell=st;
        this.endCell=end;
    }

    boolean isValid(){
        Piece startpiece =staetCell.getPiece();
        Piece endppiece = endCell.getPiece();

        if(startpiece!=null && endppiece!=null)return (startpiece.isWhite()!=endppiece.isWhite());
        else if(startpiece!=null)return true;
        else return false;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public Cell getStaetCell() {
        return staetCell;
    }
}
