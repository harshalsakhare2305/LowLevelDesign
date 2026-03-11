package TIcTacToe;

import java.sql.SQLOutput;

public class TicTacToeGame implements Game{

    private Board b;
    private Player player_x;
    private Player player_o;
    private Player currplayer;
    private GameState currstate;

    TicTacToeGame(Board b,PlayerStrategy p1,PlayerStrategy p2){
        this.b=b;
        this.player_x=new Player(Symbol.X,"Guest1",p1);
        this.player_o=new Player(Symbol.O,"Guest2",p2);
        this.currplayer=player_x;
        this.currstate=GameState.MOVING;
    }

    @Override
    public void play() {

        do{
            printboard();

            Position p=currplayer.getMystrategy().makemove();
            b.makeMove(p,currplayer);
            boolean isEnd=checkWin_DrawCondition();
            if(!isEnd){
                switchplayer();
            }else{
                annouceResult();
            }


        }while(currstate==GameState.MOVING);
    }

    void printboard(){
        Symbol[][] grid=b.getGrid();
        int size=b.getSize();

        for(int i=0;i<size;i++){
            System.out.print("|");
            for(int j=0;j<size;j++){
                if(grid[i][j]==Symbol.EMPTY){
                    System.out.print(" . ");
                } else if(grid[i][j]==Symbol.O){
                    System.out.print(" O ");
                }else if(grid[i][j]==Symbol.X){
                    System.out.print(" X ");
                }

                System.out.print("|");
            }
            System.out.println();

        }

    }

    boolean checkWin_DrawCondition(){
        Symbol[][] grid=b.getGrid();
        int size=b.getSize();
        for(int i=0;i<size;i++){
            if(grid[i][0]!=Symbol.EMPTY && checkRow(grid[i])){
                setCurrstate(currplayer==player_x?GameState.WIN_X:GameState.WIN_O);
                return true;
            }
        }

        for(int j=0;j<size;j++){
            Symbol[] columns =new Symbol[size];
            for(int i=0;i<size;i++){
                columns[i]=grid[i][j];
            }

            if(columns[0]!=Symbol.EMPTY && checkRow(columns)){
                setCurrstate(currplayer==player_x?GameState.WIN_X:GameState.WIN_O);
                return true;
            }
        }


        Symbol[] diagonal1 =new Symbol[size];
        Symbol[] diagonal2=new Symbol[size];
        int emptySpot=0;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[i][j]==Symbol.EMPTY)emptySpot++;
                diagonal1[i]=grid[i][i];
                diagonal2[i]=grid[i][size-j-1];
            }
        }

        if((diagonal2[0]!=Symbol.EMPTY && checkRow(diagonal1) )|| (diagonal2[0]!=Symbol.EMPTY && checkRow(diagonal2))){
            setCurrstate(currplayer==player_x?GameState.WIN_X:GameState.WIN_O);
            return true;
        }

        if(emptySpot==0){
            setCurrstate(GameState.DRAW);
            return true;
        }

        return false;
    }


    boolean checkRow(Symbol[] r){
        Symbol check =r[0];
        for(int i=1;i< r.length;i++){
            if(r[i]!=check){
                return false;
            }
        }

        return true;
    }

    void switchplayer(){
        if(currplayer==player_x){
            setCurrplayer(player_o);
        }else{
            setCurrplayer(player_x);
        }
    }

    void annouceResult(){
        if(currstate==GameState.WIN_X){
            System.out.println("Congrats! player X has won the Game");
        }else if(currstate==GameState.WIN_O){
            System.out.println("Congrats! player O has won the Game");
        }else{
            System.out.println("Better Next Time! Game Ended in Draw State");
        }
    }

    public void setCurrstate(GameState currstate) {
        this.currstate = currstate;
    }

    public void setCurrplayer(Player currplayer) {
        this.currplayer = currplayer;
    }
}
