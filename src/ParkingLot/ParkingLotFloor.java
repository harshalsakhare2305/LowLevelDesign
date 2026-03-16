package ParkingLot;

import java.util.*;

public class ParkingLotFloor {
    private int floorid;
    private List<ParkingSpot> parkingSpotList;
    private Payment payment;
    private Scanner sc;

    ParkingLotFloor(int floorid){
        this.floorid=floorid;
        this.parkingSpotList=new ArrayList<>();
        this.payment=new Card();
        this.sc =new Scanner(System.in);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public int getFloorid() {
        return floorid;
    }

    public Payment getPayment() {
        return payment;
    }

    ParkingSpot park(Vehicle vehicle){

        VehicleType desiredparkingspot=vehicle.getVehicleType();
        ParkingSpot spot =findAvailableparkingspot(desiredparkingspot);
        if(spot==null){
            System.out.println("No parking spot available");
            return null;
        }

        System.out.println("The vehicle with platenumber is been parked at parking spot with id"+spot.getId()+"On the floor"+this.floorid);
        spot.setOccupied(true);
        return spot;
    }

    void unpark(ParkingSpot spot,Vehicle vehicle){

        int id=spot.getId();
        if(spot.isOccupied()){
            System.out.println("Enter the Duration of Parking");
            int duration =sc.nextInt();
             double amt=spot.calcfee(duration);

            System.out.println("Choose mode of Payment 1->UPI 2->Card 3->Cash");
            int choice= sc.nextInt();
           if(choice==1)setPayment(new UPI());
           else if (choice==2) {
               setPayment(new Card());
           }else{
               System.out.println("No other option available (type only upto 2)");
           }

           payment.processPayment(amt);
           spot.setOccupied(false);
            System.out.println("The vehicle with platenumber "+vehicle.getPlatenumebr()+"Has been unparked");



        }
    }

    ParkingSpot findAvailableparkingspot(VehicleType v){
        for(ParkingSpot p:parkingSpotList){
            if(p.getVehicleType()==v)return p;
        }

        return null;
    }

}
