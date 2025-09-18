package FactoryMethod;

public class Slacknotif implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("Notification is sending via Slack : " + msg);
    }
}
