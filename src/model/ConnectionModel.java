package model;

import controller.ChatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import service.alerts.AlertService;
import service.displayer.DisplayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-22.
 */
@Getter
@Setter
public class ConnectionModel {

    private Socket serverSocket;
    private String username;
    private ListView onlineUsersListView;
    private TextArea chatTextArea;

    private static ConnectionModel connectionModel;


    public static ConnectionModel getInstance() {
        if (connectionModel == null){
            connectionModel = new ConnectionModel();
        }
        return connectionModel;
    }

    private ConnectionModel(){

    }




    public boolean connectToServer() throws IOException {

        try {

            serverSocket = new Socket("127.0.0.1",5000);
            return true;

        } catch (IOException e) {

            System.out.println("Cannot connect to the server.");
            AlertService.showAlert(Alert.AlertType.WARNING, "Connection problems", "Cannot connect to the server.");
            return false;

        }

    }

    public void sendUsernameToServer(String username) throws IOException {

        if (serverSocket != null){
            PrintWriter sender = new PrintWriter(serverSocket.getOutputStream());
            sender.println(username);
            sender.flush();
        }

    }

    public void receiveUsernameFromServer() throws IOException {

        if (serverSocket != null) {

            String username;
            InputStreamReader clientInput = new InputStreamReader(serverSocket.getInputStream());
            BufferedReader clientReader = new BufferedReader(clientInput);

            while(true){
                if (!(username = clientReader.readLine()).equals("")){
                    this.username = username;
                    System.out.println("Username: " + username);
                    break;
                }
            }

        }
    }

    public void displayOnlineUser() throws IOException {

        DisplayService userDisplayer = new DisplayService();
        userDisplayer.showUser(onlineUsersListView,username);

    }

}
