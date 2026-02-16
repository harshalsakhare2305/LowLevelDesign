package LLDQuestions.Elevator.ElevatorDesign2;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private List<Elevator> elevatorList;
    private List<Integer> floors;
    private int currfloor;
    private ElevatorStrategy stategy;


    ElevatorController(int num_elevator,int num_floor){
        this.elevatorList=new ArrayList<>();

        this.floors=new ArrayList<>();
        this.currfloor=0;
        this.stategy= new LOOKStrategy();
        for(int i=0;i<=num_elevator;i++){
            elevatorList.add(new Elevator(i));
        }

        for(int i=0;i<=num_floor;i++){
            floors.add(i);
        }


    }

    ElevatorController(){}

    void step(){

         for(Elevator e:elevatorList){

             if(!e.getRequests().isEmpty()){
                 int next=stategy.getNextFloor(e);
                 e.MoveToNextStop(next);
             }
         }
    }

    void RequestElevator(int elevatorid,int floor,Direction reqdirection){
        Elevator avail =getElevatorById(elevatorid);

        if(avail!=null){
            System.out.println("This is External Req=> The Request is made with elevator with id:"+elevatorid+" to go to floor "+floor);
            avail.addRequest(new ElevatorRequest(elevatorid,floor,false,reqdirection));
        }
    }

    void RequestFloor(int elevatorid,int floor){
        Elevator avail =getElevatorById(elevatorid);
        if(avail!=null){
            System.out.println("THis is Internal Request=> The Request is made with elevator with id:"+elevatorid+" to go to floor "+floor);

            Direction direction=(avail.getCurrfloor()>floor?Direction.DOWN:Direction.UP);
            avail.addRequest(new ElevatorRequest(elevatorid,floor,true,direction));
        }
    }

    Elevator getElevatorById(int id){
        for(Elevator e:elevatorList){
            if(e.getId()==id)return e;
        }

        return null;
    }

    public void setStategy(ElevatorStrategy stategy) {
        this.stategy = stategy;
    }

    public ElevatorStrategy getStategy() {
        return stategy;
    }

    public int getCurrfloor() {
        return currfloor;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public List<Integer> getFloors() {
        return floors;
    }

}
