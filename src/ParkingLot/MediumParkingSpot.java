package ParkingLot;

public class MediumParkingSpot extends  ParkingSpot{
    private int id;
    private int floor;
    private VehicleType vehicleType;
    private boolean isOccupied;

    MediumParkingSpot(int floor,int id,VehicleType v,boolean isOccupied){
        super(floor,id,v,isOccupied);
    }
}
