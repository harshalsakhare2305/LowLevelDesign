package LLDQuestions.Elevator.ElevatorDesign2;



public class ElevatorRequest implements Command{

    private  int elevatorid;

    private int floor;

    private Direction reqDirection;

    private  boolean isInternalRequest;

    private ElevatorController controller;

    ElevatorRequest(int elevatorid, int floor,boolean isInternalRequest ,Direction reqDirection){
        this.elevatorid=elevatorid;
        this.floor=floor;
        this.reqDirection=reqDirection;
        this.isInternalRequest=isInternalRequest;

        this.controller=new ElevatorController();
    }

    @Override
    public void execute() {
        if(isInternalRequest){
            controller.RequestFloor(elevatorid,floor);
        }else{
            controller.RequestElevator(elevatorid,floor,reqDirection);
        }
    }

    public int getElevatorid() {
        return elevatorid;
    }

    public ElevatorController getController() {
        return controller;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getReqDirection() {
        return reqDirection;
    }

    public boolean isInternalRequest() {
        return isInternalRequest;
    }

}
