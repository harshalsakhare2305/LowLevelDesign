package ParkingLot;

public abstract class Vehicle {
    private String platenumebr;
    private VehicleType vehicleType;

    Vehicle(String platenumebr,VehicleType v){
        this.platenumebr=platenumebr;
        this.vehicleType=v;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getPlatenumebr() {
        return platenumebr;
    }
}
