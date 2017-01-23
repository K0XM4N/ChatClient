package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import lombok.AllArgsConstructor;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class GuestService extends LoginTypeSuperclass {

    public GuestService(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, VBox mainContainer) {
        super(sceneSwitcher, connectionModel, mainContainer);
    }

    @Override
    public void logIn() throws IOException {

        setUsername("Guest");
        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);
        loadChatWindow();

    }


}
