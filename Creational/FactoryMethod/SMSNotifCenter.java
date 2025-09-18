package FactoryMethod;

public class SMSNotifCenter extends NotificationCenter {

    @Override
    public Notification createNotification() {
        return new SMSNotif();
    }
}
