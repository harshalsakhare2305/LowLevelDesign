package ElevatorDesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {

    private  int elevatorid;

    private Direction direction;
    private ElevatorState state;
    private int currfloor;
    private Queue<ElevatorRequest> requestQueue;

    private List<ElevatorObserver> observerList;

    Elevator(int id){
        this.elevatorid=id;
        this.direction=Direction.IDLE;
        this.state=ElevatorState.IDLE;
        this.requestQueue=new LinkedList<>();
        this.observerList=new ArrayList<>();
        this.currfloor=0;
    }

    void addRequest(ElevatorRequest e){

        if(!requestQueue.contains(e)){
            requestQueue.add(e);
        }

        int reqfloor=e.getFloor();

        if(state==ElevatorState.IDLE && !requestQueue.isEmpty()){

            if(currfloor>reqfloor){
                direction=Direction.DOWN;
            }else{
                direction=Direction.UP;
            }
        }

        setState(ElevatorState.MOVING);
    }


    void MoveTonext(int floor){

        if(state!=ElevatorState.MOVING)return;



        while(currfloor!=floor){
            if(direction==Direction.UP){
                currfloor++;
            }else if(direction==Direction.DOWN){
                currfloor--;
            }else{
                System.out.println("Thhe direction is IDLE");
                break;
            }

            OnfloorChange(currfloor);

            if(currfloor==floor){
                compleArrival(this);
                return ;
            }
        }
    }

    void compleArrival(Elevator e){
        System.out.println("The elevator  with id "+elevatorid+" reached the destination floor "+currfloor);
        setState(ElevatorState.STOPPED);
        requestQueue.removeIf(elevatorRequest -> elevatorRequest.getFloor()==currfloor);
        if(requestQueue.isEmpty()){
           setDirection(Direction.IDLE);
           setState(ElevatorState.IDLE);
        }else{
            setState(ElevatorState.MOVING);
        }
    }

    void addObserver(ElevatorObserver o){
        observerList.add(o);
    }

    void OnfloorChange(int floor){
        for(ElevatorObserver o:observerList){
            o.OnfloorChange(this,floor);
        }
    }

    void ONStateChange(ElevatorState s){
        for(ElevatorObserver o:observerList){
            o.OnstateChange(this,s);
        }
    }

    void setDirection(Direction d){
        this.direction=d;
    }

    void setState(ElevatorState s){
        this.state=s;
        ONStateChange(s);
    }

    public List<ElevatorObserver> getObserverList() {
        return observerList;
    }

    public ElevatorState getState() {
        return state;
    }

    public int getCurrfloor() {
        return currfloor;
    }

    public int getElevatorid() {
        return elevatorid;
    }

    public Direction getDirection() {
        return direction;
    }

    public Queue<ElevatorRequest> getRequestQueue() {
        return requestQueue;
    }

}
