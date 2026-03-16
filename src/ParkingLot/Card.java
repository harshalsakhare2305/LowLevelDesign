package ParkingLot;

public class Card implements Payment{

    @Override
    public void processPayment(double amt) {
        System.out.println("The payment of amount equal to "+ amt+"done through the Card Mode");
    }
}
