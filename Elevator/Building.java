package LLDQuestions.Elevator.ElevatorDesign2;

public class Building {

    String name;

    private  ElevatorController controller;

    Building(int floors,int elevators,String name){
        this.controller=new ElevatorController(elevators,floors);
        this.name=name;
    }


    public ElevatorController getController() {
        return controller;
    }
}
