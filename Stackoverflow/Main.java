package Stackoverflow;

public class Main {

    public static void main(String[] args) {
        StackOverflowService service =new StackOverflowService();

        User harshal = service.createuser("Harshal");
        User pranav =service.createuser("Pranav");

        // suppose harshal post question
        Question q =new Question("How to resolve this issue?","i got the issue in this this is part of code how can i solve this issue i have also attache the image of the issue plz look into that tell me the possibe solution of this issue.",harshal);

        System.out.println("Bbe");

    }
}
