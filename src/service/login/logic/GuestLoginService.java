package service.login.logic;

import javafx.scene.layout.VBox;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class GuestLoginService extends LoginTypeSuperclass {

    public GuestLoginService(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, VBox mainContainer) {
        super(sceneSwitcher, connectionModel, mainContainer);
    }

    @Override
    public void logIn() throws IOException {

        setUsername("Guest");
        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);
        connectionModel.receiveUsernameFromServer();
        loadChatWindow();
        connectionModel.displayOnlineUser();
        listenForMessage();
    }


}
