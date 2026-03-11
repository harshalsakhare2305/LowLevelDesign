package ElevatorDesign;

import java.util.*;

public class LOOK implements ElevatorStrategy {


    @Override
    public int nextFloor(Elevator e) {

        Queue<ElevatorRequest> elevatorRequestQueue = e.getRequestQueue();

        int currfloor = e.getCurrfloor();

        if (elevatorRequestQueue.isEmpty()) return currfloor;

        int primaryFloor = elevatorRequestQueue.peek().getFloor();
        Direction traveldirection;

        if (currfloor > primaryFloor) {
            traveldirection = Direction.DOWN;

        } else if (currfloor < primaryFloor) {
            traveldirection = Direction.UP;
        } else {
            return currfloor;
        }


        //We have to check the nearest req between primarly floor and currfloor
        Integer candidate = null;

        for (ElevatorRequest req : elevatorRequestQueue) {

            if (traveldirection == Direction.UP && req.getFloor() > currfloor && req.getFloor() <= primaryFloor) {

                if (req.isInternalRequest() || (!req.isInternalRequest() && req.getReqdirection() == Direction.UP)) {

                    if (candidate == null || candidate > req.getFloor()) {
                        candidate = req.getFloor();
                    }
                }
            } else if (traveldirection == Direction.DOWN && req.getFloor() < currfloor && req.getFloor() >= primaryFloor) {

                if (req.isInternalRequest() || (!req.isInternalRequest() && req.getReqdirection() == Direction.DOWN)) {

                    if (candidate == null || candidate < req.getFloor()) {
                        candidate = req.getFloor();
                    }
                }
            }

        }

        return (candidate != null ? candidate : primaryFloor);
    }

}
