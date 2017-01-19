package service;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class GuestService extends LoginTypeSuperclass {


    @Override
    public void logIn() {

        setUsername("Guest");
        connectToServer();

        try {
            sendUsernameToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void connectToServer(){

        try {
            serverSocket = new Socket("127.0.0.1",5001);
        } catch (IOException e) {
            e.printStackTrace();
            //WINDOW POP UP!
        }

    }

    @Override
    protected void sendUsernameToServer() throws IOException {
        super.sendUsernameToServer();
    }
}
