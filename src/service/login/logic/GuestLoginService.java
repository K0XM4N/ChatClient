package service.login.logic;

import controller.ChatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    public void logIn() throws IOException, ClassNotFoundException {

        setUsername("Guest");

        if (connectionModel.connectToServer()) {
            connectionModel.sendUsernameToServer(username);
            loadChatWindow();
        }
    }


}
