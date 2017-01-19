package service;

import lombok.Setter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-19.
 */

public abstract class LoginTypeSuperclass implements LoginType {

    @Setter
    protected String username;
    protected Socket serverSocket;

    @Override
    public void logIn() {}

    protected void sendUsernameToServer() throws IOException {

        if (serverSocket != null){
            PrintWriter sender = new PrintWriter(serverSocket.getOutputStream());
            sender.println(username);
            sender.flush();
        }

    }

}
