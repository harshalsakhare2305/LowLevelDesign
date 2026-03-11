package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private List<Elevator> elevatorList;
    private List<Integer> floorList;

    private ElevatorStrategy strategy;

    private  int currfloor;


    ElevatorController(){
        elevatorList=new ArrayList<>();
        floorList=new ArrayList<>();
        this.strategy=new LOOK();

        this.currfloor=0;
    }

    ElevatorController(int floor,int elevator){
        this();
        for(int i=0;i<=floor;i++){
            floorList.add(i);
        }

        for(int i=0;i<=elevator;i++){
            elevatorList.add(new Elevator(i));
        }

    }

    void RequestFloor(int elevatorid,int floor){
        Elevator availableWIthid=getElevatorWithID(elevatorid);



        if(availableWIthid!=null){

            Direction d=availableWIthid.getCurrfloor()>floor?Direction.DOWN:Direction.UP;
            availableWIthid.addRequest(new ElevatorRequest(elevatorid,floor,true,d));
            System.out.println("Internal Reuqest has been made");
        }
    }

    void RequestElevator(int elevatorid,int floor,Direction d){
        Elevator availableWIthid=getElevatorWithID(elevatorid);

        if(availableWIthid!=null){

            availableWIthid.addRequest(new ElevatorRequest(elevatorid,floor,false,d));
            System.out.println("External Reuqest has been made");
        }
    }

    Elevator getElevatorWithID(int elevatorid){
        for(Elevator e:elevatorList){
            if(e.getElevatorid()==elevatorid)return e;
        }

        return null;
    }

    void step(){
        for(Elevator e:elevatorList){

            int floor=strategy.nextFloor(e);
            e.MoveTonext(floor);

        }
    }

    void addObserver(ElevatorObserver o){
        for(Elevator e:elevatorList){

            e.addObserver(o);

        }
    }
    public void setStrategy(ElevatorStrategy strategy) {
        this.strategy = strategy;
    }

    public int getCurrfloor() {
        return currfloor;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public ElevatorStrategy getStrategy() {
        return strategy;
    }

    public List<Integer> getFloorList() {
        return floorList;
    }
}
