package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Getter;

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

    public void handleConnectItem(ActionEvent event) {

    }

    public void handleDisconnectItem(ActionEvent event) {

    }

    public void handleLogoutItem(ActionEvent event) {

    }

    public void handleSendButton(ActionEvent event) {

    }
}
