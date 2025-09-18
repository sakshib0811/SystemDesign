package FactoryMethod;

public class EmailNotif implements Notification {

    @Override
    public void send(String msg) {
        System.out.printf("Notification was sending via Email " + msg);
    }
}
