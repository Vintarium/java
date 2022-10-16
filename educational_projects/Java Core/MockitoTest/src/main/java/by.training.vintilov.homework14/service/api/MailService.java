package by.training.vintilov.homework14.service.api;

import by.training.vintilov.homework14.model.User;
import java.util.Map;

public interface  MailService {

    void sendMessageAboutBug();

    String sendFirstInvitation(User user);

    void sendMeDummyMessagesForAllTopics();

    Map<String, User> getDeveloperEmails();
}
