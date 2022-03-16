package services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private WebService webService;

    public int login() {
        return webService.login(login, password);
    }

    public int logout() {
        return webService.logout();
    }

    public void sendMessage(String message) {
        webService.sendMessage(message);
    }
}
