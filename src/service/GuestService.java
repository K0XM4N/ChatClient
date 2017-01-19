package service;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class GuestService extends LoginTypeSuperclass {


    @Override
    public void logIn() {

        setUsername("Guest");
        connectToServer();

        try {
            sendUsernameToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void connectToServer(){

        try {
            serverSocket = new Socket("127.0.0.1",5000);
        } catch (IOException e) {
            System.out.println("Cannot connect to the server.");
            AlertService.showAlert(Alert.AlertType.WARNING,"Connection problems","Cannot connect to the server.");
        }

    }

    @Override
    protected void sendUsernameToServer() throws IOException {
        super.sendUsernameToServer();
    }
}
