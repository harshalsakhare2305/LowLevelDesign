package TIcTacToe;

public class Player {
    private Symbol mysymbol;
    private String name;
    private PlayerStrategy mystrategy;

    Player(Symbol s,String name,PlayerStrategy st){
        this.mystrategy=st;
        this.name=name;
        this.mysymbol=s;
    }

    public PlayerStrategy getMystrategy() {
        return mystrategy;
    }

    public String getName() {
        return name;
    }

    public Symbol getMysymbol() {
        return mysymbol;
    }
}
