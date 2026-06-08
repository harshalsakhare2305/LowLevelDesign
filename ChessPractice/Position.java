package ChessPractice;

public class Position {
    private  int row;
    private int col;

    public Position(int row,int col) {
        this.col = col;
        this.row=row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
