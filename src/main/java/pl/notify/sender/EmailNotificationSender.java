package pl.notify.sender;

import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

@Component
public class EmailNotificationSender implements NotificationSender {

    public void send(Notification notification) {
        System.out.println("Sending email to " + notification.getEmail());
    }

}
