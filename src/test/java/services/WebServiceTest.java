package services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class WebServiceTest {
    WebService webService = Mockito.mock(WebService.class);

    @Test
    void stubTest() {
        User user = new User("User", "Password1", new WebServiceStub());
        assertEquals(200, user.login());
        user.sendMessage("dsjfksldkgjldjgl");
    }


    @Test
    void mockTest() {
        String message = "This message from user";
        User user = new User("User", "Password1", webService);
        Mockito.when(webService.login(user.getLogin(), user.getPassword())).thenReturn(200);
        assertEquals(200, user.login());
        user.sendMessage(message);
        user.logout();

        verify(webService, Mockito.times(1)).sendMessage(eq(message));
        verify(webService, Mockito.times(1)).login(eq(user.getLogin()), eq(user.getPassword()));
        verify(webService, Mockito.times(1)).logout();
    }
}
