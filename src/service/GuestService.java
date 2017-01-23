package service;

import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class GuestService extends LoginTypeSuperclass {

    public GuestService(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel) {
        super(sceneSwitcher, connectionModel);
    }

    @Override
    public void logIn() throws IOException {

        setUsername("Guest");

        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);

    }


}
