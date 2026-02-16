package LLDQuestions.Elevator.ElevatorDesign2;

public class Main {

    public static void main(String[] args) {
      Building harshal =new Building(5,3,"harshal");
      ElevatorController controller=harshal.getController();

      DisplayObserver d =new DisplayObserver();

      for(Elevator e:controller.getElevatorList()){
          e.addObserver(d);
      }

      controller.RequestElevator(2,4,Direction.DOWN);
      controller.RequestFloor(3,2);
      controller.RequestElevator(0,3,Direction.DOWN);
      controller.RequestFloor(0,2);




      controller.step();
    }
}
