package ChessPractice;

public abstract class Piece {
    private boolean isWhite;
    private boolean iskilled=false;

    public  Piece(boolean isWhite){
        this.isWhite=isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isIskilled() {
        return iskilled;
    }

    public void setIskilled(boolean iskilled) {
        this.iskilled = iskilled;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }



    public abstract boolean canMove(Cell StartCell, Cell EndCell, Board board);
}
