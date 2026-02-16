package LLDQuestions.Elevator.ElevatorDesign2;

public interface ElevatorObserver {

    void OnStateChange(Elevator e,ElevatorState state);
    void OnFloorChange(Elevator e,int floor);


}
