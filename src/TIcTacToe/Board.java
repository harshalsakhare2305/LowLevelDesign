package TIcTacToe;

public class Board {
    private int size;
    private Symbol[][] grid;

    Board(int size){
        this.size=size;
        this.grid=new Symbol[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]=Symbol.EMPTY;
            }
        }
    }

    boolean isValidMove(int r,int c){
        return (r>=0 && r<size && c>=0 && c<size && grid[r][c]==Symbol.EMPTY);
    }

    void makeMove(Position p,Player currplayer){
        grid[p.r][p.c]=currplayer.getMysymbol();
    }

    public int getSize() {
        return size;
    }

    public Symbol[][] getGrid() {
        return grid;
    }
}
