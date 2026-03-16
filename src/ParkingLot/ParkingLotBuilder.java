package ParkingLot;
import java.util.*;
public class ParkingLotBuilder {
    private List<ParkingLotFloor> parkingLotFloorList;

    ParkingLotBuilder(){
        this.parkingLotFloorList=new ArrayList<>();
    }

    ParkingLotBuilder createfloor(int id,int smallspot,int med_spot,int prevsmall,int prevmed){
        ParkingLotFloor floor = new ParkingLotFloor(id);

        List<ParkingSpot> spots =floor.getParkingSpotList();
        for(int i=prevsmall;i<=smallspot+prevsmall;i++){
            spots.add(new SmallParkingSpot(id,i,VehicleType.SMALL,false));
        }

        for(int i=prevmed;i<=smallspot+prevmed+prevsmall;i++){
            spots.add(new MediumParkingSpot(id,i,VehicleType.MEDIUM,false));
        }

        addfloor(floor);
        return this;
    }

    void addfloor(ParkingLotFloor floor){
        this.parkingLotFloorList.add(floor);
    }

    ParkingLot build(){
        return new ParkingLot(this.parkingLotFloorList);
    }


}
