package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import model.ConnectionModel;
import service.sender.SendMessageService;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-23.
 */
@Getter
public class ChatController {

    @FXML
    private TextArea chatTextArea;
    @FXML
    private ListView usersListView;
    @FXML
    private TextField messageTextField;

    private String username;
    private Socket serverSocket;
    private ConnectionModel connectionModel;
    private SendMessageService sendService;

    public void initialize(){
        connectionModel = ConnectionModel.getInstance();
        connectionModel.setOnlineUsersListView(usersListView);
        connectionModel.setChatTextArea(chatTextArea);

        username = connectionModel.getUsername();
        serverSocket = connectionModel.getServerSocket();

        sendService = new SendMessageService(serverSocket,username, messageTextField);
    }

    public void handleConnectItem(ActionEvent event) {

    }

    public void handleDisconnectItem(ActionEvent event) {

    }

    public void handleLogoutItem(ActionEvent event) {
        
    }

    public void handleSendButton(ActionEvent event) throws IOException {
        sendService.sendMessageToServer();
    }
}
