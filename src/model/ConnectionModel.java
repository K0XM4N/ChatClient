package model;

import controller.ChatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import lombok.Getter;
import service.alerts.AlertService;
import service.displayer.DisplayService;
import service.displayer.UserDisplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-22.
 */
public class ConnectionModel {

    @Getter
    private Socket serverSocket;

    public void connectToServer() throws IOException {

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

    private ChatController getChatController() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/chatWindow.fxml"));
        Pane pane = loader.load();

        ChatController chatController = loader.getController();

        return chatController;
    }

}
