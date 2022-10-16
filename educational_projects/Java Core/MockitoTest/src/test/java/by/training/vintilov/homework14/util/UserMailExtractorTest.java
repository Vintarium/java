package by.training.vintilov.homework14.util;

import by.training.vintilov.homework14.model.User;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UserMailExtractorTest {
    private List<User> list = new ArrayList<>();

    @Test
    public void testGetMailsFromUsers() {
        /*Given*/
        User user = new User();
        user.setEmail("pudovkin@gmail.com");
        list.add(user);
        List<String> expected = new ArrayList<>();
        expected.add("pudovkin@gmail.com");
        /*When*/
        List<String> actual = UserMailExtractor.getMailsFromUsers(list);
        /*Then*/
        Assert.assertEquals(expected, actual);
    }
}