package ParkingLot;

public class UPI implements Payment{

    @Override
    public void processPayment(double amt) {
        System.out.println("The payment of amount equal to "+ amt+"done through the UPI Mode");
    }
}
