package service;

import lombok.Setter;
import model.SceneSwitcherModel;

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
    protected SceneSwitcherModel sceneSwitcher;

    @Override
    public void logIn() throws IOException {}


}
