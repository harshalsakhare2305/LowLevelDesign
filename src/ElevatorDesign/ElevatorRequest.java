package ElevatorDesign;

public class ElevatorRequest implements Command{

    private int elevatorid;
    private boolean IsInternalRequest;
    private  int floor;

    private Direction reqdirection;
    private ElevatorController controller;

    ElevatorRequest(int elevatorid,int floor,boolean isInternalRequest,Direction reqdirection){
        this.elevatorid=elevatorid;
        this.floor=floor;
        this.IsInternalRequest=isInternalRequest;
        this.reqdirection=reqdirection;
    }



    @Override
    public void excute() {
        if(IsInternalRequest){
            controller.RequestFloor(elevatorid,floor);
        }else{
            controller.RequestElevator(elevatorid,floor,reqdirection);
        }
    }

    public int getElevatorid() {
        return elevatorid;
    }

    public boolean isInternalRequest() {
        return IsInternalRequest;
    }

    public ElevatorController getController() {
        return controller;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getReqdirection() {
        return reqdirection;
    }

}
