package FactoryMethod;

abstract class NotificationCenter {

    public abstract Notification createNotification();

    public void send(String msg) {
        Notification notif = createNotification();
        notif.send(msg);
    }

}
