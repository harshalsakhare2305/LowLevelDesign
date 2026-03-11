package ElevatorDesign;

public interface ElevatorObserver {

    void OnfloorChange(Elevator e,int floor);

    void OnstateChange(Elevator e,ElevatorState state);
}
