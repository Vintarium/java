package by.training.vintilov.homework14.service.impl;

import by.training.vintilov.homework14.exception.RecipientsException;
import by.training.vintilov.homework14.model.User;
 import by.training.vintilov.homework14.model.enums.Topic;
 import by.training.vintilov.homework14.service.api.MailSender;
import by.training.vintilov.homework14.service.api.MailService;
import by.training.vintilov.homework14.service.api.MessageCreator;
import by.training.vintilov.homework14.service.api.UserService;
import by.training.vintilov.homework14.util.UserMailExtractor;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import org.apache.log4j.*;
import java.util.stream.Collectors;
import static by.training.vintilov.homework14.model.enums.Topic.BUG;
import static by.training.vintilov.homework14.model.enums.Topic.TASK;

public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class.getName());

    @Inject
    private final MessageCreator messageCreator;

    @Inject
    private final UserService userService;

    @Inject
    private final MailSender mailSender;

    public MailServiceImpl(MessageCreator messageCreator, UserService userService, MailSender mailSender) {
        this.messageCreator = messageCreator;
        this.userService = userService;
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessageAboutBug() {
        LOGGER.info("sendMessageAboutBug method has been called");
        List<User> developers = userService.getDevelopers();
        List<String> recipients = UserMailExtractor.getMailsFromUsers(developers);
        checkRecipients(recipients);
        String message = messageCreator.createMessage(recipients, BUG.getText());
        mailSender.sendMail(message);
    }

    @Override
    public String sendFirstInvitation(User user) {
        LOGGER.info("sendFirstInvitation method has been called");
        String personalMessage = messageCreator.createPersonalMessage(user, TASK.getText());
        mailSender.sendMail(personalMessage);
        return personalMessage;
    }

    @Override
    public void sendMeDummyMessagesForAllTopics() {
        LOGGER.info("sendMeDummyMessagesForAllTopics method has been called");
        User currentUser = userService.getCurrentUser()
                .orElseThrow(NoSuchElementException::new);

        Set<String> messages = getMessagesForUser(currentUser);

        messages.forEach(mailSender::sendMail);
    }

    @Override
    public Map<String, User> getDeveloperEmails() {
        LOGGER.info("getDeveloperEmails method has been called");
         return userService.getDevelopers().stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }

    private void checkRecipients(List<String> recipients) {
        LOGGER.info("checkRecipients method has been called");
        if (recipients.isEmpty()) {
            throw new RecipientsException("Recipients list is empty.");
        }
    }

    private Set<String> getMessagesForUser(User currentUser) {
        LOGGER.info("getMessagesForUser method has been called");
        return Arrays.stream(Topic.values())
                .map(Topic::getText)
                .map(text -> messageCreator.createPersonalMessage(currentUser, text))
                .collect(Collectors.toSet());
    }
}
