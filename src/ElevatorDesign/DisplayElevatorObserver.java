package ElevatorDesign;

public class DisplayElevatorObserver implements ElevatorObserver{

    @Override
    public void OnfloorChange(Elevator e, int floor) {
        System.out.println("The elevator with id: "+e.getElevatorid()+" has changed the floor to : "+floor);
    }

    @Override
    public void OnstateChange(Elevator e, ElevatorState state) {
        System.out.println("The Elevator with ID: "+e.getElevatorid()+" has changed the state to  "+state.toString());
    }
}
