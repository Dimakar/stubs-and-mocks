package services;

public class WebServiceStub extends WebService {
    @Override
    public int login(String login, String password) {
        return 200;
    }

    @Override
    public int logout() {
        return 200;
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
    }
}
