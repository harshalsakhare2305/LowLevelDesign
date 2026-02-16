package LLDQuestions.Elevator.ElevatorDesign2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {

    private int id;
    private Direction currdirection;
    private ElevatorState state;
    private  int currfloor;
    private Queue<ElevatorRequest> requests;
    private List<ElevatorObserver> observerList;

    Elevator(int id){
        this.id=id;
        this.currdirection=Direction.IDLE;
        this.currfloor=0;
        this.requests=new LinkedList<>();
        this.observerList=new ArrayList<>();
        this.state=ElevatorState.IDLE;
    }

    void addObserver(ElevatorObserver o){
        System.out.println("Observer has been added ");
        observerList.add(o);
    }

    void removeObserver(ElevatorObserver o){
        observerList.remove(o);
    }

    void OnStateChange(ElevatorState state){
        for(ElevatorObserver o:observerList){
            o.OnStateChange(this,state);
        }
    }

    void OnFloorChange(int floor){
        for(ElevatorObserver o:observerList){
            o.OnFloorChange(this,floor);
        }
    }

    void addRequest(ElevatorRequest e){


           if(!requests.contains(e)){
               requests.add(e);
           }

       // System.out.println("florr requested is "+e.getFloor()+" "+requests.size());

      //  System.out.println("Elevator with id:"+e.getElevatorid()+"state is "+this.state);

        if(this.state==ElevatorState.IDLE && !requests.isEmpty()){

           // System.out.println("Direction of elevator with id: "+e.getElevatorid()+"direction  "+currdirection.toString());

//            if(currdirection==Direction.IDLE){
                if(e.getFloor()>currfloor){
                    this.currdirection=Direction.UP;
                 //   System.out.println("Direction of elevator with id: "+e.getElevatorid()+"changed the director to "+Direction.UP.toString());
                }else if(e.getFloor()<currfloor){
                    this.currdirection=Direction.DOWN;
                 //   System.out.println("Direction of elevator with id: "+e.getElevatorid()+"changed the director to "+Direction.DOWN.toString());
                }
//            }
        }
        setState(ElevatorState.MOVING);
    }

    void MoveToNextStop(int nextfloor){

        if(state!=ElevatorState.MOVING)return;

        while(currfloor!=nextfloor){
            if(currdirection==Direction.UP){
                currfloor++;
                OnFloorChange(currfloor);
            }else if(currdirection==Direction.DOWN){
                currfloor--;
                OnFloorChange(currfloor);
            }else{
                System.out.println("Error you have the request but your lift state is idle");
                break;
            }



            if(currfloor==nextfloor){

                CompleteArrival(currfloor);
                return;
            }
        }


    }

    void CompleteArrival(int floor){
        System.out.println("Elevator with id"+this.id+" has reached the floor Number : "+floor);

        setState(ElevatorState.STOPPED);

        requests.removeIf(request-> request.getFloor()==floor);

        if(requests.isEmpty()){
            setState(ElevatorState.IDLE);
            setDirection(Direction.IDLE);
        }else{
            setState(ElevatorState.MOVING);
        }
    }

    void setState(ElevatorState state){
        this.state=state;
        OnStateChange(state);
    }

    void setDirection(Direction d){
        this.currdirection=d;
    }

    public int getCurrfloor() {
        return currfloor;
    }

    public int getId() {
        return id;
    }

    public Direction getCurrdirection() {
        return currdirection;
    }

    public ElevatorState getState() {
        return state;
    }

    public List<ElevatorObserver> getObserverList() {
        return observerList;
    }

    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

}
