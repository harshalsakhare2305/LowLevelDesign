package ParkingLot;

public class SimpleFeeStretegy implements FeeStrategy{

        @Override
    public double calculateFee(int duration, VehicleType v) {
        if(v==VehicleType.SMALL)return duration*1.25;
        else if(v==VehicleType.MEDIUM)return duration*2.25;
        else return duration*3.0;
    }
}
