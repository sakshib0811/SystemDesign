package FactoryMethod;

public class FactoryMethod {

    public static void main(String[] args) {
        NotificationCenter creator;
        creator = new EmailNotifCenter();
        creator.send("Welcome to Factory Method Demo\n");

        creator = new SMSNotifCenter();
        creator.send("welcome to Factory method Demo of SMS\n");

        creator = new SlackNotifCenter();
        creator.send("Slack is added as a new way to send Notification");

    }

}
