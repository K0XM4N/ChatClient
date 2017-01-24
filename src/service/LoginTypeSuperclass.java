package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
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
    protected VBox mainContainer;

    public LoginTypeSuperclass(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, VBox mainContainer){
        this.sceneSwitcher =sceneSwitcher;
        this.connectionModel = connectionModel;
        this.mainContainer = mainContainer;
    }

    @Override
    public void logIn() throws IOException {}

    protected void loadChatWindow() throws IOException {

        if (sceneSwitcher != null){
            VBox chatContainer = sceneSwitcher.loadScreen("../view/chatWindow.fxml");
            sceneSwitcher.show(mainContainer,chatContainer);
        }

    }
}
