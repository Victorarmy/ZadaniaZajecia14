package pl.notify.reader;

import pl.notify.model.Notification;

import java.io.IOException;
import java.util.List;

public interface NotificationReader {
    List<Notification> getNotifications() throws IOException;
}
