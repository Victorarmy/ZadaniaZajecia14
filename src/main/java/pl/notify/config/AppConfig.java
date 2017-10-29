package pl.notify.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.NotificationSender;
import pl.notify.sender.SmsNotificationSender;

@Configuration
public class AppConfig {

    @Bean
    public NotifyLogger logger() {
        FileLogger fileLogger = new FileLogger();
        return fileLogger;
    }

    @Bean
    public NotificationReader reader() {
        NotificationReader consoleNotificationReader = new ConsoleNotificationReader();
        return consoleNotificationReader;
    }

    @Bean
    public NotificationSender sender() {
        NotificationSender smsNotificationSender = new SmsNotificationSender();
        return smsNotificationSender;
    }

    @Bean
    public NotificationFacade facade(NotifyLogger logger, NotificationReader reader, NotificationSender sender) {
        NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger);
        return notificationFacade;
    }

}
