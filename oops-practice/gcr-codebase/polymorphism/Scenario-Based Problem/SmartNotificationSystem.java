class Notification {
    protected String recipientName;
    protected String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Sending notification to " + recipientName + ": " + message);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email Sent to: " + recipientName);
        System.out.println("Subject: System Update");
        System.out.println("Body: " + message);
        System.out.println("-----------------------------------");
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS Sent to: " + recipientName);
        System.out.println("Text: " + message);
        System.out.println("-----------------------------------");
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Push Notification Alert for " + recipientName);
        System.out.println("Alert: " + message);
        System.out.println("-----------------------------------");
    }
}

public class SmartNotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = new Notification[3];
        notifications[0] = new EmailNotification("Alice", "Your subscription is about to expire. Renew now.");
        notifications[1] = new SMSNotification("Bob", "Your OTP is 482910. Do not share it.");
        notifications[2] = new PushNotification("Charlie", "New direct message from Dave.");

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}
