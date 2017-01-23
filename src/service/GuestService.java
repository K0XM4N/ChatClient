package service;

import javafx.scene.control.Alert;
import model.ConnectionModel;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class GuestService extends LoginTypeSuperclass {

    private ConnectionModel connectionModel;

    @Override
    public void logIn() throws IOException {

        setUsername("Guest");

        connectionModel = new ConnectionModel();
        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);

    }

    private void connectToServer(){

        try {
            serverSocket = new Socket("127.0.0.1",5000);
        } catch (IOException e) {
            System.out.println("Cannot connect to the server.");
            AlertService.showAlert(Alert.AlertType.WARNING,"Connection problems","Cannot connect to the server.");
        }

    }

}
