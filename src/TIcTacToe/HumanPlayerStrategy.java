package TIcTacToe;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy{

    private Scanner sc;
    private Board b;

    HumanPlayerStrategy(Board b){
        sc=new Scanner(System.in);
        this.b=b;
    }

    @Override
    public Position makemove() {



        while(true){
            System.out.println("Enter you Move: ");
            int r=sc.nextInt();
            int c =sc.nextInt();

            if(b.isValidMove(r,c)){
                Position p =new Position(r,c);
                return p;
            }else{
                System.out.println("Plz make some valid move either this position does exist or its not empty");
            }
        }
    }
}
