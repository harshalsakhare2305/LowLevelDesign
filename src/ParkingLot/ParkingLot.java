package ParkingLot;
import java.util.*;
public class ParkingLot {
    private List<ParkingLotFloor> parkingLotFloorList;

    ParkingLot(List<ParkingLotFloor> list){
        this.parkingLotFloorList=list;
    }

    ParkingSpot park(Vehicle vehicle){

        VehicleType desiredparkingspot=vehicle.getVehicleType();
        ParkingSpot spot =findAvailableparkingspot(desiredparkingspot);
        int floorid=spot.getFloor();
        ParkingLotFloor f =findfloorbyid(floorid);
        return f.park(vehicle);
    }

    void unpark(ParkingSpot spot  ,Vehicle vehicle){

      int floor =spot.getFloor();
      ParkingLotFloor f =findfloorbyid(floor);

     f.unpark(spot,vehicle);


    }

    ParkingLotFloor findfloorbyid(int id){
        for(ParkingLotFloor p:parkingLotFloorList){
            if(p.getFloorid()==id)return p;
        }
        return  null;
    }

    ParkingSpot findAvailableparkingspot(VehicleType v){
        for(ParkingLotFloor floor:parkingLotFloorList){
            for(ParkingSpot p:floor.getParkingSpotList()){
                if(p.getVehicleType()==v)return p;
            }
        }

        return null;
    }


}
