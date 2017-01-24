package model;

import javafx.scene.control.Alert;
import lombok.Getter;
import service.alerts.AlertService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-22.
 */
public class ConnectionModel {

    @Getter
    private Socket serverSocket;

    public void connectToServer(){

        try {

            serverSocket = new Socket("127.0.0.1",5000);

        } catch (IOException e) {
            System.out.println("Cannot connect to the server.");
            AlertService.showAlert(Alert.AlertType.WARNING, "Connection problems", "Cannot connect to the server.");
        }

        if (serverSocket != null){



        }

    }

    public void sendUsernameToServer(String username) throws IOException {

        if (serverSocket != null){
            PrintWriter sender = new PrintWriter(serverSocket.getOutputStream());
            sender.println(username);
            sender.flush();
        }

    }
}
