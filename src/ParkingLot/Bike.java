package ParkingLot;

public class Bike extends Vehicle{
    private String platenumebr;
    private VehicleType vehicleType;

    Bike(String platenumebr){
       super(platenumebr,VehicleType.SMALL);
    }
}
