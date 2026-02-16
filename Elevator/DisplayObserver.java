package LLDQuestions.Elevator.ElevatorDesign2;



public class DisplayObserver implements ElevatorObserver {

    @Override
    public void OnStateChange(Elevator e, ElevatorState state) {
        System.out.println("The elevator with id"+e.getId()+" Has changed the state to "+state.toString());
    }

    @Override
    public void OnFloorChange(Elevator e, int floor) {
        System.out.println("The elevator with id"+e.getId()+" Has changed the floor to "+floor);
    }
}
