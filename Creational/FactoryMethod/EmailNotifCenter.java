package FactoryMethod;

public class EmailNotifCenter extends NotificationCenter {

    @Override
    public Notification createNotification() {
        return new EmailNotif();
    }
}
