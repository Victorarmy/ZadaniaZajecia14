package pl.notify.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.logger.NotifyLogger;
import pl.notify.model.Notification;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.NotificationSender;

import java.io.IOException;
import java.util.List;

@Component
@Primary
public class NotificationFacade {
    private NotificationReader reader;
    private NotificationSender sender;
    private NotifyLogger logger;

    @Autowired
    public NotificationFacade(NotificationReader reader, NotificationSender sender, NotifyLogger logger) {
        this.reader = reader;
        this.sender = sender;
        this.logger = logger;
    }

    public void sendNotifications() throws IOException {
        List<Notification> notifications = reader.getNotifications();
        for (Notification notification : notifications) {
            sender.send(notification);
            logger.log(notification.toString());
        }
    }

}
