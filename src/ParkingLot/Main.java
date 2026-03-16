package ParkingLot;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot =new ParkingLotBuilder().createfloor(1,15,10,0,0).build();

        Vehicle car =new Car("acv231");
       ParkingSpot spot= parkingLot.park(car);

       parkingLot.unpark(spot,car);



    }
}
