package FactoryMethod;

public class SlackNotifCenter extends NotificationCenter {

    @Override
    public Notification createNotification() {
        return new Slacknotif();
    }
}
