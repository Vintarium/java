package by.training.vintilov.homework14.service.api;

import by.training.vintilov.homework14.model.User;
import java.util.List;

public interface MessageCreator {

    String createMessage(List<String> recipients, String theme);

    String createPersonalMessage(User user, String theme);
}
