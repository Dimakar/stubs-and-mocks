package services;

import java.util.Map;

public class WebService {
    private Map<String, String> existUsers = Map.of("User1", "Password1",
            "User2", "Password2",
            "User3", "Password3");
    private boolean isAuth = false;

    public int login(String login, String password) {
        if (isAuth) {
            return 400;
        }
        if (existUsers.containsKey(login)) {
            if (existUsers.get(login).equals(password)) {
                isAuth = true;
                return 200;
            } else {
                return 401;
            }
        }
        return 401;
    }

    public int logout() {
        if (isAuth) {
            isAuth = false;
            return 200;
        }
        return 403;
    }


    public void sendMessage(String message) {
        System.out.println("Message '" + message + "' was sent");
    }
}
