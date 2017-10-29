package pl.notify.sender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

@Component
@Primary
public class SmsNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        System.out.println("SMS wysyłany po numer " + notification.getTelephone());
    }
}
