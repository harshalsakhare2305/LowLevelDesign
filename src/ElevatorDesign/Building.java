package ElevatorDesign;

public class Building {

    String name;
    private  ElevatorController controller;


    Building(int numfloor,int numele,String name){
        controller=new ElevatorController(numfloor,numele);
        this.name=name;
    }

    public ElevatorController getController() {
        return controller;
    }
}
