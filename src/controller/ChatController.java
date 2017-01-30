package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Getter;
import model.ConnectionModel;
import service.displayer.DisplayService;
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
    private String textToSet;
    private DisplayService onlineUsersDisplayer;

    public void initialize(){
        connectionModel = ConnectionModel.getInstance();
        connectionModel.setOnlineUsersListView(usersListView);
        connectionModel.setChatTextArea(chatTextArea);

        username = connectionModel.getUsername();
        serverSocket = connectionModel.getServerSocket();

        sendService = new SendMessageService(serverSocket, messageTextField);

        updateOnlineUsers(sendService);


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

    public void setTemporaryText(String textToSet) {
        this.textToSet = textToSet;
    }

    public void setTextOnChatArea(){
        chatTextArea.setText(textToSet);
    }

    public void updateOnlineUsers(SendMessageService sendService){
        onlineUsersDisplayer = new DisplayService(serverSocket, usersListView,sendService);
        Thread update = new Thread(onlineUsersDisplayer);
        update.start();
    }
}
