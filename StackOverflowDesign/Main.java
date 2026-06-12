package StackOverflowDesign;

public class Main {
    public static void main(String[] args) {
      StackOverflowService service =new StackOverflowService();

      User harshal = service.createUser("Harshal");

      service.addQuestion("fddd'","ddsdd",harshal);

    }
}
