package by.training.vintilov.homework14.service.impl;

import by.training.vintilov.homework14.model.User;
import by.training.vintilov.homework14.service.api.MailSender;
import by.training.vintilov.homework14.service.api.MessageCreator;
import by.training.vintilov.homework14.service.api.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MailServiceImplTest {

    private static final String ERROR_MESSAGE = "Bug was found";
    private User user = null;
    private List<User> developerList = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private Map<String, User> map = new HashMap<>();

    @Mock
    private MessageCreator messageCreatorMock;

    @Mock
    private UserService userServiceMock;

    @Mock
    private MailSender mailSenderMock;

    @InjectMocks
    private MailServiceImpl mailServiceImplInjectMocks;

    @Test
    public void testSendMessageAboutBug() {
        /*Given*/
        user = new User();
        user.setEmail("PupkinIgor@gmail.com");
        user.setFirstName("Igor");
        user.setLastName("Pupkin");
        developerList.add(user);
        /*When*/
        when(userServiceMock.getDevelopers()).thenReturn(developerList);
        when(messageCreatorMock.createMessage(Mockito.anyListOf(String.class), Mockito.eq(ERROR_MESSAGE)))
                .thenReturn(ERROR_MESSAGE);
        mailSenderMock.sendMail("hello");
        /*Then*/
        Assert.assertEquals(ERROR_MESSAGE, userServiceMock.getDevelopers(), developerList);
        Assert.assertEquals(ERROR_MESSAGE, messageCreatorMock.createMessage(list, "Bug was found"));
        verify(userServiceMock, times(1)).getDevelopers();
        verify(messageCreatorMock, times(1)).createMessage(list, "Bug was found");
        verify(mailSenderMock, atLeastOnce()).sendMail("hello");
    }

    @Test
    public void testSendFirstInvitation() {
        /*Given*/
        user = new User();
        user.setFirstName("Igor");
        user.setLastName("Pupkin");
        user.setEmail("PupkinIgor@gmail.com");
        /*When*/
        when(messageCreatorMock.createPersonalMessage(user, "new Message")).thenReturn(ERROR_MESSAGE);
        /*Then*/
        Assert.assertEquals(ERROR_MESSAGE, messageCreatorMock.createPersonalMessage(user, "new Message"));
        verify(messageCreatorMock, times(1)).createPersonalMessage(user, "new Message");
    }

    @Test
    public void testSendMeDummyMessagesForAllTopics() {
        mailServiceImplInjectMocks = mock(MailServiceImpl.class);
        mailServiceImplInjectMocks.sendMeDummyMessagesForAllTopics();
        verify(mailServiceImplInjectMocks, times(1)).sendMeDummyMessagesForAllTopics();

    }

    @Test
    public void testGetDeveloperEmails() {
        when(userServiceMock.getDevelopers()).thenReturn(developerList);
        mailServiceImplInjectMocks.getDeveloperEmails();

        Assert.assertEquals(mailServiceImplInjectMocks.getDeveloperEmails(), map);
        verify(userServiceMock, times(2)).getDevelopers();
    }
}