package service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import model.ConnectionModel;
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
    protected SceneSwitcherModel sceneSwitcher;
    protected ConnectionModel connectionModel;

    public LoginTypeSuperclass(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel){
        this.sceneSwitcher =sceneSwitcher;
        this.connectionModel = connectionModel;
    }

    @Override
    public void logIn() throws IOException {}


}
