package service.login.logic;

import javafx.scene.layout.VBox;
import lombok.Setter;
import model.ConnectionModel;
import model.ReceiverModel;
import model.SceneSwitcherModel;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-01-19.
 */

public abstract class LoginTypeSuperclass implements LoginType {

    @Setter
    protected String username;
    protected SceneSwitcherModel sceneSwitcher;
    protected ConnectionModel connectionModel;
    protected VBox mainContainer;
    protected ReceiverModel messageReceiver;

    public LoginTypeSuperclass(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, VBox mainContainer){
        this.sceneSwitcher =sceneSwitcher;
        this.connectionModel = connectionModel;
        this.mainContainer = mainContainer;
    }

    @Override
    public void logIn() throws IOException, PropertyVetoException, SQLException, ClassNotFoundException {}

    protected void loadChatWindow() throws IOException {

        if (sceneSwitcher != null){
            VBox chatContainer = sceneSwitcher.loadScreen("../view/chatWindow.fxml");
            sceneSwitcher.show(mainContainer,chatContainer);
        }

    }

    protected void listenForMessage(){

        messageReceiver = new ReceiverModel(true);
        Thread receiver = new Thread(messageReceiver);
        receiver.start();

    }
}
