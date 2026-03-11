package ElevatorDesign;

public class Main {

    public static void main(String[] args) {
        Building name=new Building(6,5,"anme");

        ElevatorController controller=name.getController();

         ElevatorObserver display=new DisplayElevatorObserver();

         controller.addObserver(display);

         controller.RequestElevator(1,3,Direction.UP);
         controller.RequestFloor(3,6);

         controller.step();

    }
}
