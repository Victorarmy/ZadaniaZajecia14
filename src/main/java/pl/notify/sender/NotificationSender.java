package pl.notify.sender;

import pl.notify.model.Notification;

public interface NotificationSender {
    void send(Notification notification);
}
