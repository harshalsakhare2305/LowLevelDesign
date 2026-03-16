package ParkingLot;

public class SmallParkingSpot extends ParkingSpot{
    private int id;
    private int floor;
    private VehicleType vehicleType;
    private boolean isOccupied;

        SmallParkingSpot(int floor,int id,VehicleType v,boolean isOccupied){
         super(floor,id,v,isOccupied);
    }
}
