package pl.notify.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Primary
public class ConsoleNotificationReader implements NotificationReader {

    private static final String EXIT_COMMAND = "EXIT";
    private static final String NEXT_COMMAND = "NEXT";

    private Scanner scanner;

    public ConsoleNotificationReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public List<Notification> getNotifications() throws IOException {
        String option;
        List<Notification> notifications = new ArrayList<>();

        System.out.println("Wpisz NEXT, aby dodać nowe powiadomieenie lub EXIT, aby zakończyć");
        while (!(option = scanner.nextLine()).equals(EXIT_COMMAND)) {
            switch (option) {
                case NEXT_COMMAND:
                    takeNewNotification(notifications);
                    System.out.println("Wpisz NEXT, aby dodać nowe powiadomieenie lub EXIT, aby zakończyć");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji wprowadź jeszcze raz");
            }
        }
        return notifications;
    }

    private void takeNewNotification(List<Notification> notifications) {
        System.out.println("Podaj nazwe uzytkownika");
        String userName = scanner.nextLine();
        System.out.println("Podaj email");
        String email = scanner.nextLine();
        System.out.println("Podaj telefon");
        String telephone = scanner.nextLine();
        System.out.println("Podaj tresc");
        String text = scanner.nextLine();
        notifications.add(new Notification(userName, email, telephone, text));
    }
}
