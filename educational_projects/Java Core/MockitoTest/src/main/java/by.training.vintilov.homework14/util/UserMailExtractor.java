package by.training.vintilov.homework14.util;

import by.training.vintilov.homework14.model.User;
import java.util.List;
import org.apache.log4j.*;
import java.util.stream.Collectors;

public final class UserMailExtractor {
    private static final  Logger logger = Logger.getLogger(UserMailExtractor.class.getName());

    private UserMailExtractor() {
    }

    public static List<String> getMailsFromUsers(List<User> users) {
        logger.info("getMailsFromUsers method has been called");
        return users.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());

    }
}
