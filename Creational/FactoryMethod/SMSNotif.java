package FactoryMethod;

public class SMSNotif implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("msg is sending via SMS" + msg);
    }
}
