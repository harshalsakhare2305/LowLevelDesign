package ParkingLot;

public class Car extends Vehicle{

    private String platenumebr;
    private VehicleType vehicleType;

    Car(String platenumebr){
        super(platenumebr,VehicleType.MEDIUM);
    }
}
