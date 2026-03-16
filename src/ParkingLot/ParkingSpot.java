package ParkingLot;

public abstract class ParkingSpot {
    private int id;

    private int floor;
    private VehicleType vehicleType;
    private boolean isOccupied;

    private FeeStrategy feeStrategy;

    ParkingSpot(int floor,int id,VehicleType v,boolean isOccupied){
        this.floor=floor;
        this.id=id;
        this.vehicleType=v;
        this.isOccupied=isOccupied;
        this.feeStrategy=new SimpleFeeStretegy();
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public int getFloor() {
        return floor;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    double calcfee(int duration){
        return feeStrategy.calculateFee(duration,this.vehicleType);
    }



    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
