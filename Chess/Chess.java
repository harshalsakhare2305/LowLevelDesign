package Chess;

public class Chess {

    private Board board;
    Player player1;
    Player player2;
    Player currplayer;
    GameState status;

    Chess(Player player1,Player player2){
     this.player1=player1;
     this.player2=player2;
     this.currplayer=player1;
     status=GameState.ACTIVE;
    }

    void start(){
        while (this.status==GameState.ACTIVE) {
            // take input for startCell


            //Take input for endCell


            //Create move obj
            //Move move =new Move(StartCell,EndCell)

            // if(move.isValid){
        //        makemove(Move,Board)
            //     }



        }
    }

    void makeMove(Move move,Board board){

        Cell start =move.getStaetCell();
        Cell end =move.getEndCell();




    }



}
