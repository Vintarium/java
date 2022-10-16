package by.training.vintilov.homework14.service.api;

import by.training.vintilov.homework14.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getCurrentUser();

    List<User> getDevelopers();
}
