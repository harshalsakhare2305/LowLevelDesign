package LLDQuestions.Elevator.ElevatorDesign2;

import java.util.Queue;

public class LOOKStrategy implements ElevatorStrategy {

    @Override
    public int getNextFloor(Elevator e) {
        int currfloor=e.getCurrfloor();
        Queue<ElevatorRequest> requests=e.getRequests();

        if(requests.isEmpty())return currfloor;

        int primaryfloor=requests.peek().getFloor();
        Direction traveldirection;

        if(primaryfloor>currfloor){
            traveldirection=Direction.UP;
        }else if(primaryfloor<currfloor){
            traveldirection=Direction.DOWN;
        }else{
            return currfloor;
        }


        Integer candidate=null;

         for(ElevatorRequest req:requests){

             int floor =req.getFloor();

             if(traveldirection==Direction.UP && floor<=primaryfloor && floor>currfloor){

                 if(req.isInternalRequest() || (!req.isInternalRequest() && req.getReqDirection()==Direction.UP)){

                     if(candidate==null || floor<candidate){
                         candidate=floor;
                     }
                 }
             }else if(traveldirection==Direction.DOWN && floor>=primaryfloor && floor<currfloor){

                 if(req.isInternalRequest() || (!req.isInternalRequest() && req.getReqDirection()==Direction.DOWN)){
                     if(candidate==null || floor>candidate){
                         candidate=floor;
                     }
                 }
             }
         }

         return candidate==null?primaryfloor:candidate;



    }
}
