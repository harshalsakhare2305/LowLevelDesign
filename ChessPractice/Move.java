package ChessPractice;

public class Move {
    private  Cell startCell;
    private Cell endCell;


    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public Cell getStartCell() {
        return startCell;
    }

    boolean isValid(){
        if(startCell.getPiece()!=null && endCell.getPiece()!=null){
            return (startCell.getPiece().isWhite() !=endCell.getPiece().isWhite());
        }else if(startCell.getPiece()!=null){
            return true;
        }

        return false;
    }
}
